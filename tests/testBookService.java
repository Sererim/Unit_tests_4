package tests;

import static org.mockito.Mockito.*;

import org.mockito.Mock;

import src.book.BookRepository;
import src.book.BookService;

public class testBookService {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    public void testFindBookById() {
        bookService.findBookById(null);
        verify(bookRepository, times(1)).findById(null);
    }

    public void testFindAllBooks() {
        bookService.findAllBooks();
        verify(bookRepository, times(1)).findAll();
    }

    public static void main(String[] args) {
        testBookService test = new testBookService();
        test.bookService = new BookService(test.bookRepository);
        test.testFindBookById();
        test.testFindAllBooks();
    }
}