package lei.com.yulei.quarter.login.login_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;

public class Login_Activity extends AppCompatActivity {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView4)
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.imageView3, R.id.imageView4, R.id.textView4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView3://weixin
                break;
            case R.id.imageView4://qq
                break;
            case R.id.textView4:
              startActivity(new Intent(Login_Activity.this,Login2_Activity.class));
                break;
        }
    }
}
