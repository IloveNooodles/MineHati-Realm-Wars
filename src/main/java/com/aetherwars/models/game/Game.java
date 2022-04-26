package com.aetherwars.models.game;

import com.aetherwars.enums.TurnPhase;
import com.aetherwars.exception.EmptyDeckException;
import com.aetherwars.exception.EmptySlotException;
import com.aetherwars.models.card.Card;
import com.aetherwars.models.cardcontainer.Board;
import com.aetherwars.models.carddata.Character;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Game {
    public static final int MAX_CARDS_ON_BOARD = 5;

    public static Game current_game = null;
    private Board[] player_boards;
    private Player[] players;
    private GameState state;
    private IO io;

    // TODO: Hapus klo gamake cli
    private Scanner sc;

    public Game(String player1, String player2) throws IOException, URISyntaxException, EmptyDeckException {
        player_boards = new Board[2];
        players = new Player[2];
        players[0] = new Player(player1);
        players[1] = new Player(player2);
        player_boards[0] = new Board();
        player_boards[1] = new Board();
        state = new GameState();
        io = new IO(players[0], players[1]);

        for (Player player : players) {
            player.draw();
            player.draw();
            player.draw();
        }

        // TODO: Hapus klo gamake cli
        sc = new Scanner(System.in);
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
        }
        else if (state.getPhase() == TurnPhase.DRAW && getPlayer().getDeck().getCards().size() == 0) {
            return state.getPlayerTurn() + 1;
        }
        return -1;
    }

    public void nextPhase() throws Exception {
        int inp1;
        int inp2;
        switch (state.getPhase()) {
            case DRAW:
                getPlayer().draw();
                System.out.println(this);
                System.out.print("ok? ");
                System.out.println(sc.nextLine());
                break;
            case PLAN:
                System.out.println(this);
                System.out.print("hand index: ");
                inp1 = sc.nextInt();
                System.out.print("board index: ");
                inp2 = sc.nextInt();
                while (inp1 >= 0) {
                    try {
                        getPlayer().play(inp1, inp2);
                    } catch (EmptySlotException e) {
                        System.out.println("Slot is empty");
                    }
                    System.out.println(this);
                    System.out.print("hand index: ");
                    inp1 = sc.nextInt();
                    System.out.print("board index: ");
                    inp2 = sc.nextInt();
                }

                // TODO : kalau ada gui, ini hapus, biar langsung panggil fungsi dari button
                // saja
                System.out.println(this);
                System.out.print("mana to convert to exp: ");
                inp1 = sc.nextInt();
                System.out.print("board index: ");
                inp2 = sc.nextInt();
                while (inp1 > 0) {
                    try {
                        manaToExp(inp1, inp2);
                    } catch (EmptySlotException e) {
                        System.out.println("Empty slot");
                    } catch (Exception e) {
                        System.out.println("Not enough mana");
                    }
                    System.out.println(this);
                    System.out.print("mana to convert to exp: ");
                    inp1 = sc.nextInt();
                    System.out.print("board index: ");
                    inp2 = sc.nextInt();
                }
                break;
            case ATTACK:
                System.out.println(this);
                if (!this.getPlayerBoard().isEmpty()) {
                    System.out.print("from: ");
                    inp1 = sc.nextInt();
                    System.out.print("to: ");
                    inp2 = sc.nextInt();
                    while (inp1 >= 0) {
                        getPlayer().attack(inp1, inp2);
                        System.out.println(this);
                        System.out.print("from: ");
                        inp1 = sc.nextInt();
                        System.out.print("to: ");
                        inp2 = sc.nextInt();
                    }
                }
                break;
            case END:
                System.out.println(this);
                System.out.print("ok? ");
                sc.nextLine();
                nextTurn();
                System.out.println("===================next turn===================");
                break;
        }
        state.nextPhase();
    }

    private void nextTurn() {
        System.out.println(Math.min(state.getTurn() + 5, 10)); // TODO : I assume ini harusnya ga + 5, jadi ntar delete
                                                               // + 5 nya
        for (Player player : players) {
            player.setMana(Math.min(state.getTurn() + 5, 10));
        }

        for (Board board : player_boards) {
            board.updateState();
        }
    }

    public void manaToExp(int mana, int target) throws EmptySlotException, Exception { // TODO : bikin exception buat
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
