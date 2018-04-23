package tag3.logic;

public class Room {
    
    private String name, description;
    private Room east, west, north, south;
    private Item item;

    public Room(String name, String description, Item item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }
    
    public Item getItem() {
        return item;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }
    
    public void setItemPickedUp(Item item) {
        this.item = null;
    }

    @Override
    public String toString() {
        if(item == null){
            return "Room Name: " + name + "\nRoom Description: " + description;
        }
        else {
            return "Room Name: " + name + "\nRoom Description: " + description + "\nRoom Item: " + item.getName();
        }
    }
}
