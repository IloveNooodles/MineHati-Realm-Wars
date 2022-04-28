package com.aetherwars.models.carddata.spell;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class SpellTest {
    @Test
    public void LVLTest() {
        LVL newlvl = new LVL("stonks", "test123", "-", LVLSpell.LVLUP);
        LVL downlvl = new LVL("not stonks", "test1234", "-", LVLSpell.LVLDOWN);
        ActiveCharacter empty = new ActiveCharacter();
        ActiveCharacter enderman = new ActiveCharacter(new Character("endermen", "tinggi", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5));


        assertNotSame(newlvl.getType(), (LVLSpell.LVLDOWN));

        assertEquals(newlvl.getType(), LVLSpell.LVLUP);
        assertEquals(newlvl.getDuration(), -1);

        newlvl.activateEffect(empty);
        newlvl.activateEffect(empty);
        newlvl.activateEffect(empty);

        assertTrue(empty.getLevel() == 1);
        assertTrue(empty.getExp() == 0);

        downlvl.activateEffect(empty);
        downlvl.activateEffect(empty);
        downlvl.activateEffect(empty);

        newlvl.activateEffect(empty);
        newlvl.activateEffect(empty);

        assertFalse(empty.getLevel() == 2);
        assertTrue(empty.getHp() == 0);

        newlvl.activateEffect(enderman);
        newlvl.activateEffect(enderman);

        assertTrue(enderman.getLevel() == 3);

        downlvl.activateEffect(enderman);
        assertTrue(enderman.getLevel() == 2);
    }

    @Test
    public void MORPHTest() {
        MORPH morph = new MORPH("Ujang", "-", "-", new Character(), 1);
        MORPH zombie = new MORPH("Zombie", "rawr", "-", new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3), 5);

        assertEquals(morph.getName(), "Ujang");
        assertEquals(morph.getDescription(), "-");
        assertEquals(zombie.getDescription(), "rawr");
        assertEquals(zombie.getName(), "Zombie");
        assertEquals(zombie.getImage(), morph.getImage());

        assertTrue(morph.getDuration() == -1);
        assertTrue(zombie.getDuration() == -1);
        assertTrue(zombie.getManaCost() == 5);
        assertTrue(morph.getManaCost() == 1);

        ActiveCharacter empty = new ActiveCharacter();
        ActiveCharacter enderman = new ActiveCharacter(new Character("endermen", "tinggi", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5));

        morph.activateEffect(empty);

        assertEquals(empty.getName(), "");
        assertTrue(empty.getExp() == 0);
        assertTrue(empty.getLevel() == 1);

        zombie.activateEffect(empty);
        assertEquals(empty.getName(), "zombie");
        assertEquals(empty.getDescription(), "Pedang");
        assertEquals(empty.getCard().getImage(), "-");
        assertEquals(empty.getCard().getManaCost(), 1);
        assertFalse(empty.getCard().getType().getCharacterType() == CharacterType.END);

        morph.activateEffect(enderman);
        assertEquals(enderman.getCard().getType(), null);
        assertFalse(enderman.getName() == morph.getName());
        assertFalse(enderman.getDescription() == morph.getDescription());
        assertFalse(enderman.getCard().getImage() == morph.getImage());
        assertFalse(enderman.getCard().getManaCost() == morph.getManaCost());

        zombie.activateEffect(enderman);
        assertEquals(enderman.getName(), "zombie");
        assertEquals(enderman.getDescription(), "Pedang");
        assertEquals(enderman.getCard().getImage(), "-");
        assertEquals(enderman.getCard().getManaCost(), 1);
        assertEquals(enderman.getCard().getType().getCharacterType(), CharacterType.OVERWORLD);

        assertFalse(empty == enderman);
    }

    @Test
    public void PTNTest() {
        ActiveCharacter enderman = new ActiveCharacter(new Character("endermen", "tinggi", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5));
        PTN statUp = new PTN("statUp", "stonks", "-", 10, 10, 1, 2);
        PTN statDown = new PTN("statDown", "not stonks", "-", -20, -20, 1, 3);

        assertTrue(statUp.getAtkBonus() == 10);
        assertFalse(statDown.getHpBonus() == 20);
        assertFalse(statUp.getDuration() == 3);
        assertFalse(statDown.getDuration() == 2);

        assertEquals(enderman.getName(), "endermen");
        assertEquals(enderman.getDescription(), "tinggi");
        assertEquals(enderman.getHp(), 20.0);
        assertEquals(enderman.getAtk(), 8.0);
        assertEquals(enderman.getMaxHp(), 20.0);
        assertEquals(enderman.getCard().getType().getCharacterType(), CharacterType.END);

        enderman.addActiveSpell(new ActiveSpell(statUp));
        assertEquals(enderman.getAtk(), 18.0);
        assertEquals(enderman.getHp(), 30.0);
        assertEquals(enderman.getMaxHp(), 20.0);

        enderman.addActiveSpell(new ActiveSpell(statDown));
        enderman.addActiveSpell(new ActiveSpell(statDown));
        assertEquals(enderman.getHp(), 0.0);
        assertEquals(enderman.getAtk(), 0.0);
    }

    @Test
    public void swapTest() {
        SWAP p = new SWAP("bom bunuh diri", "test", "-", 1, 1);
        ActiveCharacter enderman = new ActiveCharacter(new Character("endermen", "tinggi", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5));

        assertEquals(p.getDuration(), 1);
        p.activateEffect(enderman);
        assertEquals(enderman.getHp(), 8.0);
        assertEquals(enderman.getAtk(), 20.0);
        enderman.toString();
    }
}