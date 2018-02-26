package com.kodilla.rps;

import java.util.Scanner;

class HumanChoicesAndMovements {
    String humanChoiceAsString;
    int humanChoiceAsInteger = 0;
    boolean isGame5PiecesVariety = false;

    void setHumanChoiceAsString(char humanMovementChoice) {
        this.humanChoiceAsString = GameChoicesEnum.convertCharToStringName(humanMovementChoice);
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
            isGame5PiecesVariety = true;
        }
    }

    boolean askGameVariety(Scanner userInputsScanner) {
        System.out.print(GameMenu.showGameMenuCharForGameVariety());
        acceptOnlyKeyEChar(takeUserScannerInputAsChar(userInputsScanner));
        return isGame5PiecesVariety;
    }

    String humanMovement(Scanner inputScanner, String humanName) {
        System.out.print("\nPlease, \"" + humanName + "\", make decision: ");
        char humanMovementChoice = takeUserScannerInputAsChar(inputScanner);
        setHumanChoiceAsString(humanMovementChoice);
        switch (humanChoiceAsString) {
            case "Lizard":
            case "Spock":
                if ( ! isGame5PiecesVariety) {
                    System.out.print("You chose 3 pieces game variety. Choose wisely:");
                    humanMovement(inputScanner, humanName);
                }
            case "Rock":
            case "Paper":
            case "Scissors":
                System.out.println("\"" + humanName + "\" chosen => " + humanChoiceAsString);
                setHumanChoiceAsInteger(humanMovementChoice);
                break;
            case "Exit":
            case "New Game":
                System.out.print("Are you sure you want to cancel current game? [Y]es [N]o: ");
                confirmCancelCurrentGame(inputScanner, humanName);
                break;
            default:
                System.out.println("===> " + humanChoiceAsString);
                humanMovement(inputScanner, humanName);
        }
        return humanChoiceAsString;
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
        return humanChoiceAsInteger;
    }
}
