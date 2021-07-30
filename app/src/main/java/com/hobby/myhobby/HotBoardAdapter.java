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

public class HotBoardAdapter extends RecyclerView.Adapter<HotBoardAdapter.CustomViewHolder> {

    private ArrayList<HotBoardItem> hotBoardItems;
    private Context context;

    public HotBoardAdapter(ArrayList<HotBoardItem> hotBoardItems, Context context) {
        this.hotBoardItems = hotBoardItems;
        this.context = context;


    }

    @NonNull
    @NotNull
    @Override
    public HotBoardAdapter.CustomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hot_board,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HotBoardAdapter.CustomViewHolder holder, int position) {
        holder.tv_hot_board_title.setText(hotBoardItems.get(position).getTv_hot_board_title());
        holder.tv_hot_board_content.setText(hotBoardItems.get(position).getTv_hot_board_content());
    }

    @Override
    public int getItemCount() {
        return hotBoardItems.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_hot_board_title;
        TextView tv_hot_board_content;

        public CustomViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            this.tv_hot_board_title = itemView.findViewById(R.id.tv_hot_board_title);
            this.tv_hot_board_content = itemView.findViewById(R.id.tv_hot_board_content);

        }
    }
}
