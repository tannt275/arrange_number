package helper;

import android.app.Application;
import android.content.Context;

/**
 * Created by tan.nt on 11/30/17.
 */

public class MyApplication extends Application {
    public static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
