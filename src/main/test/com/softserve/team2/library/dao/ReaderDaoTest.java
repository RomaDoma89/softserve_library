package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.List;

/**
 * ReaderDao Tester.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class ReaderDaoTest {

  private ReaderDao dao;
  private Reader reader;

  @Before
  public void before() {
    dao = new ReaderDao();
    reader = new Reader();
    reader.setName("Tester Reader");
    reader.setBirthday("1919-01-22");
  }

  /** Method: insert(String name, String birthday) */
  @Test
  public void testInsert() {
    dao.insert(reader.getName(), reader.getBirthday());
    Reader selected = dao.selectByName(reader.getName());

    dao.delete(selected.getId());
  }

  /** Method: selectById(int id) */
  @Test
  public void testSelectById() {
    dao.insert(reader.getName(), reader.getBirthday());
    Reader selectedByName = dao.selectByName(reader.getName());
    Reader selectedById = dao.selectById(selectedByName.getId());
    Assert.assertEquals(selectedByName.getId(), selectedById.getId());

    dao.delete(selectedById.getId());
  }

  /** Method: selectByName(String name) */
  @Test
  public void testSelectByName() {
    dao.insert(reader.getName(), reader.getBirthday());
    Reader selected = dao.selectByName(reader.getName());
    Assert.assertEquals(reader.getName(), selected.getName());

    dao.delete(selected.getId());
  }

  /** Method: selectAll() */
  @Test
  public void testSelectAll() throws Exception {
    dao.insert(reader.getName(), reader.getBirthday());
    List<Reader> selected = dao.selectAll();
    boolean contained = false;
    for (Reader a : selected) {
      if (a.getName().equals(reader.getName())) {
        contained = true;
        reader.setId(a.getId());
      }
    }
    Assert.assertTrue(contained);

    dao.delete(reader.getId());
  }

  /** Method: update(Author author) */
  @Test
  public void testUpdate() {
    dao.insert(reader.getName(), reader.getBirthday());
    Reader selectedFirst = dao.selectByName(reader.getName());
    selectedFirst.setName("NEW TEST READER");
    boolean isUpdated = dao.update(selectedFirst);
    Assert.assertTrue(isUpdated);
    Reader selectedSecond = dao.selectByName(selectedFirst.getName());
    Assert.assertEquals(selectedFirst.getName(), selectedSecond.getName());
    Assert.assertEquals(selectedFirst.getId(), selectedSecond.getId());

    dao.delete(selectedFirst.getId());
  }
}
