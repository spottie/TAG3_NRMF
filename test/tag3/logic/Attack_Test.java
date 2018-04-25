package tag3.logic;

import org.junit.Assert;
import org.junit.Test;

public class Attack_Test {

    @Test
    public void combatTest() throws InterruptedException {
        Player player = new Player();
        Controller controller = new Controller(player);
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 25, 5));
        player.setActiveRoom(room10);
        controller.commandsOther("attack");

        Assert.assertEquals(true, room10.getNPC().isDead());
    }
    
    

}


