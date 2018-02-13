import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * Created by djsul on 12/6/2016.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedFileExn {

        ISearchEngine s = new Examples2().setUp();
        BrowserWindow b = new BrowserWindow(s);
        b.screen();
    }
}
