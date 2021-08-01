package com.hobby.myhobby;

public class CategoryParentItem {
    private String tv_hobby_category_header;
    private String iv_expand_icon;

    public CategoryParentItem() {}

    public CategoryParentItem(String tv_hobby_category_header) {
        this.tv_hobby_category_header = tv_hobby_category_header;
    }

    public String getTv_hobby_category_header() {
        return tv_hobby_category_header;
    }


    public void setTv_hobby_category_header(String tv_hobby_category_header) {
        this.tv_hobby_category_header = tv_hobby_category_header;
    }

    public String getIv_expand_icon() {
        return iv_expand_icon;
    }

    public void setIv_expand_icon(String iv_expand_icon) {
        this.iv_expand_icon = iv_expand_icon;
    }
}
