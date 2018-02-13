/**
 * Created by djsul on 12/13/2016.
 */
public interface ISponsorshipList {
    void addSponsor(String sponsor, double payRate);
    boolean contains(String sponsor);
    void replace(String sponsor, double payRate);
}
