
package tag3.logic;

import tag3.logic.Player;
import tag3.logic.Health_Potion;
import tag3.logic.Item;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Health_Potion_Test {
    
    @Test
    public void testUseHealth_Potion() {
        //Arrange
        Item item = new Health_Potion("Health", 0);
        Player player = new Player(); 
        int expectedDamageResult = 150;
        //Act
        item.use(player);
        //Assert
        assertEquals(expectedDamageResult, player.getHealth());
    }
}