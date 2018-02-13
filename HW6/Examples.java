/*
 * If you are looking at this file before Thurs/Fri, the try/catch
 * statements won't make sense (unless you already know exceptions).
 * By Friday, we will cover those.  In the meantime, you can write
 * tests by creating your search engine classes in the Examples
 * constructor, as indicated by the comments.
 */

import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class Examples extends Exception{
  // declare variables for all of your search engines here
  SearchEngine s; 
  
  // local method to add a page to a search engine.  Created a
  //   helper so that we can isolate the exception handling here,
  //   rather than clutter up each test case with the exceptions
  private void addPage(SearchEngine s, String p) {
    try {
      s.visitPage(p);
    } catch (FileNotFoundException e) {
      fail("Aborting Example setup -- file not found: " + e);
    } catch (UnsupportedFileExn e) {
      fail("Aborting Examples setup -- unsupported file extension: " + e);
    }
  }
  
  public Examples(){
    try {
      // set up all of your search engines with pages here
      // rather than in the individual tests (or you will have
      // to copy the exceptions code into the test classes)
      s = new SearchEngine(new LinkedList<String>());
      //addPage(s, "PageFiles/goats.md");
      //addPage(s, "PageFiles/aboutWPI.md");
    } catch (FileNotFoundException e) {
      System.out.println("Aborting Example setup -- file not found: " + e);
    } catch (UnsupportedFileExn e) {
      System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
    }
  }

  /**
  
  @Test
  public void testGoatsQuery() {
    assertEquals(s.runQuery("goat").size(), 2);
  }
  
  @Test
  public void testWPIQuery() {
    assertEquals(s.runQuery("WPI").size(), 1);
    addPage(s, "PageFiles/worcester.md");
    assertEquals(s.runQuery("WPI").size(), 2);
  }

  @Test
  public void testVisitPage() throws UnsupportedFileExn, FileNotFoundException {
    assertTrue(s.visitPage("PageFiles/goats.md").url.equals("PageFiles/goats.md"));
  }

  @Test
  public void testVisitPage2() throws UnsupportedFileExn, FileNotFoundException {
    assertTrue(s.visitPage("PageFiles/aboutWPI.md").url.equals("PageFiles/aboutWPI.md"));
  }

  @Test
  public void knownPageCount() {
    assertEquals(2, s.knownPageCount());
  }

  @Test
  public void knownPageCount2() {
    addPage(s, "PageFiles/worcester.md");
    assertEquals(3, s.knownPageCount());
  }

  @Test
  public void knownPageCount3() {
    addPage(s, "PageFiles/worcester.md");
    addPage(s, "./src/aboutWPI.md");
    assertEquals(4, s.knownPageCount());
  }

  @Test
  public void testAlreadySawQ() {
    s.runQuery("WPI");
    s.runQuery("goat");
    assertTrue(s.alreadySawQuery("WPI"));
  }

  @Test
  public void testAlreadySawQ2() {
    s.runQuery("WPI");
    s.runQuery("goat");
    assertTrue(s.alreadySawQuery("goat"));
  }

  @Test
  public void testAlreadySawQ3() {
    s.runQuery("WPI");
    assertFalse(s.alreadySawQuery("goat"));
  }

  @Test
  public void testAlreadySawQ4() {
    s.runQuery("hey");
    assertTrue(s.alreadySawQuery("hey"));
  }

  @Test
  public void testAlreadySawQ5() {
    s.runQuery("hey");
    assertFalse(s.alreadySawQuery("hello"));
  }

  /**
  @Test
  public void testAddSite() throws FileNotFoundException, UnsupportedFileExn {
    s.addSite("PageFiles/worcester.md");
    assertEquals(1, s.runQuery("worcester").size());
  }
  **/

  @Test(expected = InvalidRateException.class)
  public void invalidRateTest1() throws LowerRateException, InvalidRateException {
    s.updateSponsor("WPI", 2.0);
  }

  @Test(expected = InvalidRateException.class)
  public void invalidRateTest2() throws LowerRateException, InvalidRateException {
    s.updateSponsor("test", 1.1);
  }

  @Test(expected = InvalidRateException.class)
  public void invalidRateTest3() throws LowerRateException, InvalidRateException {
    s.updateSponsor("test", -0.1);
  }

  @Test
  public void validRateTest1() throws LowerRateException, InvalidRateException {
    s.updateSponsor("WPI", 0.05);
  }

  @Test
  public void validRateTest2() throws LowerRateException, InvalidRateException {
    s.updateSponsor("test", .1);
  }

  @Test
  public void validRateTest3() throws LowerRateException, InvalidRateException {
    s.updateSponsor("test", 0.0);
  }

  @Test(expected = LowerRateException.class)
  public void lowerRateExceptionTest1() throws LowerRateException, InvalidRateException {
    s.updateSponsor("WPI", .05);
    s.updateSponsor("WPI", .01);
  }

  @Test(expected = LowerRateException.class)
  public void lowerRateExceptionTest2() throws LowerRateException, InvalidRateException {
    s.updateSponsor("WPI", .05);
    s.updateSponsor("WPI", .04);
  }

  @Test
  public void runQueryTest1() throws LowerRateException, InvalidRateException, UnsupportedFileExn, FileNotFoundException {
    s.visitPage("PageFiles/aboutWPI.md").rank = 5.0;
    s.runQuery("WPI");
    System.out.print(s.visitPage("PageFiles/aboutWPI.md").rank);
  }

  @Test
  public void runQueryTest2() throws LowerRateException, InvalidRateException, UnsupportedFileExn, FileNotFoundException {
    s.visitPage("PageFiles/aboutWPI.md").rank = 5.0;
    System.out.print(s.visitPage("PageFiles/aboutWPI.md").rank);
  }

  @Test
  public void testRanking1() {
    LinkedList<Webpage> pages = new LinkedList<>();
    Webpage page1 = new Webpage("page1", "page1.com", "page1", new LinkedList<>());
    Webpage page2 = new Webpage("page2", "page2.com", "page2", new LinkedList<>());
    Webpage page3 = new Webpage("page3", "page3.com", "page3", new LinkedList<>());
    page1.rank = .01;
    page2.rank = .03;
    page3.rank = .07;
    pages.add(page1);
    pages.add(page2);
    pages.add(page3);

    s.orderByRank(pages);

    for(Webpage w: pages) {
      System.out.println(w.getUrl());
    }
  }

  @Test
  public void testRanking2() {
    LinkedList<Webpage> pages = new LinkedList<>();
    Webpage page1 = new Webpage("page1", "page1.com", "page1", new LinkedList<>());
    Webpage page2 = new Webpage("page2", "page2.com", "page2", new LinkedList<>());
    Webpage page3 = new Webpage("page3", "page3.com", "page3", new LinkedList<>());
    page1.rank = .01;
    page2.rank = .09;
    page3.rank = .07;
    pages.add(page1);
    pages.add(page2);
    pages.add(page3);

    s.orderByRank(pages);

    for(Webpage w: pages) {
      System.out.println(w.getUrl());
    }
  }
  @Test
  public void testRanking3() {
    LinkedList<Webpage> pages = new LinkedList<>();
    Webpage page1 = new Webpage("page1", "page1.com", "page1", new LinkedList<>());
    Webpage page2 = new Webpage("page2", "page2.com", "page2", new LinkedList<>());
    Webpage page3 = new Webpage("page3", "page3.com", "page3", new LinkedList<>());
    page1.rank = .09;
    page2.rank = .08;
    page3.rank = .07;
    pages.add(page1);
    pages.add(page2);
    pages.add(page3);

    s.orderByRank(pages);

    for(Webpage w: pages) {
      System.out.println(w.getUrl());
    }
  }

  @Test
  public void testRanking4() {
    LinkedList<Webpage> pages = new LinkedList<>();
    Webpage page1 = new Webpage("page1", "page1.com", "page1", new LinkedList<>());
    Webpage page2 = new Webpage("page2", "page2.com", "page2", new LinkedList<>());
    Webpage page3 = new Webpage("page3", "page3.com", "page3", new LinkedList<>());
    page1.rank = .09;
    page2.rank = .09;
    page3.rank = .05;
    pages.add(page1);
    pages.add(page2);
    pages.add(page3);

    s.orderByRank(pages);

    for(Webpage w: pages) {
      System.out.println(w.getUrl());
    }
  }

  @Test
  public void testRanking5()  {
    LinkedList<Webpage> pages = new LinkedList<>();
    Webpage page1 = new Webpage("page1", "page1.com", "page1", new LinkedList<>());
    Webpage page2 = new Webpage("page2", "page2.com", "page2", new LinkedList<>());
    Webpage page3 = new Webpage("page3", "page3.com", "page3", new LinkedList<>());
    page1.rank = .09;
    page2.rank = .09;
    page3.rank = .1;
    pages.add(page1);
    pages.add(page2);
    pages.add(page3);

    s.orderByRank(pages);

    for(Webpage w: pages) {
      System.out.println(w.getUrl());
    }
  }

  @Test
  public void distribuitionTest1() {
    LinkedList<Webpage> expectList = new LinkedList<>();

    LinkedList<String> URLs = new LinkedList<>();
    URLs.add("goats.md");
    URLs.add("worcester.md");

    LinkedList<String> URLs2 = new LinkedList<>();
    URLs2.add("aboutWPI.md");

    SponsorshipList sponsors = new SponsorshipList();
    sponsors.addSponsor("WPI", .1);
    sponsors.addSponsor("goats", .05);

    Webpage page1 = new Webpage("goats.md", "caringforgoats", "goatsGoatIsMascotOfWPI", URLs2);
    Webpage page2 = new Webpage("aboutWPI.md", "WPIisCool", "worcesterHasWPI", URLs);
    Webpage page3 = new Webpage("worcester.md", "worcesterIsCool", "worcesterIsCityWithWPI", URLs2);

    page1.rank = .55;
    page2.rank = 2.1;
    page3.rank = .5;

    expectList.add(page2);
    expectList.add(page1);
    expectList.add(page3);

    s.addWebpage(page1);
    s.addWebpage(page2);
    s.addWebpage(page3);

    for(Webpage w: expectList) {
      System.out.println(w.getUrl());
    }

    // expecting (in order) aboutWPI.md, goats.md, worcester.md
  }
}
