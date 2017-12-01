package model;

import com.google.gson.Gson;

/**
 * Created by tan.nt on 11/9/17.
 */

public class MBase {
    public String convertData(){
        return new Gson().toJson(this);
    }
}
