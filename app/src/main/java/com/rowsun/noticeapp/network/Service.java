package com.rowsun.noticeapp.network;

import android.content.Context;

import com.rowsun.noticeapp.pojo.Notice;
import com.rowsun.noticeapp.utils.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service {

    private Context context;
    private ApiInterface apiInterface;

    public Service(Context context) {
        this.context = context;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getNotices(final GetNoticeCallback callback) {
        if (NetworkUtils.isNetworkConnected(context)){
            apiInterface.getNotices().enqueue(new Callback<List<Notice>>() {
                @Override
                public void onResponse(Call<List<Notice>> call, Response<List<Notice>> response) {
                    if (response.body()!=null){
                        callback.onSucess(response.body());
                    }else{
                        callback.onError("No data available");
                    }
                }

                @Override
                public void onFailure(Call<List<Notice>> call, Throwable t) {
                    callback.onError("Connection failed");
                    t.printStackTrace();
                }
            });
        }else{
            callback.onError("No internet connection.");
        }
    }

  public   interface GetNoticeCallback {
        void onSucess(List<Notice> list);
        void onError(String error);
    }
}
