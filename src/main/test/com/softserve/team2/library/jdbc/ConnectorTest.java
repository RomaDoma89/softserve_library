package com.softserve.team2.library.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Connector Tester.
 *
 * @author Roma Zahorui
 * @version 1.0
 */
public class ConnectorTest {

  @Before
  public void before() throws Exception {}

  @After
  public void after() throws Exception {}

  /** Method: getConnection() */
  @Test
  public void testGetConnection() {
    Assert.assertNotNull(Connector.getConnection());
  }
}
