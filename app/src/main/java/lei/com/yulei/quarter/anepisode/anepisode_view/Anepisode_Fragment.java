package lei.com.yulei.quarter.anepisode.anepisode_view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.anepisode.anepisode_bean.Anepisode_Bean;
import lei.com.yulei.quarter.anepisode.anepisode_presenter.Anepisode_presenter;

/**
 * Created by 猥琐的熊猫 on 2018/1/24.
 */

public class Anepisode_Fragment extends Fragment implements Anepisode_View {
    @BindView(R.id.anep_Rlv)
    RecyclerView anepRlv;
    Unbinder unbinder;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    private Anepisode_presenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.anepisode_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        anepRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      presenter.presen();
                        srl.setRefreshing(false);
                    }
                }, 1200);
            }
        });
        presenter = new Anepisode_presenter(this);
        presenter.presen();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getanepisode(Anepisode_Bean anepisode_bean) {
        anepRlv.setAdapter(new Anepisode_adapter(getActivity(), anepisode_bean));
    }


}
