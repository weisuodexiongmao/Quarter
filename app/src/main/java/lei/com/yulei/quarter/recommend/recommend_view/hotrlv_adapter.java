package lei.com.yulei.quarter.recommend.recommend_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.recommend.recommend_bean.Adver_Bean;
import lei.com.yulei.quarter.recommend.recommend_bean.SuggestedVideos_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/22.
 */

public class hotrlv_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Adver_Bean.DataBean>adver1;
    private List<SuggestedVideos_Bean.DataBean> videos1;

    public hotrlv_adapter(Context context) {
        this.context = context;
    }

    public void getadver(Adver_Bean bean1){
        if (adver1==null){
            adver1=new ArrayList<>();
            List<Adver_Bean.DataBean> data = bean1.getData();
            for (Adver_Bean.DataBean ader:data){
                adver1.add(ader);
            }
            notifyDataSetChanged();
        }

    }
public void getvideos(SuggestedVideos_Bean bean2){
    if (videos1==null){
        videos1=new ArrayList<>();
        for (SuggestedVideos_Bean.DataBean aea:bean2.getData()){
            videos1.add(aea);
        }
        notifyDataSetChanged();
    }

}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (viewType==0){
           return new VHItem(LayoutInflater.from(context).inflate(R.layout.hot_rlvitem1,parent,false));
       }else {
           return new VHItem2(LayoutInflater.from(context).inflate(R.layout.ader_item2,parent,false));
       }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                    if (position==0){
                        VHItem vhItem= (VHItem) holder;

                        if (adver1 !=null){
                            List<String>list=new ArrayList<>();
                            for (Adver_Bean.DataBean image: adver1){
                                list.add(image.getIcon());
                            }
                            vhItem.banner.setImages(list);
                            vhItem.banner.setImageLoader(new GlideImageLoader());
                            vhItem.banner.setDelayTime(1000);
                            vhItem.banner.start();
                        }
                    }else {
                        if (videos1!=null) {
                            VHItem2 vhItem2= (VHItem2) holder;
                            vhItem2.simpleDraweeView.setImageURI(videos1.get(position).getUser().getIcon());
                            vhItem2.simpleDraweeView2.setImageURI(videos1.get(position).getCover());
                            vhItem2.textView.setText(videos1.get(position).getUser().getNickname()+"");
                            vhItem2.textView2.setText(videos1.get(position).getCreateTime());
                            vhItem2.textView3.setText(videos1.get(position).getWorkDesc()+"");
                        }


                    }

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return 11;
    }
class VHItem extends RecyclerView.ViewHolder{
     Banner banner;
    public VHItem(View itemView) {
        super(itemView);
        banner= (Banner) itemView.findViewById(R.id.banner);

    }
}
class VHItem2 extends RecyclerView.ViewHolder{
   SimpleDraweeView simpleDraweeView,simpleDraweeView2;
    TextView textView,textView2,textView3;
    public VHItem2(View itemView) {
        super(itemView);
        simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.ader_sdv2);
         simpleDraweeView2= (SimpleDraweeView) itemView.findViewById(R.id.ader_fm);
        textView= (TextView) itemView.findViewById(R.id.ader_name2);
         textView2= (TextView) itemView.findViewById(R.id.ader_riqi2);
        textView3= (TextView) itemView.findViewById(R.id.ader_bt);
    }
}
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load(path).into(imageView);

        }


        @Override
        public ImageView createImageView(Context context) {

            return null;
        }
    }
}
