package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;

class MovieStore {
    private static final String TITLE_DELIMITER = "!";
    private static final int POLISH_LANGUAGE = 0;
    private static final int ENGLISH_LANGUAGE = 1;

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        System.out.println(movieStore.getMovies()
                .entrySet()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(TITLE_DELIMITER))
        );

        System.out.println(printAllMovieTitlesInOneLine(ENGLISH_LANGUAGE, TITLE_DELIMITER));
    }

    private static String printAllMovieTitlesInOneLine(int chooseLanguageNumber, String chooseTitleDelimiter) {
        MovieStore movieStore = new MovieStore();

        return movieStore.getMovies()
                .entrySet()
                .stream()
                .map(n -> n.getValue().get(chooseLanguageNumber))
                .collect(Collectors.joining(chooseTitleDelimiter));
    }

    private Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }
}
