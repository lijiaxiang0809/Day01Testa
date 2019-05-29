package com.example.day01tastb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private Context mContext;
    private List<Person> mList;

    public PersonAdapter(Context context, List<Person> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_person, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Person person = mList.get(i);
        viewHolder.mTvTitle.setText(person.getName());
        Glide.with(mContext).load(R.mipmap.ic_launcher).into(viewHolder.mImgLeft);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgLeft;
        TextView mTvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImgLeft = (ImageView) itemView.findViewById(R.id.img_left);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
