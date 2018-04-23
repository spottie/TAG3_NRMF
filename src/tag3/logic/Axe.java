package tag3.logic;

public class Axe extends Item{
    
    private int damage = 25;
    
    public Axe(String name) {
        super(name);
    }

    @Override
    public void use(Player player) {
        player.increaseDamage(damage);
    }
    
    
}
