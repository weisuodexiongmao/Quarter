package lei.com.yulei.quarter.video.video_view.video_hot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lei.com.yulei.quarter.R;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Videohot_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.videohot_fragment, null);
        return view;
    }
}
