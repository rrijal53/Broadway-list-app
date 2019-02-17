package com.rowsun.noticeapp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rowsun.noticeapp.R;
import com.rowsun.noticeapp.pojo.Notice;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterNotice extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Notice> list;

    public AdapterNotice(Context context, List<Notice> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_notice, viewGroup, false);
        return new ViewHolderNotice(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderNotice){
            ((ViewHolderNotice) holder).tvTitle.setText(list.get(position).getNotice());
            ((ViewHolderNotice) holder).tvDate.setText(list.get(position).getDate());
                    Picasso.get().load("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .into(((ViewHolderNotice) holder).image);

            }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderNotice extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate;
        ImageView image;

        public ViewHolderNotice(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            image = itemView.findViewById(R.id.image);
        }
    }


}
