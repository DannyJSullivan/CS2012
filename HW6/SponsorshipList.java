import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by djsul on 12/13/2016.
 */
public class SponsorshipList implements ISponsorshipList {
    HashMap<String, Double> sponsorList = new HashMap<>();

    public void addSponsor(String sponsor, double payRate) {
        sponsorList.put(sponsor.toLowerCase(), payRate);
    }

    public boolean contains(String sponsor) {
        return sponsorList.containsKey(sponsor.toLowerCase());
    }

    public void replace(String sponsor, double payRate) {
        sponsorList.replace(sponsor.toLowerCase(), payRate);
    }

    public double getOldRate(String sponsor) {
        return sponsorList.get(sponsor);
    }

    public double getSponsoredRate(String url) {
        for(String s: sponsorList.keySet()) {
            if(url.contains(s)) {
                return getOldRate(s);
            }
        }
        return 0;
    }
}
