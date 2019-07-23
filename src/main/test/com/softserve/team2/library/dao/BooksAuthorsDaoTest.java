package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Author;
import com.softserve.team2.library.entities.Books;
import com.softserve.team2.library.entities.BooksAuthors;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * BooksAuthorsDao Tester.
 *
 * @author Roma Zahorui
 * @version 1.0
 */
public class BooksAuthorsDaoTest {

  private BooksAuthorsDao daoBookAuth;
  private BooksDao bookDao;
  private AuthorDao authorDao;
  private BooksAuthors ba;

  private Books book;

  private Author author;

  @Before
  public void before() {
    daoBookAuth = new BooksAuthorsDao();
    ba = new BooksAuthors();

    bookDao = new BooksDao();
    book = new Books();
    book.setTitle("Tester Book: 1st edition.");

    authorDao = new AuthorDao();
    author = new Author();
    author.setName("Tester Author");
  }

  @After
  public void after() {}

  /** Method: insert(int idBook, int idAuthor) */
  @Test
  public void testInsert() {
    bookDao.insert(book.getTitle());
    Books selectedB = bookDao.selectByTitle(book.getTitle());

    authorDao.insert(author.getName());
    Author selectedA = authorDao.selectByName(author.getName());

    ba.setIdBook(selectedB.getId());
    ba.setIdAuthor(selectedA.getId());

    daoBookAuth.insert(selectedB.getId(), selectedA.getId());
    List<BooksAuthors> list = daoBookAuth.selectByIdBook(selectedB.getId());

    boolean contained = false;
    for (BooksAuthors item : list) {
      if (item.getIdBook() == ba.getIdBook() && item.getIdAuthor() == ba.getIdAuthor()) {
        contained = true;
      }
    }
    Assert.assertTrue(contained);

    daoBookAuth.delete(selectedB.getId(), selectedA.getId());
    authorDao.delete(selectedA.getId());
    bookDao.delete(selectedB.getId());
  }

  /** Method: selectByIdBook(int idBook) */
  @Test
  public void testSelectByIdBook() {
    bookDao.insert(book.getTitle());
    Books selectedB = bookDao.selectByTitle(book.getTitle());

    authorDao.insert(author.getName());
    Author selectedA = authorDao.selectByName(author.getName());

    daoBookAuth.insert(selectedB.getId(), selectedA.getId());

    List<BooksAuthors> list = daoBookAuth.selectByIdBook(selectedB.getId());
    for (BooksAuthors item : list) {
      Assert.assertEquals(item.getIdBook(), selectedB.getId());
      Assert.assertEquals(item.getIdAuthor(), selectedA.getId());
    }

    daoBookAuth.delete(selectedB.getId(), selectedA.getId());
    authorDao.delete(selectedA.getId());
    bookDao.delete(selectedB.getId());
  }

  /** Method: selectByIdAuthor(int idAuthor) */
  @Test
  public void testSelectByIdAuthor() {
    bookDao.insert(book.getTitle());
    Books selectedB = bookDao.selectByTitle(book.getTitle());

    authorDao.insert(author.getName());
    Author selectedA = authorDao.selectByName(author.getName());

    daoBookAuth.insert(selectedB.getId(), selectedA.getId());

    List<BooksAuthors> list = daoBookAuth.selectByIdAuthor(selectedA.getId());
    for (BooksAuthors item : list) {
      Assert.assertEquals(item.getIdBook(), selectedB.getId());
      Assert.assertEquals(item.getIdAuthor(), selectedA.getId());
    }

    daoBookAuth.delete(selectedB.getId(), selectedA.getId());
    authorDao.delete(selectedA.getId());
    bookDao.delete(selectedB.getId());
  }

  /** Method: selectAll() */
  @Test
  public void testSelectAll() {
    bookDao.insert(book.getTitle());
    Books selectedB = bookDao.selectByTitle(book.getTitle());

    authorDao.insert(author.getName());
    Author selectedA = authorDao.selectByName(author.getName());

    daoBookAuth.insert(selectedB.getId(), selectedA.getId());

    List<BooksAuthors> list = daoBookAuth.selectByIdAuthor(selectedA.getId());
    boolean contained = false;
    for (BooksAuthors item : list) {
      if (item.getIdBook() == selectedB.getId() && item.getIdAuthor() == selectedA.getId()) {
        contained = true;
      }
    }
    Assert.assertTrue(contained);

    daoBookAuth.delete(selectedB.getId(), selectedA.getId());
    authorDao.delete(selectedA.getId());
    bookDao.delete(selectedB.getId());
  }
}
