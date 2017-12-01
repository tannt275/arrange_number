package apv.tannt.createdevfb;

import io.realm.RealmObject;

/**
 * Created by tan.nt on 11/29/17.
 */

public class CityObject extends RealmObject {

    private String name;
    private long votes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}
