package com.aetherwars.models.cardcontainer;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.exception.EmptyDeckException;
import com.aetherwars.exception.EmptySlotException;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.carddata.Character;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DeckTest {

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
            deck.remove(0);
            assertEquals(deck.get(0), Skeleton);
            assertEquals(deck.getCards().size(), 1);
        }
        catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void TestEmptyDeck() {
        try {
            Deck deck = new Deck();
            deck.remove(0);
        }
        catch (Exception e) {
            if (e.getMessage().equals("Deck is empty!")) {
                assert true;
            }
            else {
                assert false;
            }
        }
    }

    @Test
    public void TestEmptySlot() {
        try {
            Deck deck = new Deck();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Card Pigment = new Card(pigment);
            deck.add(Pigment);
            deck.remove(2);
        }
        catch (Exception e) {
            if (e.getMessage().equals("Slot is empty!")) {
                assert true;
            }
            else {
                assert false;
            }
        }
    }
}
