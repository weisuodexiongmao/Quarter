package lei.com.yulei.quarter.register.reg_model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lei.com.yulei.quarter.register.reg_bean.Reg_Bean;
import lei.com.yulei.quarter.utils.RetrofitHelper;

/**
 * Created by 猥琐的熊猫 on 2018/1/23.
 */

public class Reg_Model {
    public void regmod(final getreg reg, String name, String pass){
        Map<String, String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        Observable<Reg_Bean> observable = RetrofitHelper.getAPI().reg(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Reg_Bean>() {
                    @Override
                    public void accept(Reg_Bean reg_bean) throws Exception {
                        reg.regdata(reg_bean);
                    }
                });
    }
    public interface getreg{
        void regdata(Reg_Bean reg_bean);
    }
}
