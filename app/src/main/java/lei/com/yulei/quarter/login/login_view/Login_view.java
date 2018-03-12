package lei.com.yulei.quarter.login.login_view;

import lei.com.yulei.quarter.login.login_Bean.Login_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public interface Login_view {
    void getlogin(Login_Bean login_bean);
    String login_name();
    String login_pass();
}
