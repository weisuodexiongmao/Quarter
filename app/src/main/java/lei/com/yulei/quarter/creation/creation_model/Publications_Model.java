package lei.com.yulei.quarter.creation.creation_model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.creation.creation_bean.Essay_bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/25.
 */

public class Publications_Model {
    public void getcontent(final getcon getda,String uid,String content,String token){
        Map<String, String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("content",content);
        map.put("token",token);
        map.put("appVersion","2");
        Observable<Essay_bean> observable = RetrofitHelper.getAPI().essay(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Essay_bean>() {
                    @Override
                    public void accept(Essay_bean essay_bean) throws Exception {
                           getda.getdata(essay_bean);
                    }
                });
    }
    public interface getcon{
        void getdata(Essay_bean essay_bean);
    }
}
