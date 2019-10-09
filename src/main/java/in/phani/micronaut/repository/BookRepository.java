package in.phani.micronaut.repository;

import in.phani.micronaut.pojo.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book find(String title);
    Book findByTitle(String title);
    List<String> findTitleByPagesGreaterThanDesc(int pageCount);
}