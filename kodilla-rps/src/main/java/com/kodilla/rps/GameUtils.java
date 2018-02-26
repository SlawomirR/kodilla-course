package com.kodilla.rps;

import java.util.Scanner;

class GameUtils {
    static final int COMPUTER_ARRAY_INDEX = 0;
    static final int HUMAN_ARRAY_INDEX = 1;
    int roundNumberToWin;
    int currentRoundNumber = 1;
    boolean exitConfirmed = false;
    int[] scoresArray = {0, 0};

    void checkIfGameIsEnded() {
        if (roundNumberToWin <= Math.abs(scoresArray[COMPUTER_ARRAY_INDEX] - scoresArray[HUMAN_ARRAY_INDEX])) {
            exitConfirmed = true;
        }
    }

    String showGameSummary(String humanName) {
        String result = "---=> The state of the great game \"Computer\" versus \"" + humanName
                + "\" is: " + scoresArray[COMPUTER_ARRAY_INDEX] + " : " + scoresArray[HUMAN_ARRAY_INDEX]
                + " and completed rounds we have: " + currentRoundNumber;
        currentRoundNumber++;
        return result;
    }

    private String readWinnerFromSchema(int computerChoiceInteger, int humanChoiceInteger) {
        return GameConstantData.WINNER_RULES_SCHEMA[computerChoiceInteger - 1][humanChoiceInteger - 1];

    }

    String showAndCompareMovementsResult(int computerChoiceInteger, int humanChoiceInteger, String humanName) {
        String readWinnerFromSchema = readWinnerFromSchema(computerChoiceInteger, humanChoiceInteger);
        String result = "";
        switch (readWinnerFromSchema) {
            case "TO_DRAW":
                result = "Amazing ... we have a draw!!! No scores added.";
                break;
            case "PLAYER_WINNER":
                result = "\"" + humanName + "\" won because \"Computer\" chose: "
                        + GameChoicesEnum.convertCharToStringName(Character.forDigit(computerChoiceInteger, 10));
                scoresArray[HUMAN_ARRAY_INDEX]++;
                break;
            case "COMPUTER_WINNER":
                result = "\"Computer\" won because chose: "
                        + GameChoicesEnum.convertCharToStringName(Character.forDigit(computerChoiceInteger, 10))
                        + " and \"" + humanName + "\" chose: "
                        + GameChoicesEnum.convertCharToStringName(Character.forDigit(humanChoiceInteger, 10));
                scoresArray[COMPUTER_ARRAY_INDEX]++;
                break;
        }
        return result;
    }

    String sayGoodbyeAndCloseScanner(Scanner userInputsScanner) {
        closeScanner(userInputsScanner);
        return "Goodbye";
    }

    private void closeScanner(Scanner userInputsScanner) {
        userInputsScanner.close();
    }

    static String showApplicationName() {
        return GameConstantData.APP_NAME;
    }

    char takeUserScannerInputAsChar(Scanner inputScanner) {
        return inputScanner.next().toLowerCase().charAt(0);
    }

    boolean acceptedGreaterThanZeroValue(char takenUserInputInteger) {
        return Character.isDigit(takenUserInputInteger) && Character.getNumericValue(takenUserInputInteger) > 0;
    }

    void askRoundNumberToWin(Scanner userInputsScanner) {
        System.out.print("How many round wins against the opponent will end our game?: ");
        char takenUserInputInteger = takeUserScannerInputAsChar(userInputsScanner);
        while ( ! acceptedGreaterThanZeroValue(takenUserInputInteger)) {
            System.out.print("Enter the number corresponding to the expected number of rounds won relative to the opponent: ");
            takenUserInputInteger = takeUserScannerInputAsChar(userInputsScanner);
        }
        roundNumberToWin = Character.getNumericValue(takenUserInputInteger);
    }
}
