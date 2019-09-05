package com.prajan.peertechz.retrofit;

import android.content.Context;

import com.prajan.peertechz.networkInterceptor.ConnectivityInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JANI SHAIK on 05/09/2019
 */

public class ApiClient {

    public static ApiInterface getApiClient(Context mContext, String url) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ConnectivityInterceptor(mContext))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

}
