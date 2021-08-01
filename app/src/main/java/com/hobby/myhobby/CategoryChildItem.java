package com.hobby.myhobby;

public class CategoryChildItem {
    private String iv_hobby_category_child;
    private String tv_hobby_category_child;
    private String category;

    public CategoryChildItem(){}

    public CategoryChildItem(String iv_hobby_category_child, String tv_hobby_category_child, String category) {
        this.iv_hobby_category_child = iv_hobby_category_child;
        this.tv_hobby_category_child = tv_hobby_category_child;
        this.category = category;
    }

    public CategoryChildItem(String category, String tv_hobby_category_child){
        this.category = category;
        this.tv_hobby_category_child = tv_hobby_category_child;
    }

    public CategoryChildItem(String category){
        this.category = category;
    }

    public String getIv_hobby_category_child() {
        return iv_hobby_category_child;
    }

    public void setIv_hobby_category_child(String iv_hobby_category_child) {
        this.iv_hobby_category_child = iv_hobby_category_child;
    }

    public String getTv_hobby_category_child() {
        return tv_hobby_category_child;
    }

    public void setTv_hobby_category_child(String tv_hobby_category_child) {
        this.tv_hobby_category_child = tv_hobby_category_child;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
