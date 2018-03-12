package lei.com.yulei.quarter.video.video_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.video.video_view.video_hot.Videohot_fragment;
import lei.com.yulei.quarter.video.video_view.video_nearby.Videonearby_fragment;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Video_Fragment extends Fragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.videoVP)
    ViewPager videoVP;
    Unbinder unbinder;
    private List<Fragment> list;
    private String[] str;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.video_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        getData();
        return view;

    }

    public void getData() {
        list = new ArrayList<>();
        list.add(new Videohot_fragment());
        list.add(new Videonearby_fragment());
        str = new String[]{"热门", "附近"};
        videoVP.setAdapter(new Vpfragpage(getChildFragmentManager()));
        tab.setupWithViewPager(videoVP);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    class Vpfragpage extends FragmentPagerAdapter {

        public Vpfragpage(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }
}
