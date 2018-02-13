import java.util.LinkedList;

/**
 * Created by djsul on 11/21/2016.
 */
public class FailedLoginPattern implements IPattern{

    @Override
    public LinkedList<Alert> run(EventLog log, LinkedList<String>usernames) {
        LinkedList<Alert> suspicious = new LinkedList<Alert>();

        for (String u: usernames) {
            int counter = 0;
            int inFiveMin = 0;

            for(int i = 0; i < log.getLog().size(); i++) {
                AbsEvent curEvent = log.getLog().get(i);
                AbsEvent event1 = log.getLog().get(0);
                AbsEvent event2 = log.getLog().get(i);

                long diff = event1.getTimestamp().getTime() - event2.getTimestamp().getTime();

                if(curEvent.isByUser(u)) {
                    if((curEvent.getType() == AbsEvent.LOGIN) &&
                            (!((Login)curEvent).wasSuccessful())) {
                        counter++;

                        if(inFiveMin == 0) {
                            inFiveMin = 1;
                            event1 = log.getLog().get(i);
                        }

                        if(inFiveMin > 0 && inFiveMin < 3) {
                            if(diff / 60000 <= 5) {
                                counter++;
                                inFiveMin++;
                            }
                            else {
                                event1 = log.getLog().get(i);
                                inFiveMin = 0;
                            }
                        }
                    }
                }
            }

            if(counter > 0) {
                Alert alert = new Alert(u, counter, AbsEvent.LOGIN);

                suspicious.add(alert);
            }
        }
        return suspicious;
    }
}
