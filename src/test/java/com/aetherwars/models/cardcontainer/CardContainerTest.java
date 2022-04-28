package com.aetherwars.models.cardcontainer;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.exception.BoardFullException;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.carddata.Character;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.SWAP;
import com.aetherwars.models.carddata.spell.Spell;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.game.Game;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CardContainerTest {
    @Test
    public void TestAddBoard() {
        try {
            Board board = new Board();
            assertTrue(board.isEmpty());
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            ActiveCharacter Skeleton = new ActiveCharacter(skeleton);
            board.add(Zombie);
            board.add(2, Skeleton);
            assertEquals(board.getCards().get(0), Zombie);
            assertEquals(board.get(2).getAtk(), 6.0);
            assertFalse(board.isEmpty());
        } catch (BoardFullException e) {
            assert false;
        }
    }

    @Test
    public void TestRemoveBoard() {
        try {
            Board board = new Board();
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            ActiveCharacter Skeleton = new ActiveCharacter(skeleton);
            board.add(Zombie);
            board.add(2, Skeleton);
            ActiveCharacter removed = board.remove(2);
            assertEquals(removed, Skeleton);
            assertEquals(board.getCards().get(2).getDescription(), "An Empty Card");
            assertEquals(board.get(0).getName(), "zombie");
        } catch (BoardFullException e) {
            assert false;
        }
    }

    @Test
    public void TestBoardFullandEmpty() {
        try {
            Board board = new Board();
            assertTrue(board.isEmpty());
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            ActiveCharacter Skeleton = new ActiveCharacter(skeleton);
            board.add(Zombie);
            board.add(Zombie);
            board.add(3, Skeleton);
            board.add(4, Skeleton);
            board.add(Zombie);
            board.add(Skeleton);
        } catch (BoardFullException e) {
            assert true;
        }
    }

    @Test
    public void TestGetCard() {
        try {
            Board board = new Board();
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            board.add(Zombie);
            assertNotSame(board.toString(), board.get(0).toString() + "\n");
            assertEquals(board.getCards().get(0).getAtk(), 5.0);
            assertEquals(board.getCards().get(0).getHp(), Zombie.getHp());
            assertTrue(board.getCards().get(0).getDescription().equals(Zombie.getDescription()));
            assertTrue(board.getCards().get(0).getName().equals(Zombie.getName()));
        } catch (BoardFullException e) {
            assert false;
        }
    }

    @Test
    public void TestUpdateState() {
        try {
            Board board = new Board();
            Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 7, 1, 1, 1);
            ActiveCharacter Zombie = new ActiveCharacter(zombie);
            ActiveCharacter Skeleton = new ActiveCharacter(skeleton);
            ActiveSpell ptn = new ActiveSpell(new PTN("UP", "-", "-", 999, 999, 0, 1));
            ActiveSpell swap = new ActiveSpell(new SWAP("AMOGUS", "-", "-", 1, 2));

            board.add(Zombie);
            board.add(Skeleton);
            board.get(0).addActiveSpell(ptn);
            board.get(1).addActiveSpell(swap);
            assertEquals(board.get(0).getAtk(), 1004.0);
            assertEquals(board.get(1).getAtk(), 7.0);
            board.updateState();
            assertEquals(board.get(0).getAtk(), 5.0);
            assertEquals(board.get(1).getAtk(), 6.0);
        } catch (BoardFullException e) {
            assert false;
        }
    }

    @Test
    public void TestAddDeck() {
        Deck deck = new Deck();
        Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        Card Pigment = new Card(pigment);
        deck.add(Pigment);
        deck.shuffle();
        assertEquals(deck.getCards().get(0).getCost(), Pigment.getCost());
        assertTrue(deck.getCards().get(0).getName().equals(Pigment.getName()));
        assertTrue(deck.toString().equals("Deck: 1"));
    }

    @Test
    public void TestRemoveDeck() {
        try {
            Deck deck = new Deck();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            Card Skeleton = new Card(skeleton);
            Card Pigment = new Card(pigment);
            deck.add(Pigment);
            deck.add(Skeleton);
            Card removed = deck.remove(0);
            assertEquals(removed, Pigment);
            assertEquals(deck.get(0), Skeleton);
            assertEquals(deck.getCards().size(), 1);
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void TestEmptyDeck() {
        try {
            Deck deck = new Deck();
            deck.remove(0);
        } catch (Exception e) {
            if (e.getMessage().equals("Deck is empty!")) {
                assert true;
            } else {
                assert false;
            }
        }
    }

    @Test
    public void TestEmptySlotDeck() {
        try {
            Deck deck = new Deck();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Card Pigment = new Card(pigment);
            deck.add(Pigment);
            deck.remove(2);
        } catch (Exception e) {
            if (e.getMessage().equals("Slot is empty!")) {
                assert true;
            } else {
                assert false;
            }
        }
    }

    @Test
    public void TestAddHand() {
        Hand hand = new Hand();
        Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        Card Pigment = new Card(pigment);
        hand.add(Pigment);
        assertEquals(hand.getCards().get(0), Pigment);
        assertTrue(hand.toString().equals(Pigment.getName() + " " + Pigment.getCost() + "\n"));
    }

    @Test
    public void TestRemoveHand() {
        try {
            Hand hand = new Hand();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Character skeleton = new Character("skeleton", "Panah", new Type(CharacterType.OVERWORLD), "-", 6, 6, 1, 1, 1);
            Card Skeleton = new Card(skeleton);
            Card Pigment = new Card(pigment);
            hand.add(Pigment);
            hand.add(Skeleton);
            Card removed = hand.remove(0);
            assertEquals(removed, Pigment);
            assertEquals(hand.get(0), Skeleton);
            assertEquals(hand.getCards().size(), 1);
        } catch (Exception e) {
            assert false;
        }

    }

    @Test
    public void TestEmptyHand() {
        try {
            Hand hand = new Hand();
            hand.remove(0);
        } catch (Exception e) {
            if (e.getMessage().equals("Hand is empty!")) {
                assert true;
            } else {
                assert false;
            }
        }
    }

    @Test
    public void TestEmptySlotHand() {
        try {
            Hand hand = new Hand();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Card Pigment = new Card(pigment);
            hand.add(Pigment);
            hand.remove(2);
        } catch (Exception e) {
            if (e.getMessage().equals("Slot is empty!")) {
                assert true;
            } else {
                assert false;
            }
        }
    }

    @Test
    public void TestActivate() {
        try {
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Spell PTN = new PTN("UP", "-", "-", 999, 999, 0, 1);
            Card Pigment = new Card(pigment);
            Card potion = new Card(PTN);

            Hand hand = new Hand();
            Board board = Game.getInstance().getPlayerBoard();
            hand.add(Pigment);
            hand.add(potion);

            hand.activate(0, 0);
            assertEquals(board.get(0).getName(), pigment.getName());

            hand.activate(0, 0);
            assertEquals(board.get(0).getAtk(), 1004.0);
            hand.add(Pigment);
            hand.activate(0, 0);
        } catch (Exception e) {
            if (e.getMessage().equals("Cannot replace existing card")) {
                assert true;
            } else {
                assert false;
            }
        }
    }

    @Test
    public void TestActivatetoEmpty() {
        try {
            Spell PTN = new PTN("UP", "-", "-", 999, 999, 0, 1);
            Card potion = new Card(PTN);
            Hand hand = new Hand();
            hand.add(potion);
            hand.activate(0, 1);
        } catch (Exception e) {
            if (e.getMessage().equals("Slot is empty!")) {
                assert true;
            } else {
                assert false;
            }
        }
    }
}
