import java.util.Comparator;

/**
 * Created by djsul on 11/21/2016.
 */
public class Alert implements Comparable{
    String username;
    int severity;
    int event;

    Alert(String username, int severity, int event) {
        this.username = username;
        this.severity = severity;
        this.event = event;
    }

    public int compareTo(Object otherObj) {
        Alert other = (Alert) otherObj;

        if(this.severity > other.severity) {
            return -1;
        }
        else if(this.severity < other.severity) {
            return 1;
        }
        else return 0;
    }

    public boolean equals(Object otherObj) {
        Alert other = (Alert) otherObj;

        if(this.username.equals(other.username) &&
                this.severity == other.severity &&
                this.event == other.event) {
            return true;
        }
        return false;
    }
}
