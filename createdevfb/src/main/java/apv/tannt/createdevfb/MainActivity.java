package apv.tannt.createdevfb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;

public class MainActivity extends AppCompatActivity implements FacebookCallback<LoginResult>, AdapterView.OnItemClickListener {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    private ListView listView;
    private CityAdapter cityAdapter;
    private List<CityObject> listObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button);
        listView = findViewById(R.id.listView);

        loginButton.registerCallback(callbackManager, this);

        listObject = new ArrayList<>();
        cityAdapter = new CityAdapter();
        cityAdapter.setObjects(listObject);
        listView.setAdapter(cityAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<CityObject> cityObjects = loadCities();
        listObject.addAll(cityObjects);
        cityAdapter.notifyDataSetChanged();
    }

    private List<CityObject> loadCities() {
        List<CityObject> list;
        InputStream inputStream;
        try {
            inputStream = getAssets().open("cities.json");

            Gson gson = new Gson();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            CityObject[] cities = gson.fromJson(reader, CityObject[].class);
            list = Arrays.asList(cities);

            Database.sharedInstance.addListToDatabase(list);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return  list;
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.d("Main", " success " + loginResult);
    }

    @Override
    public void onCancel() {
        Log.d("Main", " cancel ");
    }

    @Override
    public void onError(FacebookException error) {
        Log.d("Main", " onError " + error);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("MainActivity", "in database " + Database.sharedInstance.getList().get(0).getName());
    }
}
