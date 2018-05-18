package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class WinningRule {

    private List<Character> rock, paper, scissors, lizard, spock;
    private List<List<Character>> winningSchema;

    WinningRule() {
        rock = new ArrayList<>(Arrays.asList('d', 'c', 'h', 'h', 'c'));
        paper = new ArrayList<>(Arrays.asList('h', 'd', 'c', 'c', 'h'));
        scissors = new ArrayList<>(Arrays.asList('c', 'h', 'd', 'h', 'c'));
        lizard = new ArrayList<>(Arrays.asList('c', 'h', 'c', 'd', 'h'));
        spock = new ArrayList<>(Arrays.asList('h', 'c', 'h', 'c', 'd'));

        winningSchema = new ArrayList<>(Arrays.asList(rock, paper, scissors, lizard, spock));
    }

    Character getWinner(Character human, Character computer) {
        return winningSchema.get(Character.getNumericValue(human) - 1).get(Character.getNumericValue(computer) - 1);
    }
}
