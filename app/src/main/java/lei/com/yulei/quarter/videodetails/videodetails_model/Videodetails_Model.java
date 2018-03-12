package lei.com.yulei.quarter.videodetails.videodetails_model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.utils.RetrofitHelper;
import lei.com.yulei.quarter.videodetails.videodetails_bean.VideoDetails_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/28.
 */

public class Videodetails_Model {
    public void getdetails(final details data, String str){
        Observable<VideoDetails_Bean> observable = RetrofitHelper.getAPI().details(str);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoDetails_Bean>() {
                    @Override
                    public void accept(VideoDetails_Bean videoDetails_bean) throws Exception {
                        data.getdetails1(videoDetails_bean);
                    }
                });
    }
    public interface details{
        void getdetails1(VideoDetails_Bean videoDetails_bean);
    }
}
