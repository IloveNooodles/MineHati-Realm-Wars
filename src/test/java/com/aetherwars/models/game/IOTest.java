package com.aetherwars.models.game;

import com.aetherwars.models.carddata.spell.*;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class IOTest {

    @Test
    public void TestIO() {
        try {
            Player a = new Player("Player 1");
            Player b = new Player("Player 2");
            IO io = new IO(a, b);
            assertEquals(a.getDeck().getCards().size(), 23);
            assertEquals(b.getDeck().getCards().size(),16);
            assertEquals(io.getCharacters().get(1).getName(), "Creeper");
            assertEquals(io.getCharacters().get(5).getName(), "Enderman");
            assertEquals(io.getCharacters().get(10).getName(), "Shulker");
            assertEquals(io.getSpells().get(101).getName(), "Deathly Magic");
            assertTrue(io.getSpells().get(101) instanceof PTN);
            assertEquals(io.getSpells().get(202).getName(), "Potion of Bargaining");
            assertTrue(io.getSpells().get(202) instanceof SWAP);
            assertEquals(io.getSpells().get(303).getName(), "Sugondese");
            assertTrue(io.getSpells().get(303) instanceof MORPH);
            assertEquals(io.getSpells().get(401).getName(), "LVLUP");
            assertTrue(io.getSpells().get(401) instanceof LVL);
        } catch (Exception e) {
            assert false;
        }
    }
}
