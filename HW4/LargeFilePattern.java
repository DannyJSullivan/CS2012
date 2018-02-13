/**
 * Created by djsul on 11/21/2016.
 */
import java.util.LinkedList;

public class LargeFilePattern implements IPattern{

    @Override
    public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {
        LinkedList<Alert> suspicious = new LinkedList<>();

        for(String u: usernames) {
            int counter = 0;

            for (AbsEvent e : log.getLog()) {
                if (((e.isByUser(u)) &&
                        (e.getType() == AbsEvent.FILE_SAVED) &&
                        (((FileSaved) e).getSize() > 1000000))) {

                    counter++;
                }
            }
            if(counter > 1) {
                Alert alert = new Alert(u, counter, AbsEvent.FILE_SAVED);

                suspicious.add(alert);
            }
        }
        return suspicious;
    }
}