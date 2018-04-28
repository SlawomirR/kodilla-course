package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author_1", "Title_1", 2005, "A1T12005"));
        books.add(new Book("Author_2", "Title_2", 2007, "A2T22007"));
        books.add(new Book("Author_3", "Title_3", 2009, "A3T32009"));
        books.add(new Book("Author_4", "Title_4", 2011, "A4T42011"));
        books.add(new Book("Author_5", "Title_5", 2013, "A5T52013"));
        books.add(new Book("Author_6", "Title_6", 2015, "A6T62015"));
        books.add(new Book("Author_7", "Title_7", 2017, "A7T72017"));
        // When
        MedianAdapter medianAdapter = new MedianAdapter();
        int restlt = medianAdapter.publicationYearMedian(books);
        // Then
        Assert.assertEquals(2011, restlt);
    }
}
