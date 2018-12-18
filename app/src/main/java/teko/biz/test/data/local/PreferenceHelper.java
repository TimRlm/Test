package teko.biz.test.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import teko.biz.test.data.model.Action;

public class PreferenceHelper {
    private SharedPreferences mPref;
    private Gson gson = new Gson();


    public PreferenceHelper(Context context){
        mPref = context.getSharedPreferences("q",Context.MODE_PRIVATE);
    }

    public List<Action> getActions(){
        String json = mPref.getString("Actions","");
        if (json.length()==0) return null;
        Action[] actions = gson.fromJson(json,Action[].class);
        return Arrays.asList(actions);
    }

    public void setList(List<Action> actions){
        mPref.edit().putString("Actions",gson.toJson(actions));
    }
}
