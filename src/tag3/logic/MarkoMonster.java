package tag3.logic;

import java.util.Random;

public class MarkoMonster extends NPC {
    
    Random rand = new Random();
    private int humanFlagAttack = 20;
    
    public MarkoMonster(String name, int health, int damage) {
        super(name, health, damage);
    }
    
    @Override
    public void autoHit(Player p) {
        p.setHealth(p.getHealth() - this.getDamage());
    }
    
    public void humanFlagAttack(Player p) {
        p.setHealth(p.getHealth() - humanFlagAttack);
    }
    
    public void hit(Player p) {
        int n = rand.nextInt(100) + 1;
        if (n < 90) {
            autoHit(p);
        } else {
            humanFlagAttack(p);
        }   
    }
    
    public boolean isAlive() {
        if(this.getHealth() > 0) return true;
        return false;
    }

    @Override
    public boolean isDead() {
        if(this.getHealth() <= 0) return true;
        return false;
    }
    
}
