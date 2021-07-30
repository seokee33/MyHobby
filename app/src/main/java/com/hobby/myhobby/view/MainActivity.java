package com.hobby.myhobby.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hobby.myhobby.BackPressHandler;
import com.hobby.myhobby.R;
import com.hobby.myhobby.view.Menu_hobby;
import com.hobby.myhobby.view.Menu_home;
import com.hobby.myhobby.view.Menu_my;
import com.hobby.myhobby.view.Menu_other;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private BackPressHandler bp;

    private BottomNavigationView mBottomNavi;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Menu_hobby hobby;
    private Menu_home home;
    private Menu_my my;
    private Menu_other other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bp = new BackPressHandler(this);

        home = new Menu_home();
        hobby = new Menu_hobby();
        my = new Menu_my();
        other = new Menu_other();

        mBottomNavi = findViewById(R.id.bottom_navi);

        setFrag(0);

        mBottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        setFrag(0);
                        break;
                    case R.id.menu_hobby:
                        setFrag(1);
                        break;
                    case R.id.menu_my:
                        setFrag(2);
                        break;
                    case R.id.menu_other:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
    }

    private void setFrag(int i){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (i){
            case 0:
                ft.replace(R.id.main_fragment,home).commit();
                break;
            case 1:
                ft.replace(R.id.main_fragment,hobby).commit();
                break;
            case 2:
                ft.replace(R.id.main_fragment,my).commit();
                break;
            case 3:
                ft.replace(R.id.main_fragment,other).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        bp.onBackPressed(3000);
    }
}