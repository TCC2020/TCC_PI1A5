package br.edu.ifsp.spo.bulls.users.api.bean;

import br.edu.ifsp.spo.bulls.users.api.domain.Author;
import br.edu.ifsp.spo.bulls.users.api.domain.Book;
import br.edu.ifsp.spo.bulls.users.api.dto.BookTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookBeanUtilTest {

    @Autowired
    private BookBeanUtil beanUtil;

    @Test
    void testToBook(){
        List<Author>  author = new ArrayList<>( );
        author.add(new Author("Autor1"));

        BookTO bookTo = new BookTO( "123","lIVRO TESTE3", author, 10,
                "português", "editora",  8, "livro");

        Book book = beanUtil.toBook(bookTo);

        assertEquals(bookTo.getAuthors(), book.getAuthors());
        assertEquals(bookTo.getDescription(), book.getDescription());
        assertEquals(bookTo.getId(), book.getId());
        assertEquals(bookTo.getIsbn10(), book.getIsbn10());
        assertEquals(bookTo.getLanguage(), book.getLanguage());
        assertEquals(bookTo.getNumberPage(), book.getNumberPage());
        assertEquals(bookTo.getPublishedDate(), book.getPublishedDate());
        assertEquals(bookTo.getPublisher(), book.getPublisher());
        assertEquals(bookTo.getTitle(), book.getTitle());

    }

    @Test
    void testToBookTO(){
        List<Author>  author = new ArrayList<>( );
        author.add(new Author("Autor1"));

        Book book = new Book( "1234", "lIVRO TESTE2", author, 10,
                "português", "editora", 1, "livro", " teste");

        BookTO bookTo = beanUtil.toBookTO(book);

        assertEquals(book.getAuthors(), bookTo.getAuthors());
        assertEquals(book.getDescription(), bookTo.getDescription() );
        assertEquals(book.getId(), bookTo.getId() );
        assertEquals(book.getIsbn10(), bookTo.getIsbn10() );
        assertEquals(book.getLanguage(), bookTo.getLanguage() );
        assertEquals(book.getNumberPage(), bookTo.getNumberPage() );
        assertEquals(book.getPublishedDate(), bookTo.getPublishedDate() );
        assertEquals(bookTo.getPublisher(), book.getPublisher());
        assertEquals(book.getTitle(), bookTo.getTitle() );

    }

    @Test
    void testToBookTOList(){
        List<Author>  author = new ArrayList<>( );
        author.add(new Author("Autor1"));

        Book book = new Book( "123455665", "lIVRO TESTE",author,
                10, "português",
                "editora", 1, "livro", "teste");

        HashSet<Book> listBooks = new HashSet<>();
        listBooks.add(book);

        HashSet<BookTO> bookToList = beanUtil.toBookTO(listBooks);

        for (BookTO bookTo: bookToList ) {
            assertEquals(book.getAuthors(), bookTo.getAuthors());
            assertEquals(book.getDescription(), bookTo.getDescription());
            assertEquals(book.getId(), bookTo.getId());
            assertEquals(book.getIsbn10(), bookTo.getIsbn10());
            assertEquals(book.getLanguage(), bookTo.getLanguage());
            assertEquals(book.getNumberPage(), bookTo.getNumberPage());
            assertEquals(book.getPublishedDate(), bookTo.getPublishedDate());
            assertEquals(book.getPublisher(), bookTo.getPublisher());
            assertEquals(book.getTitle(), bookTo.getTitle());
        }


    }
}