package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Author;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.List;

/**
 * AuthorDao Tester.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class AuthorDaoTest {

  private AuthorDao dao;
  private Author author;

  /** Method: before() should prepare init data. */
  @Before
  public void before() {
    dao = new AuthorDao();
    author = new Author();
    author.setName("Tester Author");
  }

  /** Method: insert(String name) */
  @Test
  public void testInsert() {
    dao.insert(author.getName());
    Author selected = dao.selectByName(author.getName());
    dao.delete(selected.getId());
  }

  /** Method: selectByName(String name) */
  @Test
  public void testSelectByName() {
    dao.insert(author.getName());
    Author selected = dao.selectByName(author.getName());
    Assert.assertEquals(author.getName(), selected.getName());
    dao.delete(selected.getId());
  }

  /** Method: selectById(int id) */
  @Test
  public void testSelectById() {
    dao.insert(author.getName());
    Author selectedByName = dao.selectByName(author.getName());
    Author selectedById = dao.selectById(selectedByName.getId());
    Assert.assertEquals(selectedByName.getId(), selectedById.getId());
    dao.delete(selectedById.getId());
  }

  /** Method: selectAll() */
  @Test
  public void testSelectAll() {
    dao.insert(author.getName());
    List<Author> selected = dao.selectAll();
    boolean contained = false;
    for (Author a : selected) {
      if (a.getName().equals(author.getName())) {
        contained = true;
        author.setId(a.getId());
      }
    }
    Assert.assertTrue(contained);
    dao.delete(author.getId());
  }

  /** Method: update(Author author) */
  @Test
  public void testUpdate() {
    dao.insert(author.getName());
    Author selectedFirst = dao.selectByName(author.getName());
    selectedFirst.setName("NEW TEST AUTHOR");
    boolean isUpdated = dao.update(selectedFirst);
    Assert.assertTrue(isUpdated);
    Author selectedSecond = dao.selectByName(selectedFirst.getName());
    Assert.assertEquals(selectedFirst.getName(), selectedSecond.getName());
    Assert.assertEquals(selectedFirst.getId(), selectedSecond.getId());

    dao.delete(selectedFirst.getId());
  }
}
