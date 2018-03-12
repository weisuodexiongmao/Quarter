package lei.com.yulei.quarter.register.reg_view;

import lei.com.yulei.quarter.register.reg_bean.Reg_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public interface reg_view {
    void reg(Reg_Bean reg_bean);
    String reg_name();
    String reg_pass();
}
