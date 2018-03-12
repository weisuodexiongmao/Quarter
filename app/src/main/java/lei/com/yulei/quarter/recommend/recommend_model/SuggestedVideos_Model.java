package lei.com.yulei.quarter.recommend.recommend_model;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.recommend.recommend_bean.SuggestedVideos_Bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/29.
 */

public class SuggestedVideos_Model {
    public void getvideos(final getSuggestedVideos data, Map<String,String>map){
        Observable<SuggestedVideos_Bean> observable = RetrofitHelper.getAPI().getvideos(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SuggestedVideos_Bean>() {
                    @Override
                    public void accept(SuggestedVideos_Bean suggestedVideos_bean) throws Exception {
                      data.getdata1(suggestedVideos_bean);
                    }
                });

    }
    public interface getSuggestedVideos{
        void getdata1(SuggestedVideos_Bean suggestedVideos_bean);
    }
}
