package lei.com.yulei.quarter.creation.creation_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;

public class Creation_Activity extends AppCompatActivity {

    @BindView(R.id.imageView7)
    ImageView imageView7;
    @BindView(R.id.imageView9)
    ImageView imageView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imageView7, R.id.imageView9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView7:
      startActivity(new Intent(Creation_Activity.this,Postvideos_Activity.class));
                break;
            case R.id.imageView9:
            startActivity(new Intent(Creation_Activity.this,Writejokes_Activity.class));

                break;
        }
    }
}
