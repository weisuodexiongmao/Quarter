package lei.com.yulei.quarter.recommend.recommend_presenter;

import lei.com.yulei.quarter.recommend.recommend_bean.Adver_Bean;
import lei.com.yulei.quarter.recommend.recommend_model.Ader_model;
import lei.com.yulei.quarter.recommend.recommend_view.Ader_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public class Ader_Presenter {
    private Ader_view view;
    private Ader_model model;
    public Ader_Presenter(Ader_view view) {
        this.view = view;
        this.model=new Ader_model();
    }
    public void presen(){
        model.getader(new Ader_model.ader() {
            @Override
            public void aderdata(Adver_Bean adver) {
                view.getAder(adver);
            }
        });
    }
}
