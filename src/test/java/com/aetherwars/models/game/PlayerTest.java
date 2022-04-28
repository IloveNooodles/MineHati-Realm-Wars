package com.aetherwars.models.game;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.enums.LVLSpell;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.LVL;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.Spell;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PlayerTest {

    @Test
    public void TestDraw() {
        try {
            Player p = new Player("aira");
            assertEquals(p.getMana(), 1);
            assertTrue(p.getName().equals("aira"));

            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            Spell PTN = new PTN("UP", "-", "-", 999, 999, 0, 1);
            Spell LVL = new LVL("Obat mujarap", "iyah", "-", LVLSpell.LVLUP);
            Card lvlUp = new Card(LVL);
            Card potion = new Card(PTN);
            Card Skeleton = new Card(skeleton);
            Card Pigment = new Card(pigment);

            p.getDeck().add(lvlUp);
            p.getDeck().add(Skeleton);
            p.getDeck().add(potion);
            p.getDeck().add(Pigment);

            p.draw(1);

            assertEquals(p.getHand().get(0), Skeleton);
            assertEquals(p.getDeck().get(1), potion);

            p.getDeck().add(potion);
            p.getDeck().add(Pigment); //now deck 5
            for (int i = 0; i < 4; i++) {
                p.draw(0);
            }

            assertEquals(p.getHand().getCards().size(), 5);
            assertEquals(p.getHand().get(3), Pigment);
            assertEquals(p.getHand().get(4), potion);

            p.draw(0);
            assertEquals(p.getHand().get(0), lvlUp);
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void TestAttacked() {
        Player p = new Player("aira");
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        ActiveCharacter Zombie = new ActiveCharacter(zombie);

        p.attacked(Zombie);
        assertEquals(p.getHp(), 75);
    }

    @Test
    public void TestPlayandAttack() {
        try {
            Game.current_game = new Game("Player 1", "Player 2");
            Game g = Game.getInstance();
            g.getPlayer().setMana(10);
            System.out.println(g);
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            Spell PTN = new PTN("UP", "-", "-", 999, 999, 2, 1);
            Card Skeleton = new Card(skeleton);
            Card potion = new Card(PTN);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            ActiveCharacter s = new ActiveCharacter(skeleton);


            g.getPlayer().getHand().getCards().set(0, Skeleton);
            g.getPlayer().getHand().getCards().set(1, potion);
            g.getPlayerBoard().remove(0);
            g.getPlayer().toString();

            g.getPlayer().play(0, 0);

            assertEquals(g.getPlayerBoard().get(0).getCard().getName(), "skeleton");
            assertEquals(g.getPlayerBoard().get(0).getCard().getBaseAtk(), skeleton.getBaseAtk());

            g.getPlayer().attack(0, -1);
            assertEquals(g.getEnemy().getHp(), 74);

            g.getEnemyBoard().getCards().set(0, Zombie);
            g.getPlayerBoard().getCards().set(1, s);
            g.getPlayer().attack(1, 0);
            assertEquals(g.getPlayerBoard().get(1).getHp(), 7.0);
            assertEquals(g.getEnemyBoard().get(0).getHp(), 0.0);
            assertEquals(g.getEnemy().getHp(), 74);

            g.getPlayer().play(0, 0);

            assertEquals(g.getPlayer().getMana(), 7);
            assertEquals(g.getPlayerBoard().get(0).getAtk(), 1005.0);
        } catch (Exception e) {
            assert false;
        }
    }
}
