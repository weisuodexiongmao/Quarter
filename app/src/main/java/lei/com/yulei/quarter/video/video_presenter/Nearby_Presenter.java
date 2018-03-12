package lei.com.yulei.quarter.video.video_presenter;

import lei.com.yulei.quarter.video.Video_bean.Nearby_Bean;
import lei.com.yulei.quarter.video.video_model.Videonearby_Model;
import lei.com.yulei.quarter.video.video_view.video_nearby.Videonearby_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Nearby_Presenter {
    private Videonearby_view view;
    private Videonearby_Model model;
    public Nearby_Presenter(Videonearby_view view) {
        this.view = view;
        this.model=new Videonearby_Model();
    }
    public void presen(){
        model.nearby(new Videonearby_Model.getnearby() {
            @Override
            public void getnearby2(Nearby_Bean nearby_bean) {
                view.nearbydata(nearby_bean);
            }
        },view.nearbypage(),view.nearbytoken());
    }
}
