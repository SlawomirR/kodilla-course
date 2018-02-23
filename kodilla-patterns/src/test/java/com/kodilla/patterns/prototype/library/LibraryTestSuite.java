package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        // Given
        Library library = new Library("Science-Fiction");
        library.getBooks().add(new Book("Ender's Game", "Orson Scott Card", LocalDate.of(1985, 1,1)));
        library.getBooks().add(new Book("Speaker for the Dead", "Orson Scott Card", LocalDate.of(1985, 1,1)));
        library.getBooks().add(new Book("Xenocide", "Orson Scott Card", LocalDate.of(1991, 1,1)));
        library.getBooks().add(new Book("Children of the Mind", "Orson Scott Card", LocalDate.of(1996, 1,1)));
        library.getBooks().add(new Book("Ender's Shadow", "Orson Scott Card", LocalDate.of(1999, 1,1)));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Fantasy");
        } catch (CloneNotSupportedException e) {
            printStackTrace(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Horror");
        } catch (CloneNotSupportedException e) {
            printStackTrace(e);
        }
        // When
        library.getBooks().add(new Book("Shadow of the Hegemon", "Orson Scott Card", LocalDate.of(2001, 1, 1)));
        // Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(6, library.getBooks().size());
        Assert.assertEquals(6, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertTrue(Library.equals(shallowClonedLibrary.getBooks(), library.getBooks()));
        Assert.assertFalse(Library.equals(deepClonedLibrary.getBooks(), library.getBooks()));
    }
}
