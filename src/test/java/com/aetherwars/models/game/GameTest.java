package com.aetherwars.models.game;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.TurnPhase;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.Spell;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class GameTest {
    @Test
    public void TestGame() {
        try {
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
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

            g.getPlayerBoard().getCards().set(0, Zombie);
            g.getPlayer().setMana(10);
            g.manaToExp(8, 0);
            assertEquals(g.getBoards()[g.getState().getPlayerTurn()].get(0).getExp(), (Integer) 4);
            assertEquals(g.getBoards()[g.getState().getPlayerTurn()].get(0).getLevel(), (Integer) 3);
            assertFalse(g.getCards().equals(g.toString()));
            assertEquals(g.endGame(), -1);

            Spell PTN = new PTN("UP", "-", "-", 999, 999, 2, 1);
            Card potion = new Card(PTN);
            g.getPlayer().getHand().getCards().set(0, potion);
            g.getPlayer().play(0, 0);
            g.getPlayer().attack(0, -1);
            assertEquals((double) g.getEnemy().getHp(), 80 - g.getPlayerBoard().get(0).getAtk());
            assertEquals(g.endGame(), g.getState().getPlayerTurn());
            assertNotSame(g.getEnemyBoard().get(0), Zombie);
            g.getState().nextPhase();
            g.getState().nextPhase();
            g.getState().nextPhase();
            g.getState().nextPhase();
            g.nextTurn();
            assertEquals(g.endGame(), (g.getState().getPlayerTurn() + 1) % 2);
//            g.nextPhase();
//            assertEquals(g.getState().getPhase(), TurnPhase.PLAN);
//            g.nextPhase();
//            g.nextPhase();
//            g.nextPhase();
//            assertEquals(g.getState().getPlayerTurn(), 1);
//            g.nextPhase();
//            g.nextPhase();
//            g.nextPhase();
//            g.nextPhase();
//            assertEquals(g.getState().getTurn(), 2);
//            assertFalse(g.toString().equals("Turn: 2 Player Turn: 0 Phase: DRAW"));
        }
        catch (Exception e) {
            assert false;
        }

    }
}
