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
      addPage(s, "PageFiles/goats.md");
      addPage(s, "PageFiles/aboutWPI.md");
    } catch (FileNotFoundException e) {
      System.out.println("Aborting Example setup -- file not found: " + e);
    } catch (UnsupportedFileExn e) {
      System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
    }
  }
  
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
    assertTrue(s.visitPage("PageFiles/goats.md").getUrl().equals("PageFiles/goats.md"));
  }

  @Test
  public void testVisitPage2() throws UnsupportedFileExn, FileNotFoundException {
    assertTrue(s.visitPage("PageFiles/aboutWPI.md").getUrl().equals("PageFiles/aboutWPI.md"));
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

  @Test
  public void testAddSite() throws FileNotFoundException, UnsupportedFileExn {
    s.addSite("PageFiles/worcester.md");
    assertEquals(1, s.runQuery("worcester").size());
  }
}
