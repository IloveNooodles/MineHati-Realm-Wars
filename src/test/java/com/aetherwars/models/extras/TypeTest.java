package com.aetherwars.models.extras;

import com.aetherwars.enums.CharacterType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TypeTest {
    @Test
    public void OverworldTest() {
        Type overworld = new Type(CharacterType.OVERWORLD);
        Type anotherOverworld = new Type(CharacterType.OVERWORLD);
        Type nether = new Type(CharacterType.NETHER);
        Type end = new Type(CharacterType.END);
        assertEquals(overworld.compareTo(anotherOverworld), 0);
        assertEquals(overworld.compareTo(nether), -1);
        assertEquals(overworld.compareTo(end), 1);
    }

    @Test
    public void NetherTest() {
        Type nether = new Type(CharacterType.NETHER);
        Type anotherNether = new Type(CharacterType.NETHER);
        Type overworld = new Type(CharacterType.OVERWORLD);
        Type end = new Type(CharacterType.END);
        assertEquals(nether.compareTo(anotherNether), 0);
        assertEquals(nether.compareTo(overworld), 1);
        assertEquals(nether.compareTo(end), -1);
    }

    @Test
    public void EndTest() {
        Type end = new Type(CharacterType.END);
        Type anotherEnd = new Type(CharacterType.END);
        Type overworld = new Type(CharacterType.OVERWORLD);
        Type nether = new Type(CharacterType.NETHER);
        assertEquals(end.compareTo(anotherEnd), 0);
        assertEquals(end.compareTo(overworld), -1);
        assertEquals(end.compareTo(nether), 1);
    }

}