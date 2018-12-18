package teko.biz.test.data;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import teko.biz.test.App;
import teko.biz.test.data.local.PreferenceHelper;
import teko.biz.test.data.model.Action;
import teko.biz.test.data.remote.Api;

public class DataManager {
    private PreferenceHelper mPreferenceHelper;
    private Api mApi;

    public DataManager(Context context){
        mPreferenceHelper = new PreferenceHelper(context);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://smart-resto.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = retrofit.create(Api.class);
    }

    public Observable<List<Action>> getList(){
        return mApi.getList()
                .doOnNext(r->{ mPreferenceHelper.setList(r); })
                .onErrorReturn(t->mPreferenceHelper.getActions())
                .subscribeOn(Schedulers.io());
    }
}
