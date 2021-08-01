package com.hobby.myhobby;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HobbyCategoryExpandAdapter extends BaseExpandableListAdapter {
    public ArrayList<CategoryParentItem> parentItems;
    public ArrayList<ArrayList<CategoryChildItem>> childItems;


    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childItems.get(groupPosition).size();
    }

    @Override
    public CategoryParentItem getGroup(int groupPosition) {
        return parentItems.get(groupPosition);
    }

    @Override
    public CategoryChildItem getChild(int groupPosition, int childPosition) {
        return childItems.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;
        Context context = parent.getContext();

        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.hobby_category_parent_list,parent,false);
        }
        ImageView iv_expand_icon = (ImageView) v.findViewById(R.id.iv_expand_icon);
        TextView tv_hobby_category_header = (TextView) v.findViewById(R.id.tv_hobby_category_header);

        if(isExpanded)
            iv_expand_icon.setImageResource(R.drawable.expand_more);
        else
            iv_expand_icon.setImageResource(R.drawable.expand_less);
        tv_hobby_category_header.setText(getGroup(groupPosition).getTv_hobby_category_header());

        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;
        Context context = parent.getContext();

        if(v==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.hobby_category_child_list,parent,false);
        }

        ImageView iv_hobby_category_child = v.findViewById(R.id.iv_hobby_category_child);
        TextView tv_hobby_category_child = v.findViewById(R.id.tv_hobby_category_child);

        iv_hobby_category_child.setImageResource(R.drawable.activities);
        //iv_hobby_category_child.setImageResource(getChild(groupPosition,childPosition).getIv_hobby_category_child());
        tv_hobby_category_child.setText(getChild(groupPosition,childPosition).getTv_hobby_category_child());


        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void addItem(int groupPosition, CategoryChildItem item){
        childItems.get(groupPosition).add(item);
    }

    public void removeChild(int groupPosition, int childPosition){
        childItems.get(groupPosition).remove(childPosition);
    }

}
