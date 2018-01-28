package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("file/names.txt")).getFile());

        System.out.println(file.getPath());
//        Path path = Paths.get(file.getPath());
//        Path path = Paths.get("file/names.txt");
        try (Stream<String> fileLines = Files.lines(Paths.get("file/names.txt"))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oj joj joj!!! Bam! ;-)  " + e);
//            e.printStackTrace();
        } finally {
            System.out.println("\nInformation - that is always true.");
        }
    }
}
