package tag3.logic;

public abstract class NPC {

    private String name;
    private int health;
    private int damage;

    public NPC(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    
    
    public abstract void autoHit(Player p);
    
    public abstract void hit(Player p);
    
    public abstract boolean isAlive();
    
    public abstract boolean isDead();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}
