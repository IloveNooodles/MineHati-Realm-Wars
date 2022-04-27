package com.aetherwars.models.game;

import com.aetherwars.enums.TurnPhase;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class GameStateTest {
    
    @Test
    public void TestNextPhase() {
        GameState g = new GameState();
        g.nextPhase();
        assertEquals(g.getPhase(), TurnPhase.PLAN);
        g.nextPhase();
        g.nextPhase();
        g.nextPhase();
        assertEquals(g.getPlayerTurn(), 1);
        g.nextPhase();
        g.nextPhase();
        g.nextPhase();
        g.nextPhase();
        assertEquals(g.getTurn(), 2);
        assertTrue(g.toString().equals("Turn: 2 Player Turn: 0 Phase: DRAW"));
    }
}
