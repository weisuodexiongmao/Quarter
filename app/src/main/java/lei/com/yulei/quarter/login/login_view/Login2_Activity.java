package lei.com.yulei.quarter.login.login_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.activity.MainActivity;
import lei.com.yulei.quarter.login.login_Bean.Login_Bean;
import lei.com.yulei.quarter.login.login_Bean.User;
import lei.com.yulei.quarter.login.login_presenter.Login_Presenter;
import lei.com.yulei.quarter.register.reg_view.reg_Acriviry;

public class Login2_Activity extends AppCompatActivity implements Login_view{

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textview7)
    TextView textview7;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textview8)
    TextView textview8;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_pass)
    EditText edPass;
    private String loginname;
    private String loginpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.login_back, R.id.textView6, R.id.textview7, R.id.textView5, R.id.textview8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back://返回
                finish();
                break;
            case R.id.textView6://登录
                loginname = edName.getText().toString();
                loginpass = edPass.getText().toString();
                Login_Presenter presenter=new Login_Presenter(this);
                presenter.presen();
               
                break;
            case R.id.textview7://注册
             startActivity(new Intent(Login2_Activity.this, reg_Acriviry.class));
                break;
            case R.id.textView5://游客
                startActivity(new Intent(Login2_Activity.this, MainActivity.class));
                finish();
                break;
            case R.id.textview8://忘记
                break;
        }
    }

    @Override
    public void getlogin(Login_Bean login_bean) {
        if (login_bean.getCode().equals("0")){
            Toast.makeText(this,login_bean.getMsg(),Toast.LENGTH_SHORT).show();
            EventBus.getDefault().postSticky(new User(login_bean.getData().getUid()+"",login_bean.getData().getToken()));
            startActivity(new Intent(this,MainActivity.class));
        }else {
            Toast.makeText(this,login_bean.getMsg(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public String login_name() {
        return loginname;
    }

    @Override
    public String login_pass() {
        return loginpass;
    }
}
