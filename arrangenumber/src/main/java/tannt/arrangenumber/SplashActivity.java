package tannt.arrangenumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;

import helper.AppConstant;
import helper.AppPref;

public class SplashActivity extends AppCompatActivity {

    private String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        boolean isChosen = AppPref.getBoolean(AppConstant.WAS_CHOOSE_LANGUAGE, false);
        if (!isChosen) {
            showDialogChooseLanguage();
        } else {
            onNavigateToMain();
        }
    }

    /**
     * choose language for the first use
     */
    private void showDialogChooseLanguage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.title_choose_language));
        builder.setCancelable(false);

        final String [] languages = getResources().getStringArray(R.array.string_locale);
        builder.setItems(languages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Log.d(TAG, "choose language = " + languages[i]);
                chooseLanguage(i);
            }
        });
        builder.show();
    }

    /**
     * save language and state choose to SharePreference
     * @param index **this is index of array languages**
     */
    private void chooseLanguage(int index) {
        String [] languages = getResources().getStringArray(R.array.id_languages);
        //put select to Preference
        AppPref.setString(AppConstant.CHOOSE_LANGUAGE, languages[index]);
        AppPref.setBoolean(AppConstant.WAS_CHOOSE_LANGUAGE, true);
        //update locale app
        updateAppLocale(languages[index]);
        //navigate to Main
        onNavigateToMain();
    }

    /**
     * update locale for App
     * @param locale **this is locale**
     */
    private void updateAppLocale(String locale){
        Resources res = this.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(locale.toLowerCase()));
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);
    }

    private void onNavigateToMain(){
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
        finish();
    }
}
