package com.kodilla.rps;

final class MovementsOfHuman extends APlayersMovements {

    MovementsOfHuman(String player) {
        super(player);
    }

    @Override
    Character playerGameChoice(int gameVariety) {
        Character humanChoice = HumanInputReader.getInstance().getScanner().next().toLowerCase().charAt(0);
        switch (humanChoice) {
            case '5':
            case '4':
                if (gameVariety == 3) {
                    System.out.print("You chose 3 pieces game variety. Choose wisely:");
                    playerGameChoice(gameVariety);
                }
            case '3':
            case '2':
            case '1':
                System.out.println(getPlayerName() + " chose: " + getMovementName(humanChoice));
                break;
            case 'x':
                System.out.print("Are you sure you want to cancel current game? [Y]es [N]o: ");
                if ('y' != HumanInputReader.getInstance().getScanner().next().toLowerCase().charAt(0)) {
                    playerGameChoice(gameVariety);
                } else {
                    humanChoice = 'e';
                }
                break;
            case 'n':
                System.out.print("Are you sure you want to cancel current game? [Y]es [N]o: ");
                if ('y' != HumanInputReader.getInstance().getScanner().next().toLowerCase().charAt(0)) {
                    playerGameChoice(gameVariety);
                }
                break;
            default:
                System.out.print("Please select right game option: ");
                playerGameChoice(gameVariety);

        }
        return humanChoice;
    }
}
