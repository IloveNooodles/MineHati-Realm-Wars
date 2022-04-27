package com.aetherwars.models.activecard;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.LVL;
import com.aetherwars.models.carddata.spell.MORPH;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.SWAP;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ActiveCardTest {

    @Test
    public void loadCharacterTest() {
        Character kosong = new Character();
        assertNotSame(kosong.getType(), CharacterType.NETHER);
        assertNotSame(kosong.getBaseAtk(), 12);
        assertNotSame(kosong.getBaseHp(), -1215);
        assertNotSame(kosong.getAtkUp(), 128512);
        assertNotSame(kosong.getHpUp(), -12415);

        Character pigmen = new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        assertNotSame(pigmen.getName(), "ujang");
        assertEquals(pigmen.getName(), "pigmen");
        assertNotSame(pigmen.getDescription(), "bau");
        assertEquals(pigmen.getDescription(), "Bau");
        assertNotSame(pigmen.getType(), CharacterType.NETHER);
        assertEquals(pigmen.getType().getCharacterType(), CharacterType.NETHER);
        assertEquals(pigmen.getBaseAtk(), 5);
        assertEquals(pigmen.getBaseHp(), 5);
        assertEquals(pigmen.getManaCost(), 1);
        assertEquals(pigmen.getAtkUp(), 1);
        assertEquals(pigmen.getHpUp(), 1);

        ActiveCharacter Pigmen = new ActiveCharacter(pigmen);
        assertTrue(Pigmen.getName().equals(pigmen.getName()));
        assertTrue(Pigmen.getDescription().equals(pigmen.getDescription()));
    }

    @Test
    public void addExpTest() {
        //udah mati karakternya
        ActiveCharacter zombie = new ActiveCharacter();
        zombie.addExp(-99999);
        assertNotSame(zombie.getExp(), -99999);

        zombie.addExp(1);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(3);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(10000);
        assertNotSame(zombie.getExp(), 10000);
    }

    @Test
    public void levelTest() {
        ActiveCharacter mobita = new ActiveCharacter(new Character("Mobita", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1));
        assertEquals((int) mobita.getLevel(), 1);

        mobita.addExp(1);
        assertEquals((int) mobita.getLevel(), 2);

        mobita.addExp(1);
        assertEquals((int) mobita.getLevel(), 2);

        mobita.addExp(10);
        assertEquals((int) mobita.getLevel(), 4);

        mobita.addExp(-99999);
        assertEquals((int) mobita.getLevel(), 4);

        mobita.addExp(99999);
        assertEquals((int) mobita.getLevel(), 10);

        mobita.levelDown();
        mobita.levelDown();
        assertEquals((int) mobita.getLevel(), 8);

        mobita.levelUp();
        mobita.levelUp();
        assertEquals((int) mobita.getLevel(), 10);
    }

    @Test
    public void healthTest() {
        Character pigmen = new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 2, 1);
        ActiveCharacter iqi = new ActiveCharacter(pigmen);
        iqi.levelUp();
        assertEquals((int) iqi.getHp(), 6);

        iqi.addExp(5);
        assertEquals((int) iqi.getHp(), 7);

        iqi.levelDown();
        assertEquals((int) iqi.getHp(), 6);
        assertEquals((int) iqi.getMaxHp(), 6);

        iqi.swap();
        assertNotSame((int) iqi.getMaxHp(), 6);
        assertNotSame((int) iqi.getHp(), 7);
        assertEquals((int) iqi.getMaxHp(), 7);

        iqi.increaseStats(0, 10);
        assertNotSame((int) iqi.getHp(), 17);
        assertEquals((int) iqi.getMaxHp(), 17);
    }

    @Test
    public void attackOverworldTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        Character skeleteon = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);
        ActiveCharacter Skeleton = new ActiveCharacter(skeleteon);

        assertEquals((int) Zombie.getAtk(), 5);

        Zombie.addExp(1);
        assertNotSame((int) Zombie.getAtk(), 5);
        assertEquals((int) Zombie.getAtk(), 7);

        Zombie.attack(Skeleton);
        assertTrue(Zombie.hasAttacked());
        assertNotSame(Skeleton.getHp(), 6);
        assertTrue(Skeleton.getHp() == 0.0);

        Zombie.levelUp();
        Zombie.levelUp();
        Zombie.levelDown();
        assertNotSame((int) Zombie.getAtk(), 8);
        assertEquals((int) Zombie.getAtk(), 9);

        Zombie.increaseStats(-5, 0);
        assertEquals((int) Zombie.getAtk(), 4);

        // udah mati jdi harusnya gabisa
        Skeleton.attack(Zombie);
        assertFalse(Skeleton.hasAttacked());
        assertNotSame(Zombie.getHp(), 5);
        assertTrue(Zombie.getHp() == 11.0);
    }

    @Test
    public void attackNetherTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        Character pigmen = new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "-", 7, 10, 3, 3, 4);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);
        ActiveCharacter Pigmen = new ActiveCharacter(pigmen);

        assertFalse(Zombie.toString().equals(Pigmen.toString()));

        Zombie.levelUp();
        Zombie.levelUp();
        Zombie.levelUp();
        assertEquals(Zombie.getHp(), 14.0);

        Zombie.attack(Pigmen);
        assertTrue(Zombie.hasAttacked());
        assertNotSame(Pigmen.getHp(), 0.0);
        assertEquals(Pigmen.getHp(), 4.5);

        Zombie.levelDown();

        //Zombie udah mati tpi diattack
        Pigmen.attack(Zombie);
        assertTrue(Pigmen.hasAttacked());
        assertNotSame(Zombie.getHp(), 4);
        assertTrue(Zombie.getHp() == 0.0);
    }

    @Test
    public void attackEndTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        Character endermen = new Character("endermen", "Bau", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);
        ActiveCharacter Endermen = new ActiveCharacter(endermen);

        Zombie.addExp(6);
        assertEquals(Zombie.getAtk(), 9.0);

        Zombie.attack(Endermen);
        assertTrue(Zombie.hasAttacked());
        assertNotSame(Endermen.getHp(), 11.0);
        assertEquals(Endermen.getHp(), 2.0);

        Endermen.attack(Zombie);
        assertTrue(Endermen.hasAttacked());
        assertNotSame(Zombie.getHp(), 3.0);
        assertEquals(Zombie.getHp(), 3.0);
    }

    @Test
    public void morphTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);

        Zombie.addExp(99999);

        Character endermen = new Character("endermen", "Bau", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5);
        Zombie.morph(endermen);
        assertNotSame(Zombie.getLevel(), 10);
        assertEquals((int) Zombie.getLevel(), 1);

        assertNotSame(Zombie.getAtk(), 5);
        assertEquals(Zombie.getAtk(), 8.0);

        assertNotSame(Zombie.getHp(), 5.0);
        assertEquals(Zombie.getHp(), 20.0);

        assertEquals(Zombie.getMaxHp(), 20.0);
    }

    @Test
    public void activeSpellTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);

        //LEVEL
        ActiveSpell lvlup = new ActiveSpell(new LVL("Obat mujarap", "iyah", "-", LVLSpell.LVLUP));
        ActiveSpell lvldown = new ActiveSpell(new LVL("Obat mujarap", "iyah", "-", LVLSpell.LVLDOWN));

        Zombie.addActiveSpell(lvlup);
        Zombie.addActiveSpell(lvlup);
        assertEquals((int) Zombie.getLevel(), 3);

        Zombie.addActiveSpell(lvldown);
        assertEquals((int) Zombie.getLevel(), 2);

        //PTN

        //HARUSNYA ERROR??
