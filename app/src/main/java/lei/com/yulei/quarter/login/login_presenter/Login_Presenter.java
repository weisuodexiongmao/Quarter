package lei.com.yulei.quarter.login.login_presenter;

import lei.com.yulei.quarter.login.login_Bean.Login_Bean;
import lei.com.yulei.quarter.login.login_model.Login_Model;
import lei.com.yulei.quarter.login.login_view.Login_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public class Login_Presenter {
    private Login_view view;
    private Login_Model model;
    public Login_Presenter(Login_view view) {
        this.view = view;
        this.model=new Login_Model();
    }
    public void presen(){
        model.getloginMod(new Login_Model.logindata() {
            @Override
            public void getdata(Login_Bean login_bean) {
                view.getlogin(login_bean);
            }
        },view.login_name(),view.login_pass());
    }
}
