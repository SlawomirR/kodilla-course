package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        String movie = collection.get(0);
        System.out.println(movie);
        String movie1 = collection.get(1);
        System.out.println(movie1);
    }
}
