package tag3.logic;

public abstract class NPC {

    private int health;
    private int damage;
    private boolean attackTurn;

    public boolean isAttackTurn() {
        return attackTurn;
    }

    public void setAttackTurn(boolean attackTurn) {
        this.attackTurn = attackTurn;
    }
    
    public NPC(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }
    
    
    public abstract void autoHit(boolean attackTurn, Player p);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}
