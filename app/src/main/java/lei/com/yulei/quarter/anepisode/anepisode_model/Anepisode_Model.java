package lei.com.yulei.quarter.anepisode.anepisode_model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.anepisode.anepisode_bean.Anepisode_Bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/24.
 */

public class Anepisode_Model {
    public void getmod(final getanep data){
        Map<String, String> map=new HashMap<>();
       map.put("appVersion","2");
        map.put("page","1");
        Observable<Anepisode_Bean> observable = RetrofitHelper.getAPI().joke(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Anepisode_Bean>() {
                    @Override
                    public void accept(Anepisode_Bean anepisode_bean) throws Exception {
                        data.anep(anepisode_bean);
                    }
                });
    }
    public interface getanep{
        void anep(Anepisode_Bean anepisode_bean);
    }
}
