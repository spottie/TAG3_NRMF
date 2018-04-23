package tag3.logic;

public class Health_Potion extends Item {
    
    private int healthPotion = 50;
    
    public Health_Potion(String name) {
        super(name);
    }

    @Override
    public void use(Player player) {
        player.increaseHealth(healthPotion);
    }
    
}
