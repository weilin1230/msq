package com.wkbp.msq.util;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wkbp.msq.base.CrashApplication;

import org.json.JSONObject;

/**
 * $desc 网络请求类
 * Created by shangshuaibo on 16/11/17.
 */
public class HttpUtils {
    //测试环境
    private static final String BASE_URL = "http://218.241.30.183:8080/buyService/service?";
    //线上环境
//private static final String BASE_URL = "http://218.241.30.183:8080/buyService/service?";
    public static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler
            responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void get(String url, RequestParams params, Context context,
                           AsyncHttpResponseHandler responseHandler) {
        PersistentCookieStore myPersistentCookieStore = new PersistentCookieStore(context);
        client.setCookieStore(myPersistentCookieStore);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * 暂时只调了post请求
     *
     * @author shangshuaibo
     * context 用于取消请求
     * creat at @time 16/11/17 17:27
     */
    public static void post(Context context, JSONObject obj, AsyncHttpResponseHandler
            responseHandler, RequestNetworkError networkError) {
        if (!NetWorkUtil.isNetworkConnected(CrashApplication.context)) {
            Toast.makeText(CrashApplication.context, "网络不给力", Toast.LENGTH_SHORT)
                    .show();
            networkError.networkError();
            return;
        } else {
            client.post(context, BASE_URL, getParams(obj), responseHandler);
        }
    }

    public interface RequestNetworkError {
        void networkError();
    }

    public static void post(String url, RequestParams params, Context context,
                            AsyncHttpResponseHandler responseHandler) {
        PersistentCookieStore myPersistentCookieStore = new PersistentCookieStore(context);
        client.setCookieStore(myPersistentCookieStore);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static RequestParams getParams(JSONObject obj) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("json", obj.toString());
        return requestParams;
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
