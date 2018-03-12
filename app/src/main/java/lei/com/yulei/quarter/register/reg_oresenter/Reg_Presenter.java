package lei.com.yulei.quarter.register.reg_oresenter;

import lei.com.yulei.quarter.register.reg_bean.Reg_Bean;
import lei.com.yulei.quarter.register.reg_model.Reg_Model;
import lei.com.yulei.quarter.register.reg_view.reg_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public class Reg_Presenter {
    private reg_view view;
    private Reg_Model model;
    public Reg_Presenter(reg_view view) {
        this.view = view;
        this.model=new Reg_Model();
    }
    public void pren(){
        model.regmod(new Reg_Model.getreg() {
            @Override
            public void regdata(Reg_Bean reg_bean) {
                view.reg(reg_bean);
            }
        },view.reg_name(),view.reg_pass());
    }
}
