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

    public boolean nextPhase() {
        switch (phase) {
            case DRAW:
                phase = TurnPhase.PLAN;
                return false;
            case PLAN:
                phase = TurnPhase.ATTACK;
                return false;
            case ATTACK:
                phase = TurnPhase.END;
                return false;
            default:
                phase = TurnPhase.DRAW;
                turn += 1;
                player_turn = (player_turn + 1) % 2;
                return true;
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

