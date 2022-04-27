package com.aetherwars.models.game;

import com.aetherwars.enums.TurnPhase;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class GameTest {
    @Test
    public void TestNextTurn() {
        Game g = Game.getInstance();
        assertEquals(1, g.getPlayer().getMana());
        assertEquals(1, g.getState().getTurn());
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.nextTurn();
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.getState().nextPhase();
        g.nextTurn();
        assertEquals(2, g.getState().getTurn());
        assertEquals(2, g.getPlayer().getMana());
        // g.nextPhase();
        // assertEquals(g.getPhase(), TurnPhase.PLAN);
        // g.nextPhase();
        // g.nextPhase();
        // g.nextPhase();
        // assertEquals(g.getPlayerTurn(), 1);
        // g.nextPhase();
        // g.nextPhase();
        // g.nextPhase();
        // g.nextPhase();
        // assertEquals(g.getTurn(), 2);
        // assertTrue(g.toString().equals("Turn: 2 Player Turn: 0 Phase: DRAW"));
    }
}
