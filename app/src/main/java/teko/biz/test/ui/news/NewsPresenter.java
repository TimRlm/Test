package teko.biz.test.ui.news;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import teko.biz.test.App;
import teko.biz.test.data.DataManager;
import teko.biz.test.data.model.Action;

class NewsPresenter {
    private DataManager dm = App.dm;
    private NewsView view;
    private Disposable disposable;

    public NewsPresenter(NewsView newsFragment) {
        view = newsFragment;
    }

    public void destroy() {
        view = null;
        if (disposable != null){
            disposable.dispose();
            disposable = null;
        }
    }

    public void load() {
        disposable = dm.getList()
                .map(r -> {
                    List<Action> res = r;
                    Collections.sort(res, (o1, o2)->{
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            Long d = format.parse("").getTime();
                        }catch (Exception e){}
                        return 0;
                    });
                    return res;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r->{
                    view.updList(r);
                },t->{
                    view.error();
                });
    }
}
