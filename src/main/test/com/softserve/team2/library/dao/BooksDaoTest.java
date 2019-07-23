package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Books;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * BooksDao Tester.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class BooksDaoTest {

  private BooksDao dao;
  private Books book;

  @Before
  public void before() {
    dao = new BooksDao();
    book = new Books();
    book.setTitle("Tester Book: 1st edition.");
  }

  @After
  public void after() {}

  /** Method: insert(String title) */
  @Test
  public void testInsert() {
    dao.insert(book.getTitle());
    Books selected = dao.selectByTitle(book.getTitle());

    dao.delete(selected.getId());
  }

  /** Method: selectById(int id) */
  @Test
  public void testSelectById() {
    dao.insert(book.getTitle());
    Books selectedByName = dao.selectByTitle(book.getTitle());
    Books selectedById = dao.selectById(selectedByName.getId());
    Assert.assertEquals(selectedByName.getId(), selectedById.getId());

    dao.delete(selectedById.getId());
  }

  /** Method: selectByTitle(String title) */
  @Test
  public void testSelectByTitle() {
    dao.insert(book.getTitle());
    Books selected = dao.selectByTitle(book.getTitle());
    Assert.assertEquals(book.getTitle(), selected.getTitle());

    dao.delete(selected.getId());
  }

  /** Method: selectAll() */
  @Test
  public void testSelectAll() {
    dao.insert(book.getTitle());
    List<Books> selected = dao.selectAll();
    boolean contained = false;
    for (Books b : selected) {
      if (b.getTitle().equals(book.getTitle())) {
        contained = true;
        book.setId(b.getId());
      }
    }
    Assert.assertTrue(contained);

    dao.delete(book.getId());
  }

  /** Method: update(int id, String title) */
  @Test
  public void testUpdate() {
    dao.insert(book.getTitle());
    Books selectedFirst = dao.selectByTitle(book.getTitle());
    selectedFirst.setTitle("NEW TEST TITLE");
    boolean isUpdated = dao.update(selectedFirst.getId(), selectedFirst.getTitle());
    Assert.assertTrue(isUpdated);
    Books selectedSecond = dao.selectByTitle(selectedFirst.getTitle());
    Assert.assertEquals(selectedFirst.getTitle(), selectedSecond.getTitle());
    Assert.assertEquals(selectedFirst.getId(), selectedSecond.getId());

    dao.delete(selectedFirst.getId());
  }
}
