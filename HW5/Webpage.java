import java.util.Arrays;
import java.util.LinkedList;

class Webpage {
  private String url;
  private String title;
  private String body;
  private LinkedList<String> referencedURLs;
  
  // The constructor converts title and body to lowercase, to ease
  //  other computations later
  Webpage(String locator, String title, String body,
          LinkedList<String> referencedURLs) {
    this.url = locator;
    this.title = title.toLowerCase();
    this.body = body.toLowerCase();
    this.referencedURLs = referencedURLs;
  }

  String getTitle() {
    return this.title;
  }

  String getBody() {
    return this.body;
  }

  String getUrl() {
    return this.url;
  }

  boolean compareURL(String location) {
    if(this.url.equals(location)) {
      return true;
    }
    return false;
  }

  boolean bodyEquals(String strippedQuery) {
    body = stripFillers(body);

    if (body.contains(strippedQuery)) {
      return true;
    }
    return false;
  }

  boolean titleEquals(String strippedQuery) {
    title = stripFillers(title);

    if (title.contains(strippedQuery)) {
      return true;
    }
    return false;
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