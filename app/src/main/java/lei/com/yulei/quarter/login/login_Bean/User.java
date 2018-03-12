package lei.com.yulei.quarter.login.login_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/24.
 */

public class User {
    private String uid;
    private String token;

    public User(String uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
