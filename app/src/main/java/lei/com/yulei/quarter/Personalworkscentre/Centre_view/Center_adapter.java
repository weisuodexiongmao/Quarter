package lei.com.yulei.quarter.Personalworkscentre.Centre_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import lei.com.yulei.quarter.Personalworkscentre.centre_bean.Center_Bean;
import lei.com.yulei.quarter.R;

/**
 * Created by 猥琐的熊猫 on 2018/1/29.
 */

public class Center_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Center_Bean bean;
    private Context context;

    public Center_adapter(Center_Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.center_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         VHitem vHitem= (VHitem) holder;
        final Center_Bean.DataBean.WorksEntitiesBean worksEntitiesBean = bean.getData().getWorksEntities().get(position);
        vHitem.textView.setText(bean.getData().getUser().getNickname());
        vHitem.textView2.setText(bean.getData().getWorksEntities().get(position).getCreateTime());
       vHitem.simpleDraweeView.setImageURI(bean.getData().getUser().getIcon());
        vHitem.simpleDraweeView2.setImageURI(bean.getData().getWorksEntities().get(position).getCover());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclicklisenter.onitemclick(worksEntitiesBean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bean.getData().getWorksEntities().size();
    }
    class VHitem extends RecyclerView.ViewHolder{

       SimpleDraweeView simpleDraweeView,simpleDraweeView2;
        TextView textView,textView2,textView3;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.center_sdv);
            simpleDraweeView2= (SimpleDraweeView) itemView.findViewById(R.id.center_s);
            textView= (TextView) itemView.findViewById(R.id.user_name);
            textView2= (TextView) itemView.findViewById(R.id.user_shijian);
            textView3= (TextView) itemView.findViewById(R.id.biaoti);
        }
    }
    public interface Onitemclicklisenter{
        void onitemclick(Center_Bean.DataBean.WorksEntitiesBean worksEntitiesBean);
    }
    private Onitemclicklisenter onitemclicklisenter;
    public void setOnitemclicklisenter(Onitemclicklisenter onitemclicklisenter){
        this.onitemclicklisenter=onitemclicklisenter;
    }
}
