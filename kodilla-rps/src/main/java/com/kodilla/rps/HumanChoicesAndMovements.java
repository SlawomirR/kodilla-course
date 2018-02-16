package com.kodilla.rps;

import java.util.Scanner;

class HumanChoicesAndMovements {
    private String humanChoiceAsString;
    private int humanChoiceAsInteger = 0;
    private boolean isGame5PiecesVariety = false;

    boolean isGame5PiecesVariety() {
        return isGame5PiecesVariety;
    }

    void setGame5PiecesVariety(boolean isGame5PiecesVariety) {
        this.isGame5PiecesVariety = isGame5PiecesVariety;
    }

    String getHumanChoiceAsString() {
        return humanChoiceAsString;
    }

    void setHumanChoiceAsString(char humanMovementChoice) {
        this.humanChoiceAsString = GameChoicesEnum.convertCharToStringName(humanMovementChoice);
    }

    int getHumanChoiceAsInteger() {
        return humanChoiceAsInteger;
    }

    void setHumanChoiceAsInteger(char humanMovementChoice) {
        this.humanChoiceAsInteger = Character.getNumericValue(humanMovementChoice);
    }

    String askHumanName(Scanner userInputsScanner) {
        String humanName = "";
        while (humanName.length() == 0) {
            System.out.print("Please enter your name: ");
            humanName = userInputsScanner.next();
        }
        System.out.println("Hello \"" + humanName + "\". I'm \"Computer\" _o^o_ and I accept your challenge to a duel in the game!");
        return humanName;
    }

    void acceptOnlyKeyEChar(char enteredChar) {
        if (enteredChar == 'e') {
            setGame5PiecesVariety(true);
        }
    }

    boolean askGameVariety(Scanner userInputsScanner) {
        System.out.print(GameMenu.showGameMenuCharForGameVariety());
        acceptOnlyKeyEChar(takeUserScannerInputAsChar(userInputsScanner));
        return isGame5PiecesVariety();
    }

    String humanMovement(Scanner inputScanner, String humanName) {
        System.out.print("\nPlease, \"" + humanName + "\", make decision: ");
        char humanMovementChoice = takeUserScannerInputAsChar(inputScanner);
        setHumanChoiceAsString(humanMovementChoice);
        switch (getHumanChoiceAsString()) {
            case "Lizard":
            case "Spock":
                if ( ! isGame5PiecesVariety()) {
                    System.out.print("You chose 3 pieces game variety. Choose wisely:");
                    humanMovement(inputScanner, humanName);
                }
            case "Rock":
            case "Paper":
            case "Scissors":
                System.out.println("\"" + humanName + "\" chosen => " + getHumanChoiceAsString());
                setHumanChoiceAsInteger(humanMovementChoice);
                break;
            case "Exit":
            case "New Game":
                System.out.print("Are you sure you want to cancel current game? [Y]es [N]o: ");
                confirmCancelCurrentGame(inputScanner, humanName);
                break;
            default:
                System.out.println("===> " + getHumanChoiceAsString());
                humanMovement(inputScanner, humanName);
        }
        return getHumanChoiceAsString();
    }
    
    char takeUserScannerInputAsChar(Scanner inputScanner) {
        return inputScanner.next().toLowerCase().charAt(0);
    }
    
    int confirmCancelCurrentGame(Scanner inputScanner, String humanName) {
        if (takeUserScannerInputAsChar(inputScanner) != 'y') {
            humanMovement(inputScanner, humanName);
        } else {
            setHumanChoiceAsInteger('0');
        }
        return getHumanChoiceAsInteger();
    }
}
