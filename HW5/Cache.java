/**
 * Created by djsul on 12/4/2016.
 */
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

public class Cache extends Exception {
    private String query;
    private LinkedList<Webpage> pages;

    Cache(String query, LinkedList<Webpage> pages) {
        this.query = query;
        this.pages = pages;
    }

    public String getQuery() {
        return this.query;
    }

    public LinkedList<Webpage> getPages() {
        return this.pages;
    }

    public boolean compareQuery(String query) {
        if (this.query.equals(query)) {
            return true;
        }
        return false;
    }
    /**
    public void addPage(SearchEngine s,String page) throws FileNotFoundException, UnsupportedFileExn {
        s.visitPage(page);
    }
     **/
}