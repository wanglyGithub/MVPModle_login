package com.wangly.mvpmodle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wangly.mvpmodle.presenter.Presenter;
import com.wangly.mvpmodle.view.LoginView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    private EditText et_user;
    private EditText et_password;
    private Button bt_land;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);

        bt_land = (Button) findViewById(R.id.bt_land);
        bt_land.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_land:
                Presenter presenter = new Presenter();
                presenter.login(this);
                break;
            default:
                break;
        }
    }

    @Override
    public String getUserName() {
        return et_user.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
}

    @Override
    public void showToast(String toast) {
        Toast.makeText(MainActivity.this,toast,Toast.LENGTH_SHORT).show();

    }
}
