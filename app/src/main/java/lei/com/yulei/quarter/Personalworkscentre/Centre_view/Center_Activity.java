package lei.com.yulei.quarter.Personalworkscentre.Centre_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.Personalworkscentre.Centre_presenter.Center_Presenter;
import lei.com.yulei.quarter.Personalworkscentre.centre_bean.Center_Bean;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.login.login_Bean.User;
import lei.com.yulei.quarter.videodetails.videodetails_view.Videodetails_Activity;

public class Center_Activity extends AppCompatActivity implements Center_view {

    @BindView(R.id.imageView8)
    ImageView imageView8;
    @BindView(R.id.name_text)
    TextView nameText;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.imageView11)
    ImageView imageView11;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.imageView12)
    SimpleDraweeView imageView12;
    @BindView(R.id.center_Rlv)
    RecyclerView centerRlv;
    private String uid;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        Center_Presenter presenter = new Center_Presenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("token", token);
        map.put("appVersion","2");
        presenter.presen(map);
    }

    @OnClick({R.id.imageView8, R.id.imageView10, R.id.imageView11, R.id.imageView12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView8://返回
                break;
            case R.id.imageView10://分享
                break;
            case R.id.imageView11:
                break;
            case R.id.imageView12:
                break;
        }
    }

    @Override
    public void getcenter(Center_Bean center_bean) {
        nameText.setText(center_bean.getData().getUser().getNickname());
centerRlv.setLayoutManager(new LinearLayoutManager(this));
        Center_adapter center_adapter = new Center_adapter(center_bean, this);
        center_adapter.setOnitemclicklisenter(new Center_adapter.Onitemclicklisenter() {
            @Override
            public void onitemclick(Center_Bean.DataBean.WorksEntitiesBean worksEntitiesBean) {
                Intent intent = new Intent(Center_Activity.this, Videodetails_Activity.class);
                intent.putExtra("wid",worksEntitiesBean.getWid()+"");
                startActivity(intent);
            }
        });
        centerRlv.setAdapter(center_adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getUser(User user) {
        uid = user.getUid();
        token = user.getToken();
    }
}
