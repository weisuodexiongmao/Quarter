package lei.com.yulei.quarter.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static OkHttpClient okHttpClient;

  private static ServiceAPI serviceAPI;

    private static ServiceAPI api;

    static {

        initOkhttpClient();

    }

    private static OkHttpClient initOkhttpClient() {

        if (okHttpClient==null){

            synchronized (RetrofitHelper.class){

                if (okHttpClient==null){

                    okHttpClient=new OkHttpClient.Builder()
                             .addInterceptor(new MyInterceptor())
                            .connectTimeout(20,TimeUnit.SECONDS)
                             .readTimeout(20, TimeUnit.SECONDS)
                            .build();

                }



            }

        }

        return okHttpClient;

    }

public static  ServiceAPI getAPI(){

if (serviceAPI==null){

    synchronized (ServiceAPI.class){

        if (serviceAPI==null){

          api = RetrofitHelper.createAPI(ServiceAPI.class, API.URL);

        }

    }

}

    return  api;

}

    /**

     *

     * @param clzz

     * @param url

     * @param <T>

     * @return

     */

    public static  <T> T createAPI(Class<T> clzz,String url){

        Retrofit retrofit=new Retrofit.Builder()

                .baseUrl(url)
                .client(okHttpClient)

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();

        return  retrofit.create(clzz);

    }

}