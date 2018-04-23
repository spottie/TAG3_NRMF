package tag3.logic;

import tag3.logic.Dungeon;
import tag3.logic.Room;
import org.junit.Test;
import static org.junit.Assert.*;

public class Room_Test {

    @Test
    public void testConectRoomWithNorthRoomsNorthRoom() {
        Dungeon dungeon = new Dungeon();
        Room startroom = dungeon.createRoomsInDungeon();
        assertEquals("Name5", startroom.getNorth().getName());
        assertEquals("Name10", startroom.getNorth().getNorth().getName());
    }
}
