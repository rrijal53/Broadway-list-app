package com.rowsun.noticeapp.network;


import com.rowsun.noticeapp.pojo.Notice;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("b.json")
    Call<List<Notice>> getNotices();

}
