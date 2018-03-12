package lei.com.yulei.quarter.anepisode.anepisode_presenter;

import lei.com.yulei.quarter.anepisode.anepisode_bean.Anepisode_Bean;
import lei.com.yulei.quarter.anepisode.anepisode_model.Anepisode_Model;
import lei.com.yulei.quarter.anepisode.anepisode_view.Anepisode_View;

/**
 * Created by 猥琐的熊猫 on 2018/1/24.
 */

public class Anepisode_presenter {
    private Anepisode_View view;
    private Anepisode_Model model;
    public Anepisode_presenter(Anepisode_View view) {
        this.view = view;
        this.model=new Anepisode_Model();
    }
    public void presen(){
        model.getmod(new Anepisode_Model.getanep() {
            @Override
            public void anep(Anepisode_Bean anepisode_bean) {
             view.getanepisode(anepisode_bean);
            }
        });
    }
}
