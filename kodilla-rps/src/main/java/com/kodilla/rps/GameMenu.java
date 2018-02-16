package com.kodilla.rps;

final class GameMenu {
    private static final String newLine = System.getProperty("line.separator");

    static String showGameMenu(boolean isGame5PiecesVariety) {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(showGameMenuStandardNumbers());
       if (isGame5PiecesVariety) stringBuilder.append(showGameMenu5PiecesVarietyNumbers());
       stringBuilder.append(showGameMenuCharOptions());
       return stringBuilder.toString();
    }

     static String showGameMenuHeader() {
        return newLine + "Keys for playing the game:";
    }

     static String showGameMenuStandardNumbers() {
        return showGameMenuHeader() + newLine
                + "key 1 - plays \"Rock\"" + newLine
                + "key 2 - plays \"Paper\"" + newLine
                + "key 3 - plays \"Scissors\"";
    }

     private static String showGameMenu5PiecesVarietyNumbers() {
        return newLine + "key 4 - plays \"Lizard\"" + newLine
             + "key 5 - plays \"Spock\"";
    }

     static String showGameMenuCharOptions() {
        return newLine + "key x - end the game" + newLine
             + "key n - start new game";
     }

     static String showGameMenuCharForGameVariety() {
         return "Choose the key corresponding to the selected version of the game you want to play." + newLine
         + "key e - chooses the extended (5 pieces) version of the game" + newLine
         + "key s - chooses the standard (3 pieces) version of the game" + newLine
         + "What is your decision?: ";
     }
}
