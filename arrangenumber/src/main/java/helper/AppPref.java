package helper;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by tan.nt on 11/30/17.
 */

public class AppPref {

    private static SharedPreferences pref;

    public static SharedPreferences getPref() {
        if (pref == null)
            pref = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        return pref;
    }

    public static void setString(String key, String value){
        SharedPreferences.Editor editor = getPref().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key, String defaultValue){
        return  getPref().getString(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value){
        SharedPreferences.Editor editor = getPref().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(String  key, boolean defaultValue){
        return getPref().getBoolean(key, defaultValue);
    }
}
