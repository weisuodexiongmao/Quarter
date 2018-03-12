package lei.com.yulei.quarter.videodetails.videodetails_presenter;

import lei.com.yulei.quarter.videodetails.videodetails_bean.VideoDetails_Bean;
import lei.com.yulei.quarter.videodetails.videodetails_model.Videodetails_Model;
import lei.com.yulei.quarter.videodetails.videodetails_view.VideoDetails_View;

/**
 * Created by 猥琐的熊猫 on 2018/1/28.
 */

public class VideoDetails_Presenter {
    private VideoDetails_View view;
    private Videodetails_Model model;
    public VideoDetails_Presenter(VideoDetails_View view) {
        this.view = view;
        this.model=new Videodetails_Model();
    }
    public void presen(){
        model.getdetails(new Videodetails_Model.details() {
            @Override
            public void getdetails1(VideoDetails_Bean videoDetails_bean) {
                view.getdetailsdata(videoDetails_bean);
            }
        },view.wid());
    }
}
