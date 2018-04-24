package tag3.tui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Presentation {

    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String START = "start";
    public static final String HELP = "help";
    public static final String QUIT = "quit";
    public static final String PICK_UP = "pick up";
    public static final String USE = "use";
    public static final String ATTACK = "attack";
    
    Scanner scan = new Scanner(System.in);

    //System
    public void separator() {
        System.out.println("****************************");
    }

    //System
    public void pressEnterToContinue() {
        System.out.println("Press 'Enter' to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Player
    public String inputCreatePlayerName() {
        String input = "";

        while (input.isEmpty()) {
            System.out.println("Please enter your playername: ");
            input = scan.nextLine();

            if (input.isEmpty()) {
                System.out.println("Invalid input. Must not be empty!");
            }
        }

        return input;
    }

    //Player
    public void showPlayerInfo(String playerName) {
        System.out.println("Lets begin the game " + playerName + "!");
    }

    //Game
    public void inputStartGameMessage() {
        String input = "";
        String start = START;

        while (!input.equals(start)) {
            System.out.println("Type 'start' when you're ready to start the game! ");
            input = scan.nextLine();

            if (!input.equals(start)) {
                System.out.println("Invalid input. Type 'start'!");
            }
        }
    }

    //Game
    public void winGameMessage() {
        System.out.println("Congratz, you reched the end of the dungeon! ");
    }

    //Game
    public void quitGameMessage() {
        System.out.println("Quitting game!");
    }

    //Game
    public void showGameInformation() {
        System.out.println("THE DUNGEON GAME...\nIn order to win the game, you must navigate through the dungeon and reach the final boss at room (21).\nYou will need to use the console while playing.\nThe directions you can move ingame is 'north', 'south', 'east' and 'west'.\nYou start at 100 health and 1 damage.\nWrite 'help' for further instructions.\nGood luck fellow!");
    }

    //Game
    public void showGameCommands() {
        System.out.println("Type 'north' in order to navigate in the dungeon!");
        System.out.println("Type 'south' in order to navigate in the dungeon!");
        System.out.println("Type 'east' in order to navigate in the dungeon!");
        System.out.println("Type 'west' in order to navigate in the dungeon!");
        System.out.println("Type 'quit' if you want to stop the game!");
        System.out.println("Type 'help' for having instructions!");
        System.out.println("Type 'start' to start the game!");
        System.out.println("Type 'pick-up' in order to collect an item!");
        System.out.println("Type 'use' in order to use the item!");
        System.out.println("Type 'attack' in order to attack npc!");
    }

    //Help
    public void showHelp() {
        System.out.println("Commands:");
        showGameCommands();
    }

    //Dungeon
    public void createRoomsMessage() {
        System.out.println("Rooms is now created in the dungeon!");
    }

    //Room
    public void showRoomInformation(String activeRoomInfo) {
        System.out.println(activeRoomInfo);
    }

    //Navigate
    public void errorWrongDirection() {
        System.out.println("Wrong direction! Try again!");
    }
    
    //Navigate
    public String inputCommandAllowed(ArrayList<String> commands) {
        
        String input = "";

        while (!commands.contains(input)) {
            System.out.println("Type direction in order to move in the dungeon: ");
            input = scan.nextLine();

            if (!commands.contains(input)) {
                System.out.println("Invalid input. Type 'help' for instructions!");
            }
        }
        
        return input;
    }    
    
    //Item
    public void showPlayerBackpack(String backpack){
        System.out.println(backpack);
    }
    
    //Item
    public void showPlayerPickedUpItem(){
        System.out.println("You have picked up an item in this room to your backpack");
    }
    
    public String itemInput(){
        System.out.println("What item do you want to use?");
        return scan.nextLine();
    }
    
    public void playerAttack(int npcHealth) {
        System.out.println("NPC \nRemaining health: " + npcHealth);
    }
    
    public void npcAttack(int playerHealth) {
        System.out.println("\nPlayer \nRemaining health: " + playerHealth + "\n********************************************");
    }
    
    public void npcDefeated() {
        System.out.println("You defeated the monster! ");
    }
    
    public void playerDied() {
        System.out.println("You died!");
    }
    
    public void noMonsterInRoom() {
        System.out.println("There is not a monster in this room!");
    }
}
