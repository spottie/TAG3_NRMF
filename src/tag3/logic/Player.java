package tag3.logic;

import java.util.ArrayList;

public class Player {

    private String name;
    private int health = 100;
    private int damage = 1;
    private boolean correctRoom;
    private Room activeRoom;
    private ArrayList<Item> backpack = new ArrayList();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isCorrectRoom() {
        return correctRoom;
    }

    public Room getActiveRoom() {
        return activeRoom;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorrectRoom(boolean correctRoom) {
        this.correctRoom = correctRoom;
    }

    public void setActiveRoom(Room activeRoom) {
        this.activeRoom = activeRoom;
    }

    public boolean movePlayer(Room room) {
        if (room == null) {
            return false;
        } else {
            activeRoom = room;
            correctRoom = true;
            return true;
        }
    }

    public void addItemToBackPack(Item item) {
        if (item != null) {
            backpack.add(item);
            activeRoom.setItemPickedUp(item);
        }
    }

    public void useItem(String input) {
        for (int item = 0; item < backpack.size(); item++) {
            if (backpack.get(item).getName().equalsIgnoreCase(input)) {
                backpack.get(item).use(this);
                backpack.remove(item);
            }
        }
    }

    public void increaseHealth(int healthPotion) {
        this.health += healthPotion;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public String toString() {
        if (backpack.isEmpty()) {
            return "Player Backpack: No items";
        } else {
            String overview = "";
            for (int i = 0; i < backpack.size(); i++) {
                Item item = backpack.get(i);
                overview += " " + item.getName();
            }
            return "Player Backpack: " + overview;
        }
    }
}
