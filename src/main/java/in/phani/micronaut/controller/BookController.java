package in.phani.micronaut.controller;

import com.google.common.collect.Lists;
import in.phani.micronaut.pojo.Book;
import in.phani.micronaut.repository.BookRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get("/bookdepot")
    public String bookdDepot(){
        return "welcome";
    }

    @Get("/initialize")
    public void initialize(){
        Book book1 = new Book();
        book1.setTitle("yaana");
        book1.setPages(300);

        Book book2 = new Book();
        book2.setTitle("tnm");
        book2.setPages(200);

        Book book3 = new Book();
        book3.setTitle("naayineralu");
        book3.setPages(150);

        Book book4 = new Book();
        book4.setTitle("mandra");
        book4.setPages(600);

        Book book5 = new Book();
        book5.setTitle("anaavarana");
        book5.setPages(400);

        bookRepository.saveAll(Lists.newArrayList(book1,book2, book3, book4, book5));
    }

    @Get("/findbook/{title}")
    public Book find(@PathVariable String title){
        return bookRepository.findByTitle(title);
    }

    @Get("/findbigbook/{pages}")
    public List<String> findBigBooks(@PathVariable int pages){
        return bookRepository.findTitleByPagesGreaterThanDesc(pages);
    }
}
