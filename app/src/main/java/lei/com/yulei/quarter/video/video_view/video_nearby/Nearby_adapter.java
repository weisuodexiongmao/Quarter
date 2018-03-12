package lei.com.yulei.quarter.video.video_view.video_nearby;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.video.Video_bean.Nearby_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/27.
 */

public class Nearby_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private Nearby_Bean bean;

    public Nearby_adapter(Context context, Nearby_Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.nearby_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (bean!=null) {
            VHitem vHitem= (VHitem) holder;
            final Nearby_Bean.DataBean dataBean = bean.getData().get(position);
            vHitem.textView.setText(bean.getData().get(position).getUser().getNickname());
            vHitem.simpleDraweeView.setImageURI(bean.getData().get(position).getCover());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemclicklisenter.onitemclick(dataBean);
                }
            });
        } else {
        }
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    class VHitem extends RecyclerView.ViewHolder{
         TextView textView;
        SimpleDraweeView simpleDraweeView;
        public VHitem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.nearby_nametext);
             simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.nearby_adv);
        }
    }
    public interface Onitemclicklisenter{
        void onitemclick(Nearby_Bean.DataBean dataBean);
    }
    private Onitemclicklisenter onitemclicklisenter;
    public void setOnitemclicklisenter(Onitemclicklisenter onitemclicklisenter){
        this.onitemclicklisenter=onitemclicklisenter;
    }
}
