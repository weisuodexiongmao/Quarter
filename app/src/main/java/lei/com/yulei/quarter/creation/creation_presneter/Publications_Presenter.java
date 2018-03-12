package lei.com.yulei.quarter.creation.creation_presneter;

import lei.com.yulei.quarter.creation.creation_bean.Essay_bean;
import lei.com.yulei.quarter.creation.creation_model.Publications_Model;
import lei.com.yulei.quarter.creation.creation_view.Publications_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/25.
 */

public class Publications_Presenter {
    private Publications_view view;
    private Publications_Model model;
    public Publications_Presenter(Publications_view view) {
        this.view = view;
        this.model=new Publications_Model();
    }
    public void presen(){
        model.getcontent(new Publications_Model.getcon() {
            @Override
            public void getdata(Essay_bean essay_bean) {
                view.getcontent(essay_bean);
            }
        },view.essay_uid(),view.essay_content(),view.essay_token());
    }
}
