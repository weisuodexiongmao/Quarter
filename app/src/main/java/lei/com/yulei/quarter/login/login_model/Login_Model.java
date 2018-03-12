package lei.com.yulei.quarter.login.login_model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.login.login_Bean.Login_Bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public class Login_Model {
    public void getloginMod(final logindata daa, String name, String pass){
        Map<String, String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        Observable<Login_Bean> observable = RetrofitHelper.getAPI().login(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login_Bean>() {
                    @Override
                    public void accept(Login_Bean login_bean) throws Exception {
                        daa.getdata(login_bean);
                    }
                });
    }
    public interface logindata{
        void getdata(Login_Bean login_bean);
    }
}
