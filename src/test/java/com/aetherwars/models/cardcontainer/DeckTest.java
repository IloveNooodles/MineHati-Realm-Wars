package com.aetherwars.models.cardcontainer;

import com.aetherwars.enums.CharacterType;
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
        Character zombie = new Character("zombie", "Pedang", new Type(CharacterType.OVERWORLD), "-", 5, 5, 1, 2, 3);
        Card Zombie = new Card(zombie);
        Card Pigment = new Card(pigment);
        deck.add(Pigment);
        deck.add(Zombie);
        deck.shuffle();
        assertEquals(deck.getCards().get(0), deck.get(0));
        System.out.println(deck.toString());
        assertTrue(deck.toString().equals("Deck: 2"));
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
            deck.remove(1);
        }
        catch (Exception e) {
            assert true;
        }
    }
}
