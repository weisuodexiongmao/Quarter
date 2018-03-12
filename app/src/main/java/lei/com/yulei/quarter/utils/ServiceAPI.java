package lei.com.yulei.quarter.utils;

import java.util.Map;

import io.reactivex.Observable;
import lei.com.yulei.quarter.Personalworkscentre.centre_bean.Center_Bean;
import lei.com.yulei.quarter.anepisode.anepisode_bean.Anepisode_Bean;
import lei.com.yulei.quarter.creation.creation_bean.Essay_bean;
import lei.com.yulei.quarter.creation.creation_bean.Postvideos_Bean;
import lei.com.yulei.quarter.login.login_Bean.Login_Bean;
import lei.com.yulei.quarter.recommend.recommend_bean.Adver_Bean;
import lei.com.yulei.quarter.recommend.recommend_bean.SuggestedVideos_Bean;
import lei.com.yulei.quarter.register.reg_bean.Reg_Bean;
import lei.com.yulei.quarter.video.Video_bean.Nearby_Bean;
import lei.com.yulei.quarter.videodetails.videodetails_bean.VideoDetails_Bean;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public interface ServiceAPI {
    //轮播图
    @GET(API.ADVER)
    Observable<Adver_Bean>adver();
    //注册
    @GET(API.REG)
    Observable<Reg_Bean>reg(@QueryMap Map<String,String>map);
    //登录
    @GET(API.LOGIN)
    Observable<Login_Bean>login(@QueryMap Map<String,String>map);
    //获取段子
    @GET(API.JOKE)
    Observable<Anepisode_Bean>joke(@QueryMap Map<String,String>map);
    //发布段子
    @GET(API.ESSAY)
    Observable<Essay_bean>essay(@QueryMap Map<String,String>map);
    //发布视频
     @Multipart
    @POST(API.VIDEO)
    Observable<Postvideos_Bean>videos(@QueryMap Map<String,String>map,
                                      @Part MultipartBody.Part file,@Part MultipartBody.Part file2);
//附近视频
    @GET(API.NEARBY)
Observable<Nearby_Bean>nearby(@QueryMap Map<String,String>map);
    //作品详情
@GET(API.DETAILS)
    Observable<VideoDetails_Bean>details(@Query("wid")String wid);
    //个人作品中心
    @GET(API.CENTER)
    Observable<Center_Bean>center(@QueryMap Map<String,String>map);
    //获取推荐视频
    @GET(API.GETVIDEOS)
    Observable<SuggestedVideos_Bean>getvideos(@QueryMap Map<String,String>map);
}
