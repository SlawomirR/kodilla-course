package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookDirectoryTestSuite {
    /*
    Przyjmijmy następujące założenia:
        - Jeżeli liczba zwróconych wyników będzie większa niż 20, wówczas metoda ma zwracać pustą listę - aby
          uniemożliwić hakerom kradzież naszej pełnej listy książek :)
        - Jeżeli ilość znaków w ciągu titleFragment będzie mniejsza niż trzy, również ma zwrócić pustą listę - z tych
          samych powodów (względy bezpieczeństwa danych)
        - W pozostałych przypadkach ma zwrócić listę obiektów typu Book spełniających kryteria wyszukiwania
    */
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.addAll(Arrays.asList(book1, book2, book3, book4));
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    /*
    Zaimplementuj kolejną metodę klasy BookLibrary - listBooksInHandsOf(LibraryUser libraryUser).
    Przetestuj tę metodę w różnych scenariuszach:
    - gdy użytkownik nie ma wypożyczonych żadnych książek,
    - gdy ma wypożyczoną jedną książkę,
    - gdy ma wypożyczone 5 książek.
    */
    private LibraryUser libraryUser = new LibraryUser("Alphonse", "Capone", "99811789215");

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @InjectMocks
    private BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);


    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListBooksInHandsOfUser0Books() {
        // Given
        List<Book> list0BorrowedBooksByUser = generateListOfNBooks(0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(list0BorrowedBooksByUser);
        // When
        List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        Assert.assertEquals(0, theListOf0Books.size());
    }

    @Test
    public void testListBooksInHandsOfUser1Book() {
        // Given
        List<Book> list1BorrowedBooksByUser = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(list1BorrowedBooksByUser);
        // When
        List<Book> theListOf1Book = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        Assert.assertEquals(1, theListOf1Book.size());
    }

    @Test
    public void testListBooksInHandsOfUser5Books() {
        // Given
        List<Book> list5BorrowedBooksByUser = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(list5BorrowedBooksByUser);
        // When
        List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        Assert.assertEquals(5, theListOf5Books.size());
    }
}
