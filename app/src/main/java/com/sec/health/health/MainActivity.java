package com.sec.health.health;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sec.health.health.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEtUserName;

    private TextView mBtnLogin;

    private EditText mEtPassWord;

    @Override
    protected String initTitle() {
        return "登录";
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mEtPassWord = (EditText) findViewById(R.id.user_password);

        mEtUserName = (EditText) findViewById(R.id.user_name);

        mBtnLogin = (TextView) findViewById(R.id.login_btn);

        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
