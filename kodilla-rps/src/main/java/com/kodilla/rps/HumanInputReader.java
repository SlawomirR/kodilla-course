package com.kodilla.rps;

import java.util.Scanner;

final class HumanInputReader {

    private static HumanInputReader humanInputReaderInstance = null;
    private Scanner scanner;

    static HumanInputReader getInstance() {
        if (humanInputReaderInstance == null) {
            humanInputReaderInstance = new HumanInputReader();
        }
        return humanInputReaderInstance;
    }

    Scanner getScanner() {
        return scanner;
    }

    private HumanInputReader() {
        scanner = new Scanner(System.in);
    }
}
