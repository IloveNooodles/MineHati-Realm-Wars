package com.aetherwars.models.game;

import com.aetherwars.models.card.Card;
import com.aetherwars.models.cardcontainer.Board;
import com.aetherwars.models.carddata.Character;

import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static final int MAX_CARDS_ON_BOARD = 5;

    public static Game current_game = null;
    private Board[] player_boards;
    private Player[] players;
    private GameState state;
    private IO io;


    public Game(String player1, String player2) throws IOException, URISyntaxException {
        player_boards = new Board[2];
        players = new Player[2];
        players[0] = new Player(player1);
        players[1] = new Player(player2);
        player_boards[0] = new Board();
        player_boards[1] = new Board();
        state = new GameState();
        io = new IO(players[0], players[1]);
    }

    public static Game getInstance() throws IOException, URISyntaxException {
        if (current_game == null) {
            current_game = new Game("Player 1", "Player 2");
        }
        return current_game;
    }

    // TODO: Nanti apus soalnya ini buat debug doang
    public String getCards() {
        String res = "";
        for (Card card : players[0].getDeck().getCards()) {
            res += card.toString() + "\n";
        }

        for (Card card : players[1].getDeck().getCards()) {
            res += card.toString() + "\n";
        }

        res += "player 1 decklength: " + players[0].getDeck().getCards().size() + "\n";
        res += "player 2 decklength: " + players[1].getDeck().getCards().size() + "\n";
        return res;
    }

    public Board[] getBoards() {
        return player_boards;
    }

    public Player getPlayer() {
        return players[state.getPlayerTurn()];
    }

    public Board getPlayerBoard() {
        return player_boards[state.getPlayerTurn()];
    }

    public void nextPhase() throws Exception {
        switch (state.getPhase()) {
            case DRAW:
                getPlayer().draw();
                break;
            case PLAN:
                // TODO: Plan buat player
                break;
            case ATTACK:
                // TODO: Attack buat player
                break;
            case END:
                nextTurn();
                break;
        }
    }

    private void nextTurn() {
        for (Player player : players) {
            player.setMana(Math.min(state.getTurn(), 10));
        }

        for (Board board : player_boards) {
            board.updateState();
        }
    }

    public String toString() {
        return "Game State: " + state.toString() + "\n" +
                "Player 1: " + players[0].toString() + "\n" +
                "Player 2: " + players[1].toString() + "\n" +
                "Player 1 Board: " + player_boards[0].toString() + "\n" +
                "Player 2 Board: " + player_boards[1].toString() + "\n";
    }
}