//        ActiveSpell ptn = new ActiveSpell(new PTN("idiotic", "-", "-", -999, -999, -999, -999));
        ActiveSpell ptnATK = new ActiveSpell(new PTN("atkUP", "-", "-", 999, 0, 0, 1));
        ActiveSpell ptnHEALTH = new ActiveSpell(new PTN("healthUP", "-", "-", 0, 999, 0, 3));
        Zombie.addActiveSpell(ptnATK);
        Zombie.addActiveSpell(ptnHEALTH);
        assertEquals(Zombie.getAtk(), 1006.0);
        assertEquals(Zombie.getMaxHp(), 1007.0);

        Zombie.updateState();

        assertNotSame(Zombie.getAtk(), 1006.0);
        assertEquals(Zombie.getAtk(), 7.0);

        Zombie.updateState();
        Zombie.updateState();
        assertNotSame(Zombie.getMaxHp(), 1007.0);
        assertEquals(Zombie.getMaxHp(), 8.0);

        //SWAP
        ActiveSpell swap = new ActiveSpell(new SWAP("AMOGUS", "-", "-", 1, 2));
        Zombie.addActiveSpell(swap);
        assertEquals(Zombie.getMaxHp(), 7.0);
        assertEquals(Zombie.getAtk(), 8.0);

        Zombie.updateState();

        assertEquals(Zombie.getMaxHp(), 8.0);
        assertEquals(Zombie.getAtk(), 7.0);


        //MORPH
        ActiveSpell morph = new ActiveSpell(new MORPH("Ramuan ajaib", "-", "-", new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "-", 7, 10, 3, 3, 4), 10));
        Zombie.addActiveSpell(morph);
        assertEquals(Zombie.getAtk(), 7.0);
        assertEquals(Zombie.getHp(), 10.0);
        assertEquals(Zombie.getMaxHp(), 10.0);
        assertEquals((int) Zombie.getExp(), 0);
        assertEquals((int) Zombie.getLevel(), 1);
    }

    @Test
    public void createCardTest() {
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        Card c = zombie.createCard();

        assertTrue(c.getCardData().toString().equals(zombie.toString()));
        assertTrue(c.getName().equals(zombie.getName()));
        assertTrue(c.getDescription().equals(zombie.getDescription()));
        assertTrue(c.getCost() == zombie.getManaCost());
        assertTrue(c.getCardData().getImage().equals(zombie.getImage()));
    }
}

