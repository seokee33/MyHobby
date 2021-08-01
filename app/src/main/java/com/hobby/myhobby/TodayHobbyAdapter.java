package com.hobby.myhobby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TodayHobbyAdapter extends RecyclerView.Adapter<TodayHobbyAdapter.CustomViewHolder> {

    private ArrayList<TodayHobbyItem> todayHobbyItems;
    private Context context;

    public TodayHobbyAdapter(ArrayList<TodayHobbyItem> todayHobbyItems, Context context) {
        this.todayHobbyItems = todayHobbyItems;
        this.context = context;


    }

    @NonNull
    @NotNull
    @Override
    public TodayHobbyAdapter.CustomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_today_hobby,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TodayHobbyAdapter.CustomViewHolder holder, int position) {
        holder.iv_today_hobby.setImageResource(R.drawable.badminton);
        holder.tv_today_hobby_name.setText(todayHobbyItems.get(position).getTv_today_hobby());
    }

    @Override
    public int getItemCount() {
        return todayHobbyItems.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_today_hobby;
        TextView tv_today_hobby_name;

        public CustomViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            this.iv_today_hobby = itemView.findViewById(R.id.iv_today_hobby);
            this.tv_today_hobby_name = itemView.findViewById(R.id.tv_today_hobby_name);

        }
    }
}
