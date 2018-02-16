package com.kodilla.rps;

import java.util.Random;

class ComputerMovements {
    private String computerChoiceAsString;
    private int computerChoiceAsInteger = 0;

    private int getGame3PiecesVariety() {
        return 3;
    }

    private int getGame5PiecesVariety() {
        return 5;
    }

    String getComputerChoiceAsString() {
        return computerChoiceAsString;
    }

    private void setComputerChoiceAsString(String computerChoiceAsString) {
        this.computerChoiceAsString = computerChoiceAsString;
    }

    int getComputerChoiceAsInteger() {
        return computerChoiceAsInteger;
    }

    private void setComputerChoiceAsInteger(int computerChoiceAsInteger) {
        this.computerChoiceAsInteger = computerChoiceAsInteger;
    }

    int computerGameChoice(boolean isGame5PiecesVariety) {
        Random random = new Random();
        int kindOfGameNumber = isGame5PiecesVariety ? getGame5PiecesVariety() : getGame3PiecesVariety();
        char computerMovementChoice = String.valueOf(random.nextInt(kindOfGameNumber) + 1).charAt(0);
        setComputerChoiceAsInteger(Character.getNumericValue(computerMovementChoice));
        setComputerChoiceAsString(GameChoicesEnum.convertCharToStringName(computerMovementChoice));
        System.out.println("\"Computer\" chosen => " + getComputerChoiceAsString());
        return getComputerChoiceAsInteger();
    }
}
