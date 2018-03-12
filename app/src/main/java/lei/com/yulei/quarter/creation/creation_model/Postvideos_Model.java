package lei.com.yulei.quarter.creation.creation_model;

import android.os.Environment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.creation.creation_bean.Postvideos_Bean;
import lei.com.yulei.quarter.utils.API;
import lei.com.yulei.quarter.utils.ServiceAPI;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 猥琐的熊猫 on 2018/1/26.
 */

public class Postvideos_Model {
    public void getvideos(final videos dada, String uid, String token){
       //视频File
        String s = Environment.getExternalStorageDirectory() + "/haodeba.mp4";
        File file=new File(s);
        String ss = Environment.getExternalStorageDirectory() + "/1513341066240.jpg";
        File file1=new File(ss);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
        MultipartBody.Part part = MultipartBody.Part.createFormData("videoFile", file.getName(), requestBody);
        MultipartBody.Part part2 = MultipartBody.Part.createFormData("coverFile", file1.getName(), requestBody1);

        Map<String, String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("token",token);
        map.put("appVersion","2");
        map.put("source","android");
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(API.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Observable<Postvideos_Bean> observable = serviceAPI.videos(map,part,part2);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Postvideos_Bean>() {
                    @Override
                    public void accept(Postvideos_Bean postvideos_bean) throws Exception {
                        dada.getdata(postvideos_bean);
                    }
                });

    }
    public interface videos{
        void getdata(Postvideos_Bean postvideos_bean);
    }
}
