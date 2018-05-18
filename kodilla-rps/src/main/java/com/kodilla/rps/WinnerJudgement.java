package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

final class WinnerJudgement {

    private Map<String, Integer> scoreTable;
    private WinningRule winningRule = new WinningRule();

    WinnerJudgement() {
        scoreTable = new HashMap<>();
        scoreTable.put("human", 0);
        scoreTable.put("computer", 0);
    }

    int determineWinner(Character human, Character computer) {
        switch (winningRule.getWinner(human, computer)) {
            case 'h':
                System.out.println(winnerIsHuman());
                break;
            case 'c':
                System.out.println(winnerIsCompuer());
                break;
            case 'd':
                System.out.println(winnerIsPending());
                break;
        }
        System.out.println(getScoresInfo());
        return Math.abs(scoreTable.get("human") - scoreTable.get("computer"));
    }

    private String winnerIsHuman() {
        scoreTable.put("human", scoreTable.get("human") + 1);
        return "Human wins!";
    }

    private String winnerIsCompuer() {
        scoreTable.put("computer", scoreTable.get("human") + 1);
        return "Computer wins!";
    }

    private String winnerIsPending() {
        scoreTable.put("human", scoreTable.get("human") + 1);
        scoreTable.put("computer", scoreTable.get("human") + 1);
        return "There is a draw!";
    }

    private String getScoresInfo() {
        StringBuilder sb = new StringBuilder();
        return sb.append("HUMAN has: ").append(scoreTable.get("human")).append(" versus COMPUTER has: ")
                .append(scoreTable.get("computer")).append(" points so far.").toString();
    }
}
