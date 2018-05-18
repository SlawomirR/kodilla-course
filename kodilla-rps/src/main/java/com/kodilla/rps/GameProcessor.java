package com.kodilla.rps;

final class GameProcessor {

    private String humanName;
    private APlayersMovements humanMove;
    private APlayersMovements compMove;
    private WinnerJudgement winnerJudgement;
    private GameMenu gameMenu;
    private Character userPlan;
    private int gameVariety;
    private int roundNumberToWin;
    private boolean exitConfirmed;

    GameProcessor() {
        humanMove = new MovementsOfHuman(humanName);
        compMove = new MovementsOfComputer("Computer");
        winnerJudgement = new WinnerJudgement();
        exitConfirmed = false;
        userPlan = 'n';
    }

    void startTheGame() {
        switch (userPlan) {
            case 'n':
                resetGameDataForNewGame();
            case 'd':
                System.out.println(gameMenu.getGameMenu());
                Character humanChose = humanMove.playerGameChoice(gameVariety);
                if (Character.isDigit(humanChose)) {
                    userPlan = 'd';
                    int roundsAdvantage = winnerJudgement.determineWinner(humanChose, compMove.playerGameChoice(gameVariety));
                    if (roundsAdvantage >= roundNumberToWin) {
                        exitConfirmed = true;
                    }
                } else {
                    userPlan = humanChose;
                }
                break;
            case 'e':
                exitConfirmed = true;
                break;
        }
        decideIfContinueOrExitGame();
    }

    private void resetGameDataForNewGame() {
        gameVariety = askGameVariety();
        gameMenu = new GameMenu(gameVariety);
        humanName = askHumanName();
        humanMove.setPlayerName(humanName);
        roundNumberToWin = askRoundNumberToWin();
    }

    private int askGameVariety() {
        System.out.print("Please, choose which variety of game you want." + System.lineSeparator()
                + "You can decide to play 3 or 5 pieces variety" + System.lineSeparator()
                + "by pressing proper number followed by enter: ");
        int result = HumanInputReader.getInstance().getScanner().nextInt();
        while (!(result == 3 || result == 5)) {
            System.out.print("The only choice are 3 or 5 so decide: ");
            result = HumanInputReader.getInstance().getScanner().nextInt();
        }
        return result;
    }

    private String askHumanName() {
        System.out.print("May I have your name?: ");
        String result = HumanInputReader.getInstance().getScanner().next();
        while (result.toLowerCase().equals("computer")) {
            System.out.println("Word \"Computer\" is reserved, so: ");
            result = HumanInputReader.getInstance().getScanner().next();
        }
        return result;
    }

    private int askRoundNumberToWin() {
        System.out.print("How many round wins against the opponent will end our game?: ");
        // TODO validate input
        int result = HumanInputReader.getInstance().getScanner().nextInt();
        HumanInputReader.getInstance().getScanner().nextLine();
        return result;
    }

    private void decideIfContinueOrExitGame() {
        if (exitConfirmed) {
            HumanInputReader.getInstance().getScanner().close();
            System.out.println("Goodbye");
        } else {
            startTheGame();
        }
    }
}
