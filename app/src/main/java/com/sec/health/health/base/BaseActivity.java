package com.sec.health.health.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sec.health.health.R;


/**
 * Created by chenxiu on 2017/7/18.
 * Success is getting what you want
 * 爱生活，爱撸码，我为自己代言。
 */

public abstract class BaseActivity extends FragmentActivity {


    protected View mRootView;

    protected FrameLayout mContentView;

    protected Context mContext;

    protected TextView mTvTitle;

    protected ImageView mIvLeftIcon;

    protected ImageView mIvRightIconOne;

    protected ImageView mIvRightIconTow;

    private boolean isBack = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRootView = LayoutInflater.from(this).inflate(R.layout.activity_base,null);
        setContentView(mRootView);

        mContentView = (FrameLayout) findViewById(R.id.fl_base_content);
        mContentView.addView(LayoutInflater.from(this).inflate(initLayout(),null));
        mContext = this;

        mTvTitle = (TextView) findViewById(R.id.tv_base_title);

        mIvLeftIcon = (ImageView) findViewById(R.id.iv_base_title_left);

        if(!TextUtils.isEmpty(initTitle())){
            mTvTitle.setText(initTitle());
        }
        mIvRightIconOne = (ImageView) findViewById(R.id.iv_base_title_right);

        mIvRightIconTow = (ImageView) findViewById(R.id.iv_base_title_right2);

        mIvLeftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBack){
                    onBackPressed();
                }
            }
        });
        initData();
    }

    protected abstract String initTitle();


    public void setNoBack(){
        mIvLeftIcon.setVisibility(View.INVISIBLE);
        isBack = false;
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected abstract int initLayout();

    protected abstract void initData();
}
