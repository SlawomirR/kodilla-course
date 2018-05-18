package com.kodilla.rps;

final class GameMenu {

    private String gameMenu;

    GameMenu(int gameVariety) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator())
                .append("Keys for playing the game:").append(System.lineSeparator())
                .append("key 1 - plays \"Rock\"").append(System.lineSeparator())
                .append("key 2 - plays \"Paper\"").append(System.lineSeparator())
                .append("key 3 - plays \"Scissors\"");
        if (gameVariety == 5) {
            stringBuilder.append(System.lineSeparator())
                    .append("key 4 - plays \"Lizard\"").append(System.lineSeparator())
                    .append("key 5 - plays \"Spock\"");
        }
        stringBuilder.append(System.lineSeparator())
                .append("key x - end the game").append(System.lineSeparator())
                .append("key n - start new game").append(System.lineSeparator())
                .append("Make your choice: ");
        gameMenu = stringBuilder.toString();
    }

    String getGameMenu() {
        return gameMenu;
    }
}
