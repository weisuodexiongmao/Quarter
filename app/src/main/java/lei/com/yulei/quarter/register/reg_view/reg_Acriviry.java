package lei.com.yulei.quarter.register.reg_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lei.com.yulei.quarter.R;
import lei.com.yulei.quarter.register.reg_bean.Reg_Bean;
import lei.com.yulei.quarter.register.reg_oresenter.Reg_Presenter;

public class reg_Acriviry extends AppCompatActivity implements reg_view{

    @BindView(R.id.reg_name)
    EditText regName;
    @BindView(R.id.reg_pass)
    EditText regPass;
    @BindView(R.id.textView8)
    TextView textView8;
    private String regname;
    private String regpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_acriviry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.textView8)
    public void onViewClicked() {
        regname = regName.getText().toString();
        regpass = regPass.getText().toString();
        Reg_Presenter presenter=new Reg_Presenter(this);
        presenter.pren();
        finish();
    }

    @Override
    public void reg(Reg_Bean reg_bean) {
        Toast.makeText(this,reg_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String reg_name() {
        return regname;
    }

    @Override
    public String reg_pass() {
        return regpass;
    }
}
