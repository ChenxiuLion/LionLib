package com.sec.health.health.http;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by chenxiu on 2017/7/18.
 * Success is getting what you want
 * 爱生活，爱撸码，我为自己代言。
 */

public abstract class RehaCallback implements Callback {

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onErro(call.toString());
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String json = response.body().string();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onSucceed(json);
            }
        });
    }

    protected abstract void onSucceed(String json);

    protected abstract void onErro(String erro);
}
