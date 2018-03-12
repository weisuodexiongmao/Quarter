package lei.com.yulei.quarter.creation.creation_view;

import lei.com.yulei.quarter.creation.creation_bean.Postvideos_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/26.
 */

public interface Postvideos_view {
    void getvideos(Postvideos_Bean postvideos_bean);
    String videos_uid();
    String videos_token();
}
