package tag3.logic;

public class MarkoMonster extends NPC {

    
    public MarkoMonster(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void autoHit(boolean attackTurn, Player p) {
        p.setHealth(p.getHealth() - this.getDamage());
        super.setAttackTurn(false);
        p.setAttackTurn(true);
    }

    public void humanFlagAttack(boolean attackTurn, Player p) {
        p.setHealth(p.getHealth() - 20);
        super.setAttackTurn(false);
        p.setAttackTurn(true);
    }
     
}
