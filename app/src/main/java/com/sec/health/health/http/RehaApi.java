package com.sec.health.health.http;

import android.text.TextUtils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by chenxiu on 2017/7/18.
 * Success is getting what you want
 * 爱生活，爱撸码，我为自己代言。
 */

public class RehaApi {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient mOkHttpClient;

    public RehaApi(){
        mOkHttpClient = new OkHttpClient();
    }

    public static RehaApi getInstance() {
        return new RehaApi();
    }





    /**
     * post请求
     *
     * @param url      接口地址
     * @param json     json数据
     * @param callback 回调
     */
    private void post(String url, String json, RehaCallback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(Constant.BASE_URL  +  url)
                .post(body)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * get请求
     *
     * @param url      接口地址
     * @param callback 回调
     */
    private void get(String url, RehaCallback callback) {
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(Constant.BASE_URL + url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * put 请求
     *
     * @param url      接口地址
     * @param json     json数据
     * @param callback 回调
     */
    private void put(String url, String json, RehaCallback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(Constant.BASE_URL  +  url)
                .put(body)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }
}
