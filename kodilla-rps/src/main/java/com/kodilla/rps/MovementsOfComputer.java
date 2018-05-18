package com.kodilla.rps;

import java.util.Random;

final class MovementsOfComputer extends APlayersMovements {

    MovementsOfComputer(String player) {
        super(player);
    }

    @Override
    Character playerGameChoice(int gameVariety) {
        Random random = new Random();
        Character result = Character.forDigit(random.nextInt(gameVariety) + 1, 10);
        System.out.println(getPlayerName() + " chose: " + getMovementName(result));
        return result;
    }
}
