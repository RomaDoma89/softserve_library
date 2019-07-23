package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.entities.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * BookService Tester.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class BookServiceWrongDataTest {

  private final String WRONG_DATA = "lksjdf098304590";
  private BookService bookService;

  @Before
  public void before() {
    bookService = new BookService();
  }

  @After
  public void after() {}

  /**
   * Method: findAverageReadingBook(String title). Try to put <code>WRONG_DATA</code> as the
   * parameters. Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindAverageReadingBookWrongTitle() {
    BookDto dto = bookService.findAverageReadingBook(WRONG_DATA);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findAverageReadingBook(String title). Try to put NULL as the parameters. Expected that
   * <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindAverageReadingBookNullTitle() {
    BookDto dto = bookService.findAverageReadingBook(null);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findPopular(String firstDate, String secondDate). Try to put <code>WRONG_DATA</code> as
   * the parameters. Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindPopularWrongPeriod() {
    BookDto dto = bookService.findPopular(WRONG_DATA, WRONG_DATA);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findPopular(String firstDate, String secondDate). Try to put NULL as the parameters.
   * Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindPopularNullPeriod() {
    BookDto dto = bookService.findPopular(null, null);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findNotPopular(String firstDate, String secondDate). Try to put <code>WRONG_DATA</code>
   * as the parameters. Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindNotPopularWrongPeriod() {
    BookDto dto = bookService.findNotPopular(WRONG_DATA, WRONG_DATA);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findNotPopular(String firstDate, String secondDate). Try to put NULL as the parameters.
   * Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindNotPopularNullPeriod() {
    BookDto dto = bookService.findNotPopular(null, null);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findUsingTotal(String title). Try to put <code>WRONG_DATA</code> as the parameter.
   * Expected that <code>dto.getCount()</code> equals 0.
   */
  @Test
  public void testFindUsingWrongTotal() {
    BookDto bookDto = bookService.findUsingTotal(WRONG_DATA);
    Assert.assertEquals(0, bookDto.getCount());
  }

  /**
   * Method: findUsingTotal(String title). Try to put NULL as the parameter. Expected that <code>
   * dto.getCount()</code> equals 0.
   */
  @Test
  public void testFindUsingNullTotal() {
    BookDto dto = bookService.findUsingTotal(null);
    Assert.assertEquals(0, dto.getCount());
  }

  /**
   * Method: findUsingByCopies(String title). Try to put <code>WRONG_DATA</code> as the parameter.
   * Expected that <code>dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindUsingByWrongCopies() {
    List<BookDto> dtoList = bookService.findUsingByCopies(WRONG_DATA);
    Assert.assertEquals(0, dtoList.size());
  }

  /**
   * Method: findUsingByCopies(String title). Try to put NULL as the parameter. Expected that <code>
   * dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindUsingByNullCopies() {
    List<BookDto> dtoList = bookService.findUsingByCopies(null);
    Assert.assertEquals(0, dtoList.size());
  }

  /**
   * Method: findByPeriod(String firstDate, String secondDate). Try to put <code>WRONG_DATA</code>
   * as the parameters. Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindByWrongPeriod() {
    BookDto dto = bookService.findByPeriod(WRONG_DATA, WRONG_DATA);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findByPeriod(String firstDate, String secondDate). Try to put NULL as the parameters.
   * Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindByNullPeriod() {
    BookDto dto = bookService.findByPeriod(null, null);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findBookByTitle(String title). Try to put <code>WRONG_DATA</code> as the <code>title
   * </code> parameter. Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindBookByWrongTitle() {
    BookDto dto = bookService.findBookByTitle(WRONG_DATA);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findBookByTitle(String title). Try to put NULL as the <code>title</code> parameter.
   * Expected that <code>dto.getId()</code> equals 0.
   */
  @Test
  public void testFindBookByNullTitle() {
    BookDto dto = bookService.findBookByTitle(null);
    Assert.assertEquals(0, dto.getId());
  }

  /**
   * Method: findBooksByAuthor(String author). Try to put <code>WRONG_DATA</code> as the <code>
   * author</code> parameter. Expected that <code>dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindBooksByWrongAuthor() {
    List<BookDto> dtoList = bookService.findBooksByAuthor(WRONG_DATA);
    Assert.assertEquals(0, dtoList.size());
  }

  /**
   * Method: findBooksByAuthor(String author). Try to put NULL as the <code>author</code> parameter.
   * Expected that <code>dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindBooksByNullAuthor() {
    List<BookDto> dtoList = bookService.findBooksByAuthor(null);
    Assert.assertEquals(0, dtoList.size());
  }

  /**
   * Method: findCopiesAvailabilityByTitle(String title). Try to put <code>WRONG_DATA</code> string
   * data as the <code>title</code> parameter. Expected that <code>dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindCopiesByWrongTitle() {
    List<BookDto> dtoList = bookService.findCopiesAvailabilityByTitle(WRONG_DATA);
    Assert.assertEquals(0, dtoList.size());
  }

  /**
   * Method: findCopiesAvailabilityByTitle(String title). Try to put NULL as the <code>title</code>
   * parameter. Expected that <code>dtoList.size()</code> equals 0.
   */
  @Test
  public void testFindCopiesByNullTitle() {
    List<BookDto> dtoList = bookService.findCopiesAvailabilityByTitle(null);
    Assert.assertEquals(0, dtoList.size());
  }
}
