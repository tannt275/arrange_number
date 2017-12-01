package apv.tannt.createdevfb;

import java.util.Collection;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by tan.nt on 11/29/17.
 */

public class Database {
    private RealmConfiguration configuration = new RealmConfiguration.Builder().name("demo.realm").build();
    public static Database sharedInstance = new Database();
    private Realm realm;

    public void onConfigDatabase(){
        Realm.setDefaultConfiguration(configuration);
    }

    public void addListToDatabase(final List<CityObject> cities) {
        realm = Realm.getInstance(configuration);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (CityObject cityObject: cities){
                    CityObject object = realm.createObject(CityObject.class);
                    object.setName(cityObject.getName());
                    object.setVotes(cityObject.getVotes());
                }
            }
        });
    }


    public List<CityObject> getList() {
        realm = Realm.getInstance(configuration);
        RealmQuery<CityObject> query = realm.where(CityObject.class);
        RealmResults<CityObject> results = query.findAll();
        return  results;
    }

}
