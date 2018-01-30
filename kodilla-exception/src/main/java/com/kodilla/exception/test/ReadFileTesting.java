package com.kodilla.exception.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class ReadFileTesting {
    public static void main(String[] args) {
        KodillaFileReading kodillaFileReading = new KodillaFileReading();
        MyFileReading myFileReading = new MyFileReading();
        String fileNameWithPath = "kodilla-exception/src/main/resources/file/names.txt";
        String fileNameWithPathKodilla = "file/names.txt";

        kodillaFileReading.kodillaFileReading(fileNameWithPathKodilla);
        myFileReading.myFileReading(fileNameWithPath);
    }
}

class KodillaFileReading {
    void kodillaFileReading(String fileNameWithPathKodilla) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileNameWithPathKodilla)).getPath());
        Path path = Paths.get(file.getPath());
        try {
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("===== End KodillaFileReading");
        }
    }
}

class MyFileReading {
    void myFileReading(String fileNameWithPath) {
        File file = new File(fileNameWithPath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("===== End MyFileReading");
        }
    }
}

