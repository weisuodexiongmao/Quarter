package lei.com.yulei.quarter.creation.creation_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.creation.creation_bean.Postvideos_Bean;
import lei.com.yulei.quarter.creation.creation_presneter.Postvideos_Presenter;
import lei.com.yulei.quarter.login.login_Bean.User;

public class Postvideos_Activity extends AppCompatActivity implements Postvideos_view{

    @BindView(R.id.buttonvideos)
    Button buttonvideos;
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postvideos_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.buttonvideos)
    public void onViewClicked() {
        Postvideos_Presenter presenter=new Postvideos_Presenter(this);
        presenter.presen();
    }

    @Override
    public void getvideos(Postvideos_Bean postvideos_bean) {
        Toast.makeText(this,postvideos_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String videos_uid() {
        return uid;
    }

    @Override
    public String videos_token() {
        return token;
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getuser(User user){
        token = user.getToken();
        uid = user.getUid();
    }
}
