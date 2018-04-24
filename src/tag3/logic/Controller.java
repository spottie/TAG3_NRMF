package tag3.logic;

import java.util.Random;
import java.util.ArrayList;
import tag3.tui.Presentation;
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

    Random rand = new Random();
    Dungeon dungeon = new Dungeon();
    Player player = new Player();
    Presentation tui = new Presentation();
    NPC npc;
    MarkoMonster mm;

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
    }

    public void game() throws InterruptedException {
        while (true) {
            tui.separator();
            player.setCorrectRoom(false);
            while (!player.isCorrectRoom()) {
                String inputCommand = tui.inputCommandAllowed(commands());
                commandsDirection(inputCommand);
            }
            tui.separator();
            String activeRoomInfo = player.getActiveRoom().toString();
            tui.showRoomInformation(activeRoomInfo);
            String playerBackpack = player.toString();
            tui.showPlayerBackpack(playerBackpack);
            winGame();
        }
    }

    public void commandsDirection(String inputCommand) throws InterruptedException {

        switch (inputCommand) {
            case NORTH:
                if (!player.movePlayer(player.getActiveRoom().getNorth())) {
                    tui.errorWrongDirection();
                }
                break;
            case SOUTH:
                if (!player.movePlayer(player.getActiveRoom().getSouth())) {
                    tui.errorWrongDirection();
                }
                break;
            case EAST:
                if (!player.movePlayer(player.getActiveRoom().getEast())) {
                    tui.errorWrongDirection();
                }
                break;
            case WEST:
                if (!player.movePlayer(player.getActiveRoom().getWest())) {
                    tui.errorWrongDirection();
                }
                break;
            default:
                commandsOther(inputCommand);
                break;
        }
    }

    public void commandsOther(String inputCommand) throws InterruptedException {
        switch (inputCommand) {
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
                npc = player.getActiveRoom().getNPC();
                if (npc != null) {
                    while (player.isAlive() && npc.isAlive()) {
                        if (player.isAlive()) {
                            player.hit(npc);
                            int npcHealth = npc.getHealth();
                            tui.playerAttack(npcHealth);
                            if (npc.isDead()) {
                                tui.npcDefeated();
                            }
                        }
                        if (npc.isAlive()) {
                            npc.hit(player);
                            int playerHealth = player.getHealth();
                            tui.npcAttack(playerHealth);
                            if (player.isDead()) {
                                tui.playerDied();
                            }
                        }
                        Thread.sleep(2000);
                    }
                    break;
                } else {
                    tui.noMonsterInRoom();
                }
            default:
                break;
        }
    }

    public void winGame() {
        if (player.getActiveRoom().getName().equals(WINROOM)) {
            tui.winGameMessage();
            System.exit(0);
        }
    }

    public ArrayList<String> commands() {
        ArrayList<String> arrCommands = new ArrayList();

        arrCommands.add(NORTH);
        arrCommands.add(SOUTH);
        arrCommands.add(EAST);
        arrCommands.add(WEST);
        arrCommands.add(HELP);
        arrCommands.add(QUIT);
        arrCommands.add(PICK_UP);
        arrCommands.add(USE);
        arrCommands.add(ATTACK);

        return arrCommands;
    }

}
