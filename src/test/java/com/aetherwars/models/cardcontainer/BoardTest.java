package com.aetherwars.models.cardcontainer;

import com.aetherwars.enums.CharacterType;
import com.aetherwars.models.activecard.ActiveCharacter;
import com.aetherwars.models.activecard.ActiveSpell;
import com.aetherwars.models.carddata.spell.PTN;
import com.aetherwars.models.carddata.spell.SWAP;
import com.aetherwars.models.extras.Type;
import com.aetherwars.models.carddata.Character;
import org.junit.Test;

import static junit.framework.TestCase.*;

import com.aetherwars.exception.BoardFullException;

public class BoardTest {
    
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
        }
        catch (BoardFullException e) {
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
            board.remove(2);
            assertEquals(board.getCards().get(2).getDescription(), "An Empty Card");
            assertEquals(board.get(0).getName(), "zombie");
        }
        catch (BoardFullException e) {
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
        }
        catch (BoardFullException e) {
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
        }
        catch (BoardFullException e) {
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
            assertEquals(board.get(0).getMaxHp(), 1004.0);
            assertEquals(board.get(1).getAtk(), 7.0);
            assertEquals(board.get(1).getMaxHp(), 6.0);
            board.updateState();
            assertEquals(board.get(0).getAtk(), 5.0);
            assertEquals(board.get(0).getMaxHp(), 5.0);
            assertEquals(board.get(1).getAtk(), 6.0);
            assertEquals(board.get(1).getMaxHp(), 7.0);
        }
        catch (BoardFullException e) {
            assert false;
        }
    }
}
