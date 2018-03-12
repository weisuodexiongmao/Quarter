package lei.com.yulei.quarter.anepisode.anepisode_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.anepisode.anepisode_bean.Anepisode_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/24.
 */

public class Anepisode_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private Context context;
    private Anepisode_Bean bean;

    public Anepisode_adapter(Context context, Anepisode_Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.layout,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         VHitem vHitem= (VHitem) holder;
        vHitem.textView1.setText(bean.getData().get(position).getUser().getNickname());
        vHitem.textView2.setText(bean.getData().get(position).getCreateTime());
        vHitem.textView3.setText(bean.getData().get(position).getContent());
        vHitem.simpleDraweeView.setImageURI(bean.getData().get(position).getUser().getIcon());
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    class VHitem extends RecyclerView.ViewHolder{
       TextView textView1,textView2,textView3;
        SimpleDraweeView simpleDraweeView;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView2);
            textView1= (TextView) itemView.findViewById(R.id.textView10);
            textView2= (TextView) itemView.findViewById(R.id.textView11);
            textView3= (TextView) itemView.findViewById(R.id.textView12);
        }
    }
}
