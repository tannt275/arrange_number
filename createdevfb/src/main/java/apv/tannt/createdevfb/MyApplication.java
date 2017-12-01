package apv.tannt.createdevfb;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by tan.nt on 11/29/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Database.sharedInstance.onConfigDatabase();
    }
}
