package lei.com.yulei.quarter.Personalworkscentre.centre_model;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.Personalworkscentre.centre_bean.Center_Bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/28.
 */

public class Contre_Model {
    public void contremodel(final getmodel data, Map<String,String> map){
        Observable<Center_Bean> observable = RetrofitHelper.getAPI().center(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Center_Bean>() {
                    @Override
                    public void accept(Center_Bean center_bean) throws Exception {
                          data.getcontremodel(center_bean);
                    }
                });
    }
    public interface getmodel{
        void getcontremodel(Center_Bean center_bean);
    }
}
