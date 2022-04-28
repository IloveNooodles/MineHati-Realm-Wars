package com.aetherwars.models.game;

import com.aetherwars.enums.TurnPhase;
import com.aetherwars.exception.EmptySlotException;
import com.aetherwars.models.cardcontainer.Board;

import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static final int MAX_CARDS_ON_BOARD = 5;

    public static Game current_game = null;
    private final Board[] player_boards;
    private final Player[] players;
    private final GameState state;


    public Game(String player1, String player2) throws Exception {
        player_boards = new Board[2];
        players = new Player[2];
        players[0] = new Player(player1);
        players[1] = new Player(player2);
        player_boards[0] = new Board();
        player_boards[1] = new Board();
        state = new GameState();
        new IO(players[0], players[1]);

        for (Player player : players) {
            player.draw(0);
            player.draw(0);
            player.draw(0);
        }

    }

    public static Game getInstance() {
        if (current_game == null) {
            try {
                current_game = new Game("Player 1", "Player 2");
            } catch (Exception e) {
                e.printStackTrace();
                throw new Error(e.toString());
            }
        }
        return current_game;
    }


    public GameState getState() {
        return state;
    }

    public Board[] getBoards() {
        return player_boards;
    }

    public Player getPlayer() {
        return players[state.getPlayerTurn()];
    }

    public Player getEnemy() {
        return players[(state.getPlayerTurn() + 1) % 2];
    }

    public Board getPlayerBoard() {
        return player_boards[state.getPlayerTurn()];
    }

    public Board getEnemyBoard() {
        return player_boards[(state.getPlayerTurn() + 1) % 2];
    }

    public int endGame() {
        if (getEnemy().getHp() <= 0) {
            return state.getPlayerTurn();
        } else if (getPlayer().getHp() <= 0) {
            return (state.getPlayerTurn() + 1) % 2;
        } else if (state.getPhase() == TurnPhase.DRAW && getPlayer().getDeck().getCards().size() == 0) {
            return (state.getPlayerTurn() + 1) % 2;
        }
        return -1;
    }


    public void nextTurn() {
        getPlayer().setMana(Math.min(state.getTurn(), 10));
        getPlayerBoard().updateState();
    }

    public void manaToExp(int mana, int target) throws Exception { // TODO : bikin exception buat
        // ini
        int playerMana = getPlayer().getMana();
        if (getPlayerBoard().get(target).getName().equals("")) {
            throw new EmptySlotException();
        }
        if (mana > playerMana) {
            throw new Exception();
        }
        getPlayer().setMana(playerMana - mana);
        getPlayerBoard().get(target).addExp(mana);
    }

    public String toString() {
        return "Game State: \n" + state.toString() + "\n\n" +
                "Player 1: " + players[0].toString() + "\n\n" +
                "Player 2: " + players[1].toString() + "\n" +
                "Player 1 Board: \n" + player_boards[0].toString() + "\n" +
                "Player 2 Board: \n" + player_boards[1].toString() + "\n";
    }
}
