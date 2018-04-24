package tag3.logic;

public abstract class Item {

    private String name;
    private int weaponDamage;

    public Item(String name, int weaponDamage) {
        this.name = name;
        this.weaponDamage = weaponDamage;
    }
    
    public String getName() {
        return name;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    
    public abstract void use(Player player);
 
}
