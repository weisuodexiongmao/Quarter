package lei.com.yulei.quarter.video.video_model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.utils.RetrofitHelper;
import lei.com.yulei.quarter.video.Video_bean.Nearby_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Videonearby_Model {
    public void nearby(final getnearby data, String page, String token){
        Map<String, String> map=new HashMap<>();
        map.put("page",page);
        map.put("latitude","39.95");
        map.put("longitude","116.30");
        map.put("token",token);
        map.put("appVersion","2");
        Observable<Nearby_Bean> observable = RetrofitHelper.getAPI().nearby(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Nearby_Bean>() {
                    @Override
                    public void accept(Nearby_Bean nearby_bean) throws Exception {
                        data.getnearby2(nearby_bean);
                    }
                });
    }
    public interface getnearby{
        void getnearby2(Nearby_Bean nearby_bean);
    }
}
