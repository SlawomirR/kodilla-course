package com.kodilla.rps;

import java.util.Random;

class ComputerMovements {
    private static final int GAME_3PCS_VARIETY = 3;
    private static final int GAME_5PCS_VARIETY = 5;
    private String computerChoiceAsString;
    private int computerChoiceAsInteger = 0;

    String getComputerChoiceAsString() {
        return computerChoiceAsString;
    }

    int getComputerChoiceAsInteger() {
        return computerChoiceAsInteger;
    }

    int computerGameChoice(boolean isGame5PiecesVariety) {
        Random random = new Random();
        int kindOfGameNumber = isGame5PiecesVariety ? GAME_5PCS_VARIETY : GAME_3PCS_VARIETY;
        char computerMovementChoice = String.valueOf(random.nextInt(kindOfGameNumber) + 1).charAt(0);
        computerChoiceAsInteger = Character.getNumericValue(computerMovementChoice);
        computerChoiceAsString = GameChoicesEnum.convertCharToStringName(computerMovementChoice);
        System.out.println("\"Computer\" chosen => " + getComputerChoiceAsString());
        return getComputerChoiceAsInteger();
    }
}
