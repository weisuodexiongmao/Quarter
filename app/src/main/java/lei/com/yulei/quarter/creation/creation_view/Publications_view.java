package lei.com.yulei.quarter.creation.creation_view;

import lei.com.yulei.quarter.creation.creation_bean.Essay_bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/25.
 */

public interface Publications_view {
    void getcontent(Essay_bean essay_bean);
    String essay_uid();
    String essay_token();
    String essay_content();
}
