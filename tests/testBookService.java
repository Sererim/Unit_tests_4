package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import src.book.InMemoryBookRepository;
import src.book.BookService;

public class testBookService {

    InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);

    public BookService bookService;

    public void testFindBookById() {
        bookService.findBookById("1");
        verify(bookRepository, times(1)).findById("1");
        assertThat(bookRepository.findById("1").getTitle()).isEqualTo("Book1");
    }

    public void testFindAllBooks() {
        bookService.findAllBooks();
        verify(bookRepository, times(1)).findAll();
        assertThat(bookRepository.findAll().size()).isEqualTo(2);
    }

    public static void main(String[] args) {
        testBookService test = new testBookService();
        test.bookService = new BookService(test.bookRepository);
        test.testFindBookById();
        test.testFindAllBooks();
    }
}