/* Starter file for homework 5 
 * 
 * The file is marked throughout with what you can, cannot, and should not need to edit.
 */

import java.util.*;
import java.io.*;

class SearchEngine implements ISearchEngine {
  // leave these first two variables alone
  Scanner keyboard = new Scanner(System.in);
  SimpleMarkdownReader m = new SimpleMarkdownReader();
  
  // you are welcome to replace the pages variable with your own data structures.
  // the specific name "pages" will not be referenced in any of our tests/autograding
  private LinkedList<Webpage> pages = new LinkedList<>();
  private CacheList caches = new CacheList();
  private  SponsorshipList sponsorList = new SponsorshipList();
  // HashMap<String, LinkedList<Webpage>> pages = new HashMap<>();

  // constructor
  // you are welcome to change what the constructor does, as long as you leave the header intact
  SearchEngine(LinkedList<String> initPages) throws FileNotFoundException, UnsupportedFileExn {
    for (String pageLoc : initPages) {
      pages.add(addSite(pageLoc));
    }
  };
 
  // ****** THE SEARCH ENGINE METHODS YOU NEED TO PROVIDE ***********
  // Even if you encapsulate (full version), leave methods with these headers
  //   in the SearchEngine class (our tests/autograding expect to find them here)
 
  // given query string, produce webpages that meet query
  // you will need to edit this, but do not edit the header (autograding expects this)

  public LinkedList<Webpage> runQuery(String query) {
    LinkedList<Webpage> pages = new LinkedList<>();

    for(Webpage w: pages) {
      w.rank = 0;
    }

    this.rankPages();
    this.distributeCredit();

    if (alreadySawQuery(stripFillers(query.toLowerCase()))) {
      Cache cache = caches.findCache(stripFillers(query.toLowerCase()));
      return orderByRank(cache.getPages());
    }
    else {
      for (Webpage w : pages) {
        String strippedQuery = stripFillers(query.toLowerCase());
        String title = stripFillers(w.getTitle().toLowerCase());
        String body = stripFillers(w.getBody().toLowerCase());

        if(title.contains(strippedQuery) || body.contains(strippedQuery)) {
          pages.add(w);
        }
      }
    }

    Cache newCache = new Cache(stripFillers(query.toLowerCase()), pages);
    caches.addNewCache(newCache);
    return orderByRank(pages);
  }
  
  // given a page location, return the corresponding page after updating queries
  // you will need to edit this, but do not edit the header (autograding expects this)
  public Webpage visitPage(String location) throws UnsupportedFileExn, FileNotFoundException {
    for(Webpage w: pages) {
      if(w.compareURL(location)) {
        return w;
      }
    }
    Webpage webpage = this.addSite(location);
    pages.add(webpage);
    caches.addSiteToCache(webpage);
    return webpage;
  }
  
  // produce the number of web pages known in the system
  // you are welcome to edit this method as long as you leave the header intact (autograding expects this)
  public int knownPageCount() {
    return pages.size();
  }
  
  // determine whether given query has been seen in the search engine
  // you will need to edit this, but do not edit the header (autograding expects this)
  public boolean alreadySawQuery(String query) {
    return caches.alreadySawQ(stripFillers(query.toLowerCase()));
  }

  // ****** ADDING SITES TO THE ENGINE ***************
  // parses given file into a webpage
  // you are welcome to edit this method as long as you leave the header intact.
  // you should NOT need to edit the call to readPage (you may want to add statements around it though)
  Webpage addSite(String locationName) throws UnsupportedFileExn, FileNotFoundException {
    Webpage newWP;
    if (locationName.endsWith(".md")) {
      return(m.readPage(locationName));
    } else {
      throw new UnsupportedFileExn(locationName);
    }
  }

  void updateSponsor(String sponsor, double payRate) throws InvalidRateException, LowerRateException {
    if (payRate > .1 || payRate < 0) {
      throw new InvalidRateException(payRate);
    }
    if(sponsorList.contains(sponsor.toLowerCase()) && sponsorList.getOldRate(sponsor.toLowerCase()) > payRate) {
      throw new LowerRateException(sponsorList.getOldRate(sponsor.toLowerCase()), payRate);
    }
    if (sponsorList.contains(sponsor.toLowerCase())) {
      sponsorList.replace(sponsor.toLowerCase(), payRate);
    }
    else {
      sponsorList.addSponsor(sponsor.toLowerCase(), payRate);
    }
  }

  LinkedList<Webpage> orderByRank(LinkedList<Webpage> webpages) {
    Collections.sort(webpages);
    return webpages;
  }

  public void rankPages() {
    for(Webpage w: pages) {
      w.rank = sponsorList.getSponsoredRate(w.url);
    }
  }

  public void addSponsoredRate() {
    for(Webpage w: pages) {
      w.rank += w.sponsors.getSponsoredRate(w.url);
    }
  }

  public void distributeCredit()  {
    for(Webpage w: pages) {
      int linkNum = w.refURLsNoSelf().size();
      Double splitCredits = (1.0/linkNum);

      for(String s: w.refURLsNoSelf()) {
        for(Webpage v: pages) {
          if(v.url.equals(s)) {
            v.addRank(splitCredits);
          }
        }
      }
    }
  }

  public void addWebpage(Webpage page) {
    pages.add(page);
  }

  // ****** REMOVING FILLER WORDS FROM QUERIES *****************
  // Don't edit either the list of fillerWords or the stripFillers method
  private LinkedList<String> fillerWords = 
    new LinkedList<String>(Arrays.asList("a", "an", "the", "of", "on", "in", 
                                         "to", "by", "about", "how", "is",
                                         "what", "when"
                                        ));
  
  // remove the filler words from a string
  // assume string has no punctuation
  private String stripFillers(String query) {
    String[] wordArray = query.toLowerCase().split(" ");
    String resultStr = "";
    for (int i = 0 ; i < wordArray.length ; i++) {
      if (!(fillerWords.contains(wordArray[i])))
        resultStr = resultStr + wordArray[i];
    }
    return resultStr;
  }
}