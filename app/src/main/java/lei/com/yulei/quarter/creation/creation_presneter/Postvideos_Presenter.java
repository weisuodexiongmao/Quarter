package lei.com.yulei.quarter.creation.creation_presneter;

import lei.com.yulei.quarter.creation.creation_bean.Postvideos_Bean;
import lei.com.yulei.quarter.creation.creation_model.Postvideos_Model;
import lei.com.yulei.quarter.creation.creation_view.Postvideos_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/26.
 */

public class Postvideos_Presenter {
    private Postvideos_view view;
    private Postvideos_Model model;
    public Postvideos_Presenter(Postvideos_view view) {
        this.view = view;
        this.model=new Postvideos_Model();
    }
    public void presen(){
        model.getvideos(new Postvideos_Model.videos() {
            @Override
            public void getdata(Postvideos_Bean postvideos_bean) {
                view.getvideos(postvideos_bean);
            }
        },view.videos_uid(),view.videos_token());
    }
}
