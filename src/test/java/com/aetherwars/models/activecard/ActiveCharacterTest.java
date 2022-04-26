package com.aetherwars.models.activecard;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ActiveCharacterTest {

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
    }

    @Test
    public void addExpTest() {
        ActiveCharacter zombie = new ActiveCharacter();
        zombie.addExp(-99999);
        assertNotSame(zombie.getExp(), -99999);

        zombie.addExp(1);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 2);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 1);

        zombie.addExp(3);
        assertEquals((int) zombie.getExp(), 4);

        zombie.addExp(10000);
        assertNotSame(zombie.getExp(), 10000);
    }

    @Test
    public void levelTest() {
        ActiveCharacter mobita = new ActiveCharacter();
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
        Character pigmen = new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        ActiveCharacter iqi = new ActiveCharacter(pigmen);
        iqi.levelUp();
        assertEquals((int) iqi.getHp(), 6);

        iqi.addExp(5);
        assertEquals((int) iqi.getHp(), 7);

        iqi.levelDown();
        assertNotSame((int) iqi.getHp(), 7);
        assertNotSame((int) iqi.getMaxHp(), 7);

        iqi.swap();
        assertNotSame((int) iqi.getHp(), 5);
        assertNotSame((int) iqi.getMaxHp(), 5);

        iqi.increaseStats(0, 10);
        assertNotSame((int) iqi.getHp(), 15);
        assertEquals((int) iqi.getMaxHp(), 15);
    }
}

