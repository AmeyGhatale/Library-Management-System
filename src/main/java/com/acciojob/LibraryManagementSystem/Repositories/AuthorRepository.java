package com.acciojob.LibraryManagementSystem.Repositories;

import com.acciojob.LibraryManagementSystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

/*
*
* @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    public AuthorService authorService; //automatically creating an object of the service layer
    // AuthorService authorService = new AuthorService();


    @Test
    public void testMaxBooksAuthor(){



        Author a1 = new Author(1,3);
        Author a2 = new Author(2,5);
        Author a3 = new Author(3,7);

        List<Author> authorList = new ArrayList<>();
        authorList.add(a1);
        authorList.add(a2);
        authorList.add(a3);

        Mockito.when(authorRepository.findAll()).thenReturn(authorList);

        Author actualAuthor = authorService.getAuthorWithMaxBooks();

        Assertions.assertEquals(a3,actualAuthor);

*
* */