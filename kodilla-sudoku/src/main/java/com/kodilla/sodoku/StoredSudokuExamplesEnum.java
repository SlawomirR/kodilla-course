package com.kodilla.sodoku;

enum StoredSudokuExamplesEnum {
    EASY001("R1980006300,2000307520,3023050409,4162004905,5800605003,6504200671,7301060890,8049803000,9008900032"),
    MIDI002("R1306508400,2520000000,3087000031,4003010080,5900863005,6050090600,7130000250,8000000074,9005206300"),
    HARD001("R1000006000,2059000008,3200008000,4045000000,5003000000,6006003054,7000325006,8000000000,9000000000");

    private final String sudokuExampleValues;

    StoredSudokuExamplesEnum(String sudokuExampleValues) {
        this.sudokuExampleValues = sudokuExampleValues;
    }

    public String getSudokuExampleValues() {
        return sudokuExampleValues;
    }
}
