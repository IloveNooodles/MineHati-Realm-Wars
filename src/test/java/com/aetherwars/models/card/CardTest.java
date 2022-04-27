package com.aetherwars.models.card;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.enums.SpellEffect;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.LVL;
import com.aetherwars.models.carddata.spell.Spell;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.activecard.*;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CardTest {
    
    @Test
    public void TestCharacterCard() {
        Character pigmen = new Character("pigmen", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        Card Pigmen = new Card(pigmen);
        assertEquals(Pigmen.getCardData().getName(), "pigmen");
        assertNotSame(Pigmen.getName(), "pig");
        assertEquals(Pigmen.getCost(), 1);
        assertNotSame(Pigmen.getCost(), 0);
        System.out.print(pigmen.getDescription());
        assertTrue(pigmen.getDescription().equals("Bau"));
        assertNotSame(pigmen.getDescription(), "bau");
        assertFalse(pigmen.toString().equals(""));
        ActiveCard pig_men = Pigmen.activate();
        assertEquals(((ActiveCharacter) pig_men).getHp(), 5.0);
    }

    @Test
    public void TestSpellCard() {
        Spell lvl = new LVL("Obat mujarap", "iyah", "-", LVLSpell.LVLUP);
        Card Lvl = new Card(lvl);
        assertEquals(Lvl.getCardData().getName(), "Obat mujarap");
        assertNotSame(Lvl.getName(), "Obat");
        assertEquals(Lvl.getCost(), 0);
        assertNotSame(Lvl.getCost(), 1);
        assertNotSame(Lvl.getDescription(), "Iyah");
        assertEquals(Lvl.getDescription(), "iyah");
        assertFalse(Lvl.toString().equals(""));
        ActiveCard lvlUp = Lvl.activate();
        assertEquals(((ActiveSpell) lvlUp).getSpellEffect(), SpellEffect.PERMANENT);
    }
}
