package lei.com.yulei.quarter.videodetails.videodetails_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import lei.com.yulei.quarter.Personalworkscentre.Centre_view.Center_Activity;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.videodetails.videodetails_bean.VideoDetails_Bean;
import lei.com.yulei.quarter.videodetails.videodetails_presenter.VideoDetails_Presenter;

public class Videodetails_Activity extends AppCompatActivity implements VideoDetails_View {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.like)
    ImageView like;
    @BindView(R.id.dislike)
    ImageView dislike;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.Theuserworksimage)
    SimpleDraweeView Theuserworksimage;
    @BindView(R.id.Videotitle)
    TextView Videotitle;
    private String wid;
    private String image;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videodetails_activity);
        ButterKnife.bind(this);
        wid = getIntent().getStringExtra("wid");
        image = getIntent().getStringExtra("image");
        Theuserworksimage.setImageURI(image);
        VideoDetails_Presenter presenter = new VideoDetails_Presenter(this);
        presenter.presen();
    }

    @Override
    public void getdetailsdata(VideoDetails_Bean videoDetails_bean) {
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        //设置视频上显示的文字
        jcVideoPlayerStandard.setUp(videoDetails_bean.getData().getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"盖世英雄");


    }

    @Override
    public String wid() {
        return wid;
    }


    @OnClick({R.id.back, R.id.like, R.id.dislike, R.id.share, R.id.Theuserworksimage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back://返回
                break;
            case R.id.like://喜欢
                break;
            case R.id.dislike://不喜欢
                break;
            case R.id.share://分享
                break;
            case R.id.Theuserworksimage://个人中心
                startActivity(new Intent(Videodetails_Activity.this, Center_Activity.class));
                break;
        }
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
