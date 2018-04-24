package tag3.logic;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private int health = 100;
    private int damage = 1;
    private int frankoKillerKick = 50;
    private boolean correctRoom;
    private Room activeRoom;
    private ArrayList<Item> backpack = new ArrayList();

    Random rand = new Random();

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setBackpack(ArrayList<Item> backpack) {
        this.backpack = backpack;
    }

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

    public void hit(NPC n) {
        int r = rand.nextInt(100) + 1;
        if (r < 70) {
            autoHit(n);
        } else {
            frankoKillerKick(n);
        }
    }

    public void autoHit(NPC n) {
        n.setHealth((n.getHealth()) - damage);
    }

    public void frankoKillerKick(NPC n) {
        n.setHealth(n.getHealth() - frankoKillerKick);
    }

    public boolean isAlive() {
        if (this.getHealth() > 0) {
            return true;
        }
        return false;
    }

    public boolean isDead() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
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
