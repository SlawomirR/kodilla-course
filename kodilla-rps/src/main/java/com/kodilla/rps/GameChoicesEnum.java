package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

enum GameChoicesEnum {
    ROCK('1', "Rock"),
    PAPER('2', "Paper"),
    SCISSORS('3', "Scissors"),
    LIZARD('4', "Lizard"),
    SPOCK('5', "Spock"),
    NEW_GAME('n', "New Game"),
    EXIT('x', "Exit"),
    STANDARD('s', "3 Pieces Game Variety"),
    EXTENDED('e', "5 Pieces Game Variety");

    private final String choiceName;

    private static class EnumToMapHolder {
        static final Map<Character, GameChoicesEnum> enumToMapHolder = new HashMap<>();
    }

    GameChoicesEnum(char choiceChar, String choiceName) {
        this.choiceName = choiceName;
        EnumToMapHolder.enumToMapHolder.put(choiceChar, this);
    }

    static String convertCharToStringName(char humanMovementChoice) {
        if (EnumToMapHolder.enumToMapHolder.containsKey(humanMovementChoice)) {
            return EnumToMapHolder.enumToMapHolder.get(humanMovementChoice).choiceName;
        } else {
            return "WARNING: You press wrong key!";
        }
    }
}
