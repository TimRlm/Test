package teko.biz.test.data.remote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import teko.biz.test.data.model.Action;

public interface Api {

    @GET("okinava_actions.php?token=98HQq2no")
    Observable<List<Action>> getList();
}
