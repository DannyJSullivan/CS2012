import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by djsul on 12/6/2016.
 */

public class CacheList extends Exception implements ICache{
    LinkedList<Cache> cacheList = new LinkedList<>();

    Cache findCache(String query) {
        for(Cache c: cacheList) {
            if(c.getQuery().equals(query)) {
                return c;
            }
        }
        return null;
    }

    void addNewCache(Cache cache) {
        cacheList.add(cache);
    }

    void addSiteToCache(Webpage page) {
        String title = stripFillers(page.getTitle());
        String body = stripFillers(page.getBody());

        for(Cache c: cacheList) {
            if(c.getQuery().contains(title)) {
                c.getPages().add(page);
            }
            else if(body.contains(c.getQuery())) {
                c.getPages().add(page);
            }
        }
    }

    public boolean alreadySawQ(String query) {
        query = query.toLowerCase();

        for(Cache c: cacheList) {
            if(c.getQuery().equals(query)) {
                return true;
            }
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
