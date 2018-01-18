package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String textToBeautify, PoemDecorator poemDecorator ) {
        return poemDecorator.decorate(textToBeautify);
    }
}
