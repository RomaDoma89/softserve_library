package com.softserve.team2.library.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import com.softserve.team2.library.dto.ReaderDto;
import java.util.List;

/**
 * ReaderServices Tester.
 *
 * @author Roma Zahorui
 * @version 1.0
 */
public class ReaderServicesWrongDataTest {

  private final String WRONG_DATA = "lksjdf098304590";
  private ReaderServices readerServices;

  @Before
  public void before() {
    readerServices = new ReaderServices();
  }

  @After
  public void after() {}

  /** Method: fullStatisticsOfReaders(String dateFrom, String dateTo) */
  @Test
  public void testFullStatisticsOfReadersWithWrongDates() {
    List<ReaderDto> dto = readerServices.fullStatisticsOfReaders(WRONG_DATA, WRONG_DATA);
    for (ReaderDto rd : dto) {
      Assert.assertNull(rd.getListOfReaderBooks());
      Assert.assertNull(rd.getListOfNotReturnedBooks());
    }
  }

  /** Method: fullStatisticsOfReaders(String dateFrom, String dateTo) */
  @Test
  public void testFullStatisticsOfReadersWithNull() {
    List<ReaderDto> dto = readerServices.fullStatisticsOfReaders(null, null);
    for (ReaderDto rd : dto) {
      Assert.assertNull(rd.getListOfReaderBooks());
      Assert.assertNull(rd.getListOfNotReturnedBooks());
    }
  }

  /** Method: getAvgAgeByBook(String title) */
  @Test
  public void testGetAvgAgeByBookWrongTitle() {
    ReaderDto dto = readerServices.getAvgAgeByBook(WRONG_DATA);
    Assert.assertEquals(0, dto.getAvgAge());
  }

  /** Method: getAvgAgeByBook(String title) */
  @Test
  public void testGetAvgAgeByBookNullTitle() {
    ReaderDto dto = readerServices.getAvgAgeByBook(null);
    Assert.assertEquals(0, dto.getAvgAge());
  }

  /** Method: getAvgAgeByAuthor(String name) */
  @Test
  public void testGetAvgAgeByAuthorWrongName() {
    ReaderDto dto = readerServices.getAvgAgeByAuthor(WRONG_DATA);
    Assert.assertEquals(0, dto.getAvgAge());
  }

  /** Method: getAvgAgeByAuthor(String name) */
  @Test
  public void testGetAvgAgeByAuthorNullName() {
    ReaderDto dto = readerServices.getAvgAgeByAuthor(null);
    Assert.assertEquals(0, dto.getAvgAge());
  }
}
