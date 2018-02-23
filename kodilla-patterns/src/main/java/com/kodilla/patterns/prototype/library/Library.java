package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    Library(final String name) {
        this.name = name;
    }

    Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }


    Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book theBook: books) {
            clonedLibrary.getBooks().add(new Book(theBook.getTitle(), theBook.getAuthor(), theBook.getPublicationDate()));
        }
        return clonedLibrary;
    }

    String getName() {
        return name;
    }

    Set<Book> getBooks() {
        return books;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public static boolean equals(Set<?> set1, Set<?> set2){
        if(set1 == null || set2 ==null){
            return false;
        }
        if(set1.size()!=set2.size()){
            return false;
        }
        return set1.containsAll(set2);
    }
}
