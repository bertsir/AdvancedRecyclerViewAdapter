package cn.bertsir.rvadapterdeamo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt_lin;
    private Button bt_gri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        bt_lin = (Button) findViewById(R.id.bt_lin);
        bt_gri = (Button) findViewById(R.id.bt_gri);

        bt_lin.setOnClickListener(this);
        bt_gri.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_lin:
                startActivity(new Intent(getApplicationContext(),LinearActivity.class));
                break;
            case R.id.bt_gri:
                startActivity(new Intent(getApplicationContext(),GridActivity.class));
                break;
        }
    }
}
