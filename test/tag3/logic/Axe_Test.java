
package tag3.logic;

import tag3.logic.Axe;
import tag3.logic.Player;
import tag3.logic.Item;
import static org.junit.Assert.*;
import org.junit.Test;

public class Axe_Test {
    
    @Test
    public void testUseAxe() {
        //Arrange
        Item item = new Axe("Axe", 25);
        Player player = new Player(); 
        int expectedDamageResult = 26;
        //Act
        item.use(player);
        //Assert
        assertEquals(expectedDamageResult, player.getDamage());
    }
}