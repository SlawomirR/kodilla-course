package com.kodilla.rps;

final class MainRpsRunner {

    public static void main(String[] args) {

        GameProcessor gameProcessor = new GameProcessor();
        gameProcessor.startTheGame();
        HumanInputReader.getInstance().getScanner().close();
    }
}
