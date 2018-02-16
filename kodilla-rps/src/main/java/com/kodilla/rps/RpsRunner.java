package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameProcessor gameProcessor = new GameProcessor();

        System.out.println(GameUtils.showApplicationName());
        gameProcessor.startTheGame();
    }
}
