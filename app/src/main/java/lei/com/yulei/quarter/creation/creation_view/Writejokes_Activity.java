package lei.com.yulei.quarter.creation.creation_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.activity.MainActivity;
import lei.com.yulei.quarter.creation.creation_bean.Essay_bean;
import lei.com.yulei.quarter.creation.creation_presneter.Publications_Presenter;
import lei.com.yulei.quarter.login.login_Bean.User;
import lei.com.yulei.quarter.login.login_view.Login2_Activity;

public class Writejokes_Activity extends AppCompatActivity implements Publications_view {

    @BindView(R.id.publish)
    TextView publish;
    @BindView(R.id.etContent)
    EditText etContent;
    private String uid;
    private String token;
    private String con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writejokes_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void getcontent(Essay_bean essay_bean) {
        Toast.makeText(this,essay_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String essay_uid() {
        return uid;
    }

    @Override
    public String essay_token() {
        return token;
    }

    @Override
    public String essay_content() {
        return con;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getuser(User user) {
        uid = user.getUid();
        token = user.getToken();
        Log.e("AAAA", uid);
    }

    @OnClick(R.id.publish)
    public void onViewClicked() {
        con = etContent.getText().toString();
        if (uid!=null){
            Publications_Presenter presenter=new Publications_Presenter(this);
            presenter.presen();
            Intent intent = new Intent(Writejokes_Activity.this, MainActivity.class);
            intent.putExtra("name",1);
            startActivity(intent);
        }else {
            Toast.makeText(Writejokes_Activity.this,"请先登录",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Writejokes_Activity.this, Login2_Activity.class));
        }

    }
}
