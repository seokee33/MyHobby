package com.hobby.myhobby.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hobby.myhobby.HotBoardAdapter;
import com.hobby.myhobby.HotBoardItem;
import com.hobby.myhobby.R;
import com.hobby.myhobby.TodayHobbyAdapter;
import com.hobby.myhobby.TodayHobbyItem;
import com.hobby.myhobby.databinding.FragHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Menu_home extends Fragment {

    private View v;

    private RecyclerView rv_today_hobby;
    private RecyclerView.Adapter adapter_today_hobby;
    private ArrayList<TodayHobbyItem> todayHobbyItems;
    private RecyclerView.LayoutManager layoutManager_today_hobby;

    private RecyclerView rv_hot_board;
    private RecyclerView.Adapter adapter_hot_board;
    private ArrayList<HotBoardItem> hotBoardItems;
    private RecyclerView.LayoutManager layoutManager_hot_board;


    public static Menu_home newInstance() {
        Menu_home Menu_home = new Menu_home();
        return Menu_home;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_home,container,false);

        // 오늘의 취미
        rv_today_hobby  = v.findViewById(R.id.rv_today_hobby);
        rv_today_hobby.setHasFixedSize(true);
        layoutManager_today_hobby = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);

        rv_today_hobby.setLayoutManager(layoutManager_today_hobby);

        todayHobbyItems = new ArrayList<>();

        //임시 데이터 추가
        todayHobbyItems.add(new TodayHobbyItem("축구"));
        todayHobbyItems.add(new TodayHobbyItem("야구"));

        adapter_today_hobby = new TodayHobbyAdapter(todayHobbyItems,getContext());
        rv_today_hobby.setAdapter(adapter_today_hobby);




        // 핫게
        rv_hot_board  = v.findViewById(R.id.rv_hot_board);
        rv_hot_board.setHasFixedSize(true);
        layoutManager_hot_board = new LinearLayoutManager(getContext());

        rv_hot_board.setLayoutManager(layoutManager_hot_board);

        hotBoardItems = new ArrayList<>();

        //임시 데이터 추가
        hotBoardItems.add(new HotBoardItem("야구 잘하는 법","야구는 ...."));
        hotBoardItems.add(new HotBoardItem("축구 잘하는 법","공격수는 후방으로부터 패스를 많이 받게 됩니다. 하지만 상대진영에 위치하기 때문에 곧이어 압박이 들어오죠."));

        adapter_hot_board = new HotBoardAdapter(hotBoardItems,getContext());
        rv_hot_board.setAdapter(adapter_hot_board);


        return v;
    }
}
