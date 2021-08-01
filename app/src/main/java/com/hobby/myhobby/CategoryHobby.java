package com.hobby.myhobby;

import java.util.ArrayList;

public class CategoryHobby {

    private ArrayList<String> category;

    public CategoryHobby(){
        category = new ArrayList<>();
        category.add("독서/학습");
        category.add("수집/제작");
        category.add("여행");
        category.add("운동");
        category.add("음악");
        category.add("문화/레저");
        category.add("요리");
    }

    public int categorySize(){
        return category.size();
    }

    public int categoryNum(String category){
        switch (category){
            case "독서/학습":
                return 0;
            case "수집/제작":
                return 1;
            case "여행":
                return 2;
            case "운동":
                return 3;
            case "음악":
                return 4;
            case "문화/레저":
                return 5;
            case "요리":
                return 6;
        }

        return category.indexOf(category);
    }

    public ArrayList<String> getCategory() {
        return category;
    }
}
