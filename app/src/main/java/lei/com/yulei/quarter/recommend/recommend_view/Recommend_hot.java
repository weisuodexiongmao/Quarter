package lei.com.yulei.quarter.recommend.recommend_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.recommend.recommend_bean.Adver_Bean;
import lei.com.yulei.quarter.recommend.recommend_bean.SuggestedVideos_Bean;
import lei.com.yulei.quarter.recommend.recommend_presenter.Ader_Presenter;
import lei.com.yulei.quarter.recommend.recommend_presenter.SuggestedVideos_Presenter;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public class Recommend_hot extends Fragment implements Ader_view,SuggestedVideos_View{
    @BindView(R.id.hot_rlv)
    RecyclerView hotRlv;
    Unbinder unbinder;
    private List<Adver_Bean>adver1;
    private List<SuggestedVideos_Bean>videos1;
    private lei.com.yulei.quarter.recommend.recommend_view.hotrlv_adapter hotrlv_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hot_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        hotRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Ader_Presenter presenter=new Ader_Presenter(this);
        presenter.presen();
        SuggestedVideos_Presenter presenter1=new SuggestedVideos_Presenter(this);
        Map<String, String> map=new HashMap<>();
        map.put("type","1");
        map.put("page","1");
        map.put("source","android");
        map.put("appVersion","2");
        presenter1.presen(map);
        hotrlv_adapter = new hotrlv_adapter(getActivity());
        hotRlv.setAdapter(hotrlv_adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getAder(Adver_Bean adver) {
        hotrlv_adapter.getadver(adver);
    }

    @Override
    public void getvideos(SuggestedVideos_Bean suggestedVideos_bean) {
       hotrlv_adapter.getvideos(suggestedVideos_bean);
    }
}
