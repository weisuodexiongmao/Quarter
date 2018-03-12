package lei.com.yulei.quarter.recommend.recommend_model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.recommend.recommend_bean.Adver_Bean;
import lei.com.yulei.quarter.utils.API;
import lei.com.yulei.quarter.utils.ServiceAPI;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public class Ader_model {
    public void getader(final ader data){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(API.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Observable<Adver_Bean> observable = serviceAPI.adver();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Adver_Bean>() {
                    @Override
                    public void accept(Adver_Bean adver_bean) throws Exception {
                        data.aderdata(adver_bean);
                    }
                });

    }
    public interface ader{
        void aderdata(Adver_Bean adver);
    }
}
