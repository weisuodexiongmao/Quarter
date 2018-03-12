package lei.com.yulei.quarter.Personalworkscentre.Centre_presenter;

import java.util.Map;

import lei.com.yulei.quarter.Personalworkscentre.Centre_view.Center_view;
import lei.com.yulei.quarter.Personalworkscentre.centre_bean.Center_Bean;
import lei.com.yulei.quarter.Personalworkscentre.centre_model.Contre_Model;

/**
 * Created by 猥琐的熊猫 on 2018/1/29.
 */

public class Center_Presenter {
    private Center_view view;
    private Contre_Model model;
    public Center_Presenter(Center_view view) {
        this.view = view;
        this.model=new Contre_Model();
    }
    public void presen(Map<String,String>map){
        model.contremodel(new Contre_Model.getmodel() {
            @Override
            public void getcontremodel(Center_Bean center_bean) {
                view.getcenter(center_bean);
            }
        }, map);
    }
}
