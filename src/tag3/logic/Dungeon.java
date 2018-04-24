package tag3.logic;

public class Dungeon {

    private Room room1 = new Room("Name1", "Description1", new Health_Potion("Health_potion", 0), null);
    private Room room2 = new Room("Name2", "Description2", null, null);
    private Room room3 = new Room("Name3", "Description3", null, null);
    private Room room4 = new Room("Name4", "Description4", null, null);
    private Room room5 = new Room("Name5", "Description5", null, null);
    private Room room6 = new Room("Name6", "Description6", new Axe("Axe", 25), null);
    private Room room7 = new Room("Name7", "Description7", null, null);
    private Room room8 = new Room("Name8", "Description8", new Axe("Axe", 25), null);
    private Room room9 = new Room("Name9", "Description9", null, null);
    private Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 250, 5));
    private Room room11 = new Room("Name11", "Description11", null, null);
    private Room room12 = new Room("Name12", "Description12", null, null);
    private Room room13 = new Room("Name13", "Description13", null, null);
    private Room room14 = new Room("Name14", "Description14", null, null);
    private Room room15 = new Room("Name15", "Description15", new Axe("Bloodthirst Axe", 32), null);
    private Room room16 = new Room("Name16", "Description16", null, null);
    private Room room17 = new Room("Name17", "Description17", null, null);
    private Room room18 = new Room("Name18", "Description18", null, null);
    private Room room19 = new Room("Name19", "Description19", null, null);
    private Room room20 = new Room("Name20", "Description20", null, null);
    private Room room21 = new Room("Name21", "Description21", new Health_Potion("Health_potion", 0), new MarkoMonster ("Final_Boss", 400, 5));
    
    public Room createRoomsInDungeon(){
        //Room 1 - Directions
        room1.setEast(room2);
        room1.setNorth(room5);
        
        //Room 2 - Directions
        room2.setWest(room1);
        room2.setNorth(room6);
        
        //Room 3 - Directions
        room3.setEast(room4);
        
        //Room 4 - Directions
        room4.setWest(room3);
        room4.setNorth(room9);
        
        //Room 5 - Directions
        room5.setEast(room6);
        room5.setNorth(room10);
        room5.setSouth(room1);
        
        //Room 6 - Directions
        room6.setWest(room5);
        room6.setSouth(room2);
        
        //Room 7 - Directions
        room7.setNorth(room12);
        
        //Room 8 - Directions
        room8.setNorth(room13);
        
        //Room 9 - Directions
        room9.setEast(room10);
        room9.setSouth(room4);
        
        //Room 10 - Directions
        room10.setEast(room11);
        room10.setWest(room9);
        room10.setNorth(room15);
        room10.setSouth(room5);
        
        //Room 11 - Directions
        room11.setEast(room12);
        room11.setWest(room10);
        
        //Room 12 - Directions
        room12.setEast(room13);
        room12.setWest(room11);
        room12.setNorth(room17);
        room12.setSouth(room7);
        
        //Room 13 - Directions
        room13.setWest(room12);
        room13.setSouth(room8);
        
        //Room 14 - Directions
        room14.setEast(room15);
        
        //Room 15 - Directions
        room15.setEast(room16);
        room15.setWest(room14);
        room15.setNorth(room20);
        room15.setSouth(room10);
        
        //Room 16 - Directions
        room16.setEast(room17);
        room16.setWest(room15);
        room16.setNorth(room21);
        
        //Room 17 - Directions
        room17.setEast(room18);
        room17.setWest(room16);
        room17.setSouth(room12);
        
        //Room 18 - Directions
        room18.setWest(room17);
        
        //Room 19 - Directions
        room19.setEast(room20);
        
        //Room 20 - Directions
        room20.setWest(room19);
        room20.setSouth(room15);
        
        //Room 21 - Directions
        room21.setSouth(room16);
        
        return room1;
    }

}
