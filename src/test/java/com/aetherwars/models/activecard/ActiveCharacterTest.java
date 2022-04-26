package com.aetherwars.models.activecard;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ActiveCharacterTest {
    @Test
    public void addExpTest() {
        ActiveCharacter zombie = new ActiveCharacter();
        zombie.addExp(-99999);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(1);
        assertEquals((int) zombie.getExp(), 0);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 2);

        zombie.addExp(2);
        assertEquals((int) zombie.getExp(), 1);

        zombie.addExp(3);
        assertEquals((int) zombie.getExp(), 4);

        zombie.addExp(10000);
        assertEquals((int) zombie.getExp(), 0);
    }

    @Test
    public void levelTest() {
        ActiveCharacter mobita = new ActiveCharacter();
        assertEquals((int) mobita.getLevel(), 1);

        mobita.addExp(1);
        assertEquals((int) mobita.getLevel(), 2);

        mobita.addExp(1);
        assertEquals((int) mobita.getLevel(), 2);

        mobita.addExp(10);
        assertEquals((int) mobita.getLevel(), 4);

        mobita.addExp(-99999);
        assertEquals((int) mobita.getLevel(), 4);

        mobita.addExp(99999);
        assertEquals((int) mobita.getLevel(), 10);
    }
}

