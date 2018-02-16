package com.kodilla.rps;

final class GameConstantData {
    static final String APP_NAME = "Rock-Paper-Scissors Game 3 or 5 pieces modification avaible v0.4" + System.getProperty("line.separator");
    private static final String TO_DRAW = "TO_DRAW";
    private static final String COMP_WIN = "COMPUTER_WINNER";
    private static final String PLAYER_WIN = "PLAYER_WINNER";
    static final String[][] WINNER_RULES_SCHEMA = {
            {TO_DRAW,    PLAYER_WIN, COMP_WIN, COMP_WIN, PLAYER_WIN},
            {COMP_WIN,   TO_DRAW,    PLAYER_WIN, PLAYER_WIN, COMP_WIN},
            {PLAYER_WIN, COMP_WIN,   TO_DRAW,    COMP_WIN,   PLAYER_WIN},
            {PLAYER_WIN, COMP_WIN,   PLAYER_WIN, TO_DRAW,    COMP_WIN},
            {COMP_WIN,   PLAYER_WIN, COMP_WIN,   PLAYER_WIN, TO_DRAW}
    };
}
