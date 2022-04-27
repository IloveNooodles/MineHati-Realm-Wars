package com.aetherwars.models.carddata;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.extras.Type;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CharacterTest {
    @Test
    public void emptyCharacterTest() {
        Character test = new Character();
        Character anotherTest = new Character();
        Card empty = test.createCard();
        Card anotherEmpty = anotherTest.createCard();

        assertEquals(test.getBaseAtk(), 0);
        assertEquals(test.getBaseHp(), 0);
        assertEquals(test.getAtkUp(), 0);
        assertEquals(test.getHpUp(), 0);

        assertTrue(test.getType() == null);
        assertTrue(test.toString().equals(anotherTest.toString()));
        assertTrue(empty.getDescription().equals(anotherEmpty.getDescription()));
        assertTrue(empty.getName().equals(anotherEmpty.getName()));
        assertTrue(empty.getCost() == anotherEmpty.getCost());
        assertTrue(empty.getCardData().getImage().equals(anotherEmpty.getCardData().getImage()));
    }

    @Test
    public void loadCharacterTest() {
        Character endermen = new Character("endermen", "tinggi", new Type(CharacterType.END), "-", 8, 20, 5, 5, 5);
        Card endermenCard = endermen.createCard();


        assertEquals(endermen.getType().getCharacterType(), CharacterType.END);
        assertEquals(endermen.getHpUp(), 5);
        assertEquals(endermen.getAtkUp(), 5);
        assertEquals(endermen.getManaCost(), 5);
        assertEquals(endermen.getBaseHp(), 20);
        assertEquals(endermen.getBaseAtk(), 8);
        assertEquals(endermenCard.getName(), "endermen");
        assertEquals(endermenCard.getDescription(), "tinggi");
        assertEquals(endermenCard.getCost(), 5);

        assertTrue(endermenCard.getCardData().getImage().equals("-"));
    }
}