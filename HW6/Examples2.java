import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * Created by djsul on 12/6/2016.
 */
public class Examples2 {
    ISearchEngine setUp() throws FileNotFoundException, UnsupportedFileExn {
        LinkedList<String> init = new LinkedList<>();
        init.add("./src/aboutWPI.md");
        init.add("./src/goats.md");
        init.add("./src/worcester.md");

        return new SearchEngine(init);
    }
}
