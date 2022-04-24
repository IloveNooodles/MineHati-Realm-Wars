package com.aetherwars.models.game;

import com.aetherwars.enums.TurnPhase;

public class GameState {
    private int turn;
    private int player_turn;
    private TurnPhase phase;

    public GameState() {
        turn = 1;
        player_turn = 0;
        phase = TurnPhase.DRAW;
    }

    public String toString() {
        return "Turn: " + turn + " Player: " + player_turn + " Phase: " + phase;
    }

    public void nextPhase() {
        switch (phase) {
            case DRAW:
                phase = TurnPhase.PLAN;
                break;
            case PLAN:
                phase = TurnPhase.ATTACK;
                break;
            case ATTACK:
                phase = TurnPhase.END;
                break;
            default:
                phase = TurnPhase.DRAW;
                turn += 1;
                player_turn = (player_turn + 1) % 2;
        }
    }

    public int getTurn() {
        return turn;
    }

    public int getPlayerTurn() {
        return player_turn;
    }

    public TurnPhase getPhase() {
        return phase;
    }
}

