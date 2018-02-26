package com.kodilla.rps;

import java.util.Scanner;

class GameProcessor {
    private HumanChoicesAndMovements humanChoicesAndMovements = new HumanChoicesAndMovements();
    private ComputerMovements computerMovements = new ComputerMovements();
    private Scanner userInputsScanner = new Scanner(System.in);
    private GameUtils gameUtils = new GameUtils();

    private String userWillingSituations = "New Game";
    private String humanName;

    private String getUserWillingSituations() {
        return userWillingSituations;
    }

    private void setUserWillingSituations(String userWillingSituations) {
        this.userWillingSituations = userWillingSituations;
    }

    private String getHumanName() {
        return humanName;
    }

    private void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    void startTheGame() {
        switch(getUserWillingSituations()) {
            case "New Game":
                resetGameDataForNewGame();
                humanChoicesAndMovements.askGameVariety(userInputsScanner);
                setHumanName(humanChoicesAndMovements.askHumanName(userInputsScanner));
                gameUtils.askRoundNumberToWin(userInputsScanner);
            case "During the Game":
                System.out.println(GameMenu.showGameMenu(humanChoicesAndMovements.isGame5PiecesVariety));
                humanChoicesAndMovements.humanMovement(userInputsScanner, getHumanName());
                if (humanChoicesAndMovements.humanChoiceAsInteger > 0) {
                    setUserWillingSituations("During the Game");
                    computerMovements.computerGameChoice(humanChoicesAndMovements.isGame5PiecesVariety);
                    System.out.println(gameUtils.showAndCompareMovementsResult(
                            computerMovements.getComputerChoiceAsInteger(),
                            humanChoicesAndMovements.humanChoiceAsInteger,
                            getHumanName())
                    );
                    System.out.println(gameUtils.showGameSummary(getHumanName()));
                    gameUtils.checkIfGameIsEnded();
                } else {
                    setUserWillingSituations(humanChoicesAndMovements.humanChoiceAsString);
                }
                break;
            case "Exit":
                gameUtils.exitConfirmed = true;
                break;
        }
        decideIfContinueOrExitGame();
    }

    private void resetGameDataForNewGame() {
        gameUtils.scoresArray = new int[]{0,0};
        gameUtils.currentRoundNumber = 1;
        humanChoicesAndMovements.isGame5PiecesVariety = false;
    }

    private void decideIfContinueOrExitGame() {
        if (gameUtils.exitConfirmed) {
            gameUtils.sayGoodbyeAndCloseScanner(userInputsScanner);
        } else {
            startTheGame();
        }
    }
}
