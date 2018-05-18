package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

abstract class APlayersMovements {

    private Map<Character, String> movementName;
    private String playerName;

    abstract Character playerGameChoice(int gameVariety);

    APlayersMovements(String playerName) {
        this.playerName = playerName;
        movementName = new HashMap<>();
        movementName.put('1', "ROCK");
        movementName.put('2', "PAPER");
        movementName.put('3', "SCISSORS");
        movementName.put('4', "LIZARD");
        movementName.put('5', "SPOCK");
    }

    String getMovementName(Character move) {
        return movementName.get(move);
    }

    String getPlayerName() {
        return playerName;
    }

    void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
