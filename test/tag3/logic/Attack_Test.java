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
        controller.commands("attack");

        Assert.assertNull(room10.getNPC());
    }
    
    @Test
    public void playerAutoHitTest() {
        Player player = new Player();
        Controller c = new Controller(player);
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 25, 5));
        player.setActiveRoom(room10);
        player.autoHit(room10.getNPC());
        
        Assert.assertEquals(24, room10.getNPC().getHealth());
    }
    
    @Test
    public void playerFrankoKillerKickTest() {
        Player player = new Player();
        Controller c = new Controller(player);
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 25, 5));
        player.setActiveRoom(room10);
        player.frankoKillerKick(room10.getNPC());
        
        Assert.assertEquals(-25, room10.getNPC().getHealth());
    }
    
    @Test
    public void playerHitTest() {
        
        int hitTestHealth = 700;
        
        Player player = new Player();
        Controller c = new Controller(player);
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 2500, 5));
        player.setActiveRoom(room10);
        for (int i = 0; i < 100; i++) {
        player.hit(room10.getNPC());    
        }
        System.out.println(room10.getNPC().getHealth());
        Assert.assertTrue(room10.getNPC().getHealth() > hitTestHealth);
    }
    
    @Test
    public void npcHitTest() {
        
        int hitTestHealth = -400;
        
        Player player = new Player();
        Controller c = new Controller(player);
        NPC npc;
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 2500, 5));
        npc = room10.getNPC();
        player.setActiveRoom(room10);
        for (int i = 0; i < 100; i++) {
        npc.hit(player);    
        }
        System.out.println(player.getHealth());
        Assert.assertTrue(player.getHealth() < hitTestHealth);
    }
    
    @Test
    public void npcAutoHitTest() {
        Player player = new Player();
        Controller c = new Controller(player);
        NPC npc;
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 25, 5));
        npc = room10.getNPC();
        player.setActiveRoom(room10);
        npc.autoHit(player);
        
        Assert.assertEquals(95, player.getHealth());
    }
    
    @Test
    public void markoMonsterHumanFagAttackTest() {
        Player player = new Player();
        Controller c = new Controller(player);
        Room room10 = new Room("Name10", "Description10", new Health_Potion("Health_potion", 0), new MarkoMonster("MarkoMonster", 25, 5));
        MarkoMonster mm = (MarkoMonster)room10.getNPC();
        player.setActiveRoom(room10);
        mm.humanFlagAttack(player);
        
        
        Assert.assertEquals(80, player.getHealth());
    }

}


