package tag3.logic;

import java.util.ArrayList;
import tag3.data.HighScoreFile;
import tag3.data.HighScoreUI;
import tag3.tui.Presentation;
import tag3.logic.Room;
import static tag3.tui.Presentation.ATTACK;
import static tag3.tui.Presentation.EAST;
import static tag3.tui.Presentation.HELP;
import static tag3.tui.Presentation.NORTH;
import static tag3.tui.Presentation.PICK_UP;
import static tag3.tui.Presentation.QUIT;
import static tag3.tui.Presentation.SOUTH;
import static tag3.tui.Presentation.USE;
import static tag3.tui.Presentation.WEST;

public class Controller {

    private final String WINROOM = "Name21";
    private final String FILENAME = "highscore.txt";

    Dungeon dungeon = new Dungeon();
    HighScore highscore = new HighScore();
    HighScoreUI highscoreUI = new HighScoreFile();
    Player player;
    Presentation tui = new Presentation();
    NPC npc;

    public Controller(Player player) {
        this.player = player;
    }

    public void play() throws InterruptedException {
        player();
        dungeon();
        information();
        start();
        game();
    }

    public void player() {
        tui.separator();
        String name = tui.inputCreatePlayerName();
        player.setName(name);
        tui.separator();
        String playerName = player.getName();
        tui.showPlayerInfo(playerName);
    }

    public void dungeon() {
        tui.separator();
        Room startroom = dungeon.createRoomsInDungeon();
        player.setActiveRoom(startroom);
        tui.createRoomsMessage();
    }

    public void information() {
        tui.separator();
        tui.showGameInformation();
        tui.pressEnterToContinue();
    }

    public void start() {
        tui.separator();
        tui.inputStartGameMessage();
        tui.separator();
        String activeRoomInfo = player.getActiveRoom().toString();
        tui.showRoomInformation(activeRoomInfo);
        highscore.setStart();
    }

    public void game() throws InterruptedException {
        while (true) {
            tui.separator();
            player.setCorrectRoom(false);
            while (!player.isCorrectRoom()) {
                String inputCommand = tui.inputCommandAllowed();
                commands(inputCommand);
            }
            tui.separator();
            String activeRoomInfo = player.getActiveRoom().toString();
            tui.showRoomInformation(activeRoomInfo);
            String playerBackpack = player.toString();
            tui.showPlayerBackpack(playerBackpack);
            winGame();
        }
    }

    public void commands(String inputCommand) throws InterruptedException {

        switch (inputCommand) {
            case NORTH:
                if (player.getActiveRoom().getNPC() != null) {
                    tui.cantMoveWhenMonsterAlive();
                    break;
                }
                else if (!player.movePlayer(player.getActiveRoom().getNorth())) {
                    tui.errorWrongDirection();
                }
                break;
            case SOUTH:
                if (player.getActiveRoom().getNPC() != null) {
                    tui.cantMoveWhenMonsterAlive();
                    break;
                }
                else if (!player.movePlayer(player.getActiveRoom().getSouth())) {
                    tui.errorWrongDirection();
                }
                break;
            case EAST:
                if (player.getActiveRoom().getNPC() != null) {
                    tui.cantMoveWhenMonsterAlive();
                    break;
                }
                else if (!player.movePlayer(player.getActiveRoom().getEast())) {
                    tui.errorWrongDirection();
                }
                break;
            case WEST:
                if (player.getActiveRoom().getNPC() != null) {
                    tui.cantMoveWhenMonsterAlive();
                    break;
                }
                else if (!player.movePlayer(player.getActiveRoom().getWest())) {
                    tui.errorWrongDirection();
                }
                break;
            case HELP:
                tui.separator();
                tui.showHelp();
                tui.separator();
                break;
            case QUIT:
                tui.separator();
                tui.quitGameMessage();
                tui.separator();
                System.exit(0);
                break;
            case PICK_UP:
                player.addItemToBackPack(player.getActiveRoom().getItem());
                tui.separator();
                tui.showPlayerPickedUpItem();
                tui.separator();
                String playerBackpack = player.toString();
                tui.showPlayerBackpack(playerBackpack);
                tui.separator();
                break;
            case USE:
                String itemInput = tui.itemInput();
                player.useItem(itemInput);
                String playerBackpackNew = player.toString();
                tui.showPlayerBackpack(playerBackpackNew);
                break;
            case ATTACK:
                combat();
                break;
            default:
                tui.errorCommandAllowed();
                break;
        }
    }
    
    public void setNpcInRoomToNull() {
        if(player.getActiveRoom().getNPC().getHealth() <= 0) {
            player.getActiveRoom().setNpc(null);
//            if(player.getActiveRoom().getNPC() == null) {
//                System.out.println("DET LYKKEDES!!!!");
//            }
        }
    }

    public void winGame() {
        if (player.getActiveRoom().equals(WINROOM) && player.getActiveRoom().getNPC().getHealth() <= 0) {
            tui.winGameMessage();
            highscore.setEnd();
            highscoreUI.addHighscoreToFile(FILENAME, highscore.getHighscoreInfo(player));
            System.exit(0);
        }
    }
    
    public void combat() throws InterruptedException {
        npc = player.getActiveRoom().getNPC();
                if (npc != null) {
                    while (player.isAlive() && npc.isAlive()) {
                        playerCombat();
                        setNpcInRoomToNull();
                        Thread.sleep(2000);
                        npcCombat();
                    }
                } else {
                    tui.noMonsterInRoom();
                }
    }

    public void playerCombat() {
        if (player.isAlive()) {
            player.hit(npc);
            int npcHealth = npc.getHealth();
            tui.playerAttack(npcHealth);
            if (npc.isDead()) {
                tui.npcDefeated();
            }
        }
    }

    public void npcCombat() {
        if (npc.isAlive()) {
            npc.hit(player);
            int playerHealth = player.getHealth();
            tui.npcAttack(playerHealth);
            if (player.isDead()) {
                tui.playerDied();
                System.exit(0);
            }
        }
    }
}
