package lei.com.yulei.quarter.recommend.recommend_presenter;

import java.util.Map;

import lei.com.yulei.quarter.recommend.recommend_bean.SuggestedVideos_Bean;
import lei.com.yulei.quarter.recommend.recommend_model.SuggestedVideos_Model;
import lei.com.yulei.quarter.recommend.recommend_view.SuggestedVideos_View;

/**
 * Created by 猥琐的熊猫 on 2018/1/29.
 */

public class SuggestedVideos_Presenter {
    private SuggestedVideos_View view;
    private SuggestedVideos_Model model;

    public SuggestedVideos_Presenter(SuggestedVideos_View view) {
        this.view = view;
        this.model=new SuggestedVideos_Model();
    }

    public void presen(Map<String,String>map){
        model.getvideos(new SuggestedVideos_Model.getSuggestedVideos() {
            @Override
            public void getdata1(SuggestedVideos_Bean suggestedVideos_bean) {
             view.getvideos(suggestedVideos_bean);
            }
        },map);
    }
}
