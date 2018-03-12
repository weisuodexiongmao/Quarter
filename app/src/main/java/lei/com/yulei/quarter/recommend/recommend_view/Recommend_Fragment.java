package lei.com.yulei.quarter.recommend.recommend_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lei.com.yulei.quarter.R;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public class Recommend_Fragment extends Fragment {
    @BindView(R.id.hot)
    TextView hot;
    @BindView(R.id.attention)
    TextView attention;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
private List<Fragment>list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        list=new ArrayList<>();
        list.add(new Recommend_hot());
        list.add(new Recommend_Attention());
         vp.setAdapter(new fragvpadapter(getChildFragmentManager()));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.hot, R.id.attention})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hot:
                vp.setCurrentItem(0);
                break;
            case R.id.attention:
                vp.setCurrentItem(1);
                break;
        }
    }
    class fragvpadapter extends FragmentPagerAdapter{

        public fragvpadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
