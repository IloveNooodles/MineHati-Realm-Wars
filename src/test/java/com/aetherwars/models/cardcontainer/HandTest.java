package com.aetherwars.models.cardcontainer;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.carddata.Character;
import org.junit.Test;

import static junit.framework.TestCase.*;

import com.aetherwars.models.card.Card;

public class HandTest {
    
    @Test
    public void TestAddHand() {
        Hand hand = new Hand();
        Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
        Card Pigment = new Card(pigment);
        hand.add(Pigment);
        assertEquals(hand.getCards().get(0), Pigment);
        assertTrue(hand.toString().equals(Pigment.getName() + " " + Integer.toString(Pigment.getCost()) + "\n"));
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
        }
        catch (Exception e) {
            assert false;
        }
        
    }

    @Test
    public void TestEmptyHand() {
        try {
            Hand hand = new Hand();
            hand.remove(0);
        }
        catch (Exception e) {
            if (e.getMessage().equals("Hand is empty!")) {
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
            Hand hand = new Hand();
            Character pigment = new Character("pigment", "Bau", new Type(CharacterType.NETHER), "aaw", 5, 5, 1, 1, 1);
            Card Pigment = new Card(pigment);
            hand.add(Pigment);
            hand.remove(2);
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
