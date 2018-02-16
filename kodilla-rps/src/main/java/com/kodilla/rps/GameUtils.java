package com.kodilla.rps;

import java.util.Scanner;

class GameUtils {
    private int roundNumberToWin;
    private int currentRoundNumber = 1;
    private boolean exitConfirmed = false;
    private int[] scoresArray = {0, 0};

    int getRoundNumberToWin() {
        return roundNumberToWin;
    }

    void setRoundNumberToWin(int roundNumberToWin) {
        this.roundNumberToWin = roundNumberToWin;
    }

    int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    void setCurrentRoundNumber(int currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    private void setScoresArray(int[] scoresArray) {
        this.scoresArray = scoresArray;
    }

    boolean isExitConfirmed() {
        return exitConfirmed;
    }

    void setExitConfirmed() {
        this.exitConfirmed = true;
    }

    private int[] getScoresArray() {
        return scoresArray;
    }

    private void setComputerScore(int computerScore) {
        this.scoresArray[0] = computerScore;
    }

    int getComputerScore() {
        return getScoresArray()[0];
    }

    void increaseComputerScoreByOne() {
        setComputerScore(getComputerScore()+1);
    }

    private void setHumanScore(int humanScore) {
        this.scoresArray[1] = humanScore;
    }

    int getHumanScore() {
        return getScoresArray()[1];
    }

    private void increaseHumanScoreByOne() {
        setHumanScore(getHumanScore()+1);
    }

    private void increaseCurrentRoundNumberByOne() {
        setCurrentRoundNumber(getCurrentRoundNumber()+1);
    }

    void resetScoresArrayForNewGame() {
        setScoresArray(new int[]{0,0});
    }

    void checkIfGameIsEnded() {
        if (getRoundNumberToWin() <= Math.abs(getComputerScore() - getHumanScore())) {
            setExitConfirmed();
        }
    }

    String showGameSummary(String humanName) {
        String result = "---=> The state of the great game \"Computer\" versus \"" + humanName
                + "\" is: " + getComputerScore() + " : " + getHumanScore()
                + " and completed rounds we have: " + getCurrentRoundNumber();
        increaseCurrentRoundNumberByOne();
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
                increaseHumanScoreByOne();
                break;
            case "COMPUTER_WINNER":
                result = "\"Computer\" won because chose: "
                        + GameChoicesEnum.convertCharToStringName(Character.forDigit(computerChoiceInteger, 10))
                        + " and \"" + humanName + "\" chose: "
                        + GameChoicesEnum.convertCharToStringName(Character.forDigit(humanChoiceInteger, 10));
                increaseComputerScoreByOne();
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
        setRoundNumberToWin(Character.getNumericValue(takenUserInputInteger));
    }
}
