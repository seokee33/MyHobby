package com.hobby.myhobby.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hobby.myhobby.CategoryChildItem;
import com.hobby.myhobby.CategoryHobby;
import com.hobby.myhobby.CategoryParentItem;
import com.hobby.myhobby.HobbyCategoryExpandAdapter;
import com.hobby.myhobby.R;
import com.hobby.myhobby.databinding.FragHobbyBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Menu_hobby extends Fragment {

    private View v;
    private CategoryHobby categoryHobby;

    ExpandableListView listView;
    HobbyCategoryExpandAdapter adapter;
    ArrayList<CategoryParentItem> groupList;
    ArrayList<ArrayList<CategoryChildItem>> childList;
    ArrayList<ArrayList<CategoryChildItem>> categoryArray;
    ArrayList<CategoryChildItem> exCategory;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_hobby,container,false);

        listView = (ExpandableListView)v.findViewById(R.id.expandable_category);

        categoryHobby = new CategoryHobby();
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        categoryArray = new ArrayList<>();

        exCategory = new ArrayList<>();

        for(int i = 0; i<categoryHobby.categorySize();i++)
            categoryArray.add(new ArrayList<CategoryChildItem>());


        adapter = new HobbyCategoryExpandAdapter();
        adapter.parentItems = groupList;
        adapter.childItems = childList;

        listView.setAdapter(adapter);
        listView.setGroupIndicator(null);

        setListItems();

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getContext(),adapter.getChild(groupPosition,childPosition).getTv_hobby_category_child(),Toast.LENGTH_SHORT).show();

                return true;
            }
        });


        return v;
    }

    public void setListItems(){
        groupList.clear();
        childList.clear();

        exCategory.add(new CategoryChildItem("문화/레저","영화"));
        exCategory.add(new CategoryChildItem("요리","양식"));
        exCategory.add(new CategoryChildItem("여행","국내"));
        exCategory.add(new CategoryChildItem("수집/제작","동전모으기"));
        exCategory.add(new CategoryChildItem("독서/학습","공포"));
        exCategory.add(new CategoryChildItem("음악","K-POP"));
        exCategory.add(new CategoryChildItem("운동","야구"));


        for(int i = 0;i<exCategory.size();i++){
            //Log.v("categoryNum",exCategory.get(i).getCategory()+" : "+ categoryHobby.categoryNum(exCategory.get(i).getCategory()));
            categoryArray.get(categoryHobby.categoryNum(exCategory.get(i).getCategory())).add(exCategory.get(i));
        }
        childList.addAll(categoryArray);
        for(int i = 0; i<categoryHobby.categorySize();i++){
            groupList.add(new CategoryParentItem(categoryHobby.getCategory().get(i)));
        }
        adapter.notifyDataSetChanged();

    }
}