package tag3.logic;

public class Axe extends Item{

    public Axe(String name, int weaponDamage) {
        super(name, weaponDamage);
    }
    
    @Override
    public void use(Player player) {
        player.increaseDamage(getWeaponDamage());
    }
    
    
}
