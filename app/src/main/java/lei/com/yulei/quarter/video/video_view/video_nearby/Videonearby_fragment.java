package lei.com.yulei.quarter.video.video_view.video_nearby;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.login.login_Bean.User;
import lei.com.yulei.quarter.video.Video_bean.Nearby_Bean;
import lei.com.yulei.quarter.video.video_presenter.Nearby_Presenter;
import lei.com.yulei.quarter.videodetails.videodetails_view.Videodetails_Activity;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Videonearby_fragment extends Fragment implements Videonearby_view {
    @BindView(R.id.nearbyRlv)
    RecyclerView nearbyRlv;
    Unbinder unbinder;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.videonearby_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        nearbyRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        EventBus.getDefault().register(this);
        Nearby_Presenter presenter=new Nearby_Presenter(this);
        presenter.presen();
        return view;
    }

    @Override
    public void nearbydata(Nearby_Bean nearby_bean) {
        Nearby_adapter nearby_adapter = new Nearby_adapter(getActivity(), nearby_bean);
        nearbyRlv.setAdapter(nearby_adapter);
        nearby_adapter.setOnitemclicklisenter(new Nearby_adapter.Onitemclicklisenter() {
            @Override
            public void onitemclick(Nearby_Bean.DataBean dataBean) {
                int wid = dataBean.getWid();
                Intent intent = new Intent(getActivity(), Videodetails_Activity.class);
                intent.putExtra("wid",wid+"");
                intent.putExtra("image",dataBean.getUser().getIcon());
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public String nearbypage() {
        return "1";
    }

    @Override
    public String nearbytoken() {
        return token;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getuser(User user){
        token = user.getToken();
    }
}
