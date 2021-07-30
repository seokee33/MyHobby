package com.hobby.myhobby;

public class HotBoardItem {
    private String tv_hot_board_title;
    private String tv_hot_board_content;

    public HotBoardItem(String tv_hot_board_title, String tv_hot_board_content) {
        this.tv_hot_board_title = tv_hot_board_title;
        this.tv_hot_board_content = tv_hot_board_content;
    }

    public HotBoardItem() {}

    public String getTv_hot_board_title() {
        return tv_hot_board_title;
    }

    public void setTv_hot_board_title(String tv_hot_board_title) {
        this.tv_hot_board_title = tv_hot_board_title;
    }

    public String getTv_hot_board_content() {
        return tv_hot_board_content;
    }

    public void setTv_hot_board_content(String tv_hot_board_content) {
        this.tv_hot_board_content = tv_hot_board_content;
    }
}
