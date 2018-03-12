package lei.com.yulei.quarter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.anepisode.anepisode_view.Anepisode_Fragment;
import lei.com.yulei.quarter.creation.creation_view.Creation_Activity;
import lei.com.yulei.quarter.login.login_view.Login_Activity;
import lei.com.yulei.quarter.recommend.recommend_view.Recommend_Fragment;
import lei.com.yulei.quarter.video.video_view.Video_Fragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buddha)
    ImageView buddha;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.creation)
    ImageView creation;
    @BindView(R.id.recommend)
    ImageView recommend;
    @BindView(R.id.anepisode)
    ImageView anepisode;
    @BindView(R.id.video)
    ImageView video;
    @BindView(R.id.login)
    RelativeLayout login;
    @BindView(R.id.switch1)
    Switch switch1;
    private DrawerLayout drawerLayout;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        supportActionBar = getSupportActionBar();
        int name = getIntent().getIntExtra("name", 0);
        if (name==(1)){
            drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
            replace(new Anepisode_Fragment());
            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                }
            });

        }else {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
            replace(new Recommend_Fragment());
            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                }
            });
        }

    }

    @OnClick({R.id.buddha, R.id.creation, R.id.recommend, R.id.anepisode, R.id.video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buddha://头像
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.creation://添加
                startActivity(new Intent(MainActivity.this, Creation_Activity.class));
                break;
            case R.id.recommend:
                replace(new Recommend_Fragment());
                title.setText("推荐");
                break;
            case R.id.anepisode://段子
                  replace(new Anepisode_Fragment());
                title.setText("段子");
                break;
            case R.id.video:
                replace(new Video_Fragment());
                title.setText("视频");
                break;
        }
    }

    public void replace(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fra, f).commit();
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, Login_Activity.class));
    }








}
