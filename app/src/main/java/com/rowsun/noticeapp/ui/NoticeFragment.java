package com.rowsun.noticeapp.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.rowsun.noticeapp.R;
import com.rowsun.noticeapp.network.Service;
import com.rowsun.noticeapp.pojo.Notice;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends Fragment implements Service.GetNoticeCallback {

    RecyclerView rvNotice;
    ProgressBar progressBar;
    Service s;

    public NoticeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);
        rvNotice = v.findViewById(R.id.rv_notice);
        progressBar = v.findViewById(R.id.pbar);
        rvNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        s = new Service(getActivity());
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        s.getNotices(this);
    }

    @Override
    public void onSucess(List<Notice> list) {
        progressBar.setVisibility(View.GONE);
        if (list.size() == 0) {
            onError("No data available");
        } else {
            rvNotice.setAdapter(new AdapterNotice(getActivity(), list));
        }
    }

    @Override
    public void onError(String error) {
        Snackbar.make(progressBar, error, Snackbar.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
    }
}
