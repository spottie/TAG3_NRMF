package tag3.logic;

import tag3.logic.Dungeon;
import tag3.logic.Player;
import tag3.logic.Room;
import static org.junit.Assert.*;
import org.junit.Test;

public class Player_Test {

    @Test
    public void testPlayerStartRoom() {
        //Arrange
        Player player = new Player();
        Dungeon dungeon = new Dungeon();
        Room startroom = dungeon.createRoomsInDungeon();

        //Act
        player.setActiveRoom(startroom);

        //Assert
        assertEquals("Name1", startroom.getName());
    }

    @Test
    public void testPlayerMoveNorthFromStartRoom() {
        //Arrange
        Player player = new Player();
        Dungeon dungeon = new Dungeon();
        Room startroom = dungeon.createRoomsInDungeon();

        //Act
        player.setActiveRoom(startroom);
        boolean playerGoNorth = player.movePlayer(player.getActiveRoom().getNorth());

        //Assert
        assertTrue(playerGoNorth);
    }

    @Test
    public void testPlayerMoveWestWithoutSouthRoom() {
        //Arrange
        Player player = new Player();
        Dungeon dungeon = new Dungeon();
        Room startroom = dungeon.createRoomsInDungeon();

        //Act
        player.setActiveRoom(startroom);
        boolean playerGoSouth = player.movePlayer(player.getActiveRoom().getSouth());

        //Assert
        assertFalse(playerGoSouth);
    }

    @Test
    public void testPickUp() {
        //Arrange
        Player player = new Player();
        Dungeon dungeon = new Dungeon();
        Room startroom = dungeon.createRoomsInDungeon();
        player.setActiveRoom(startroom);

        //Act
        player.addItemToBackPack(startroom.getItem());

        //Assert
        assertEquals(1, player.getBackpack().size());
        assertNull(startroom.getItem());
    }

}
