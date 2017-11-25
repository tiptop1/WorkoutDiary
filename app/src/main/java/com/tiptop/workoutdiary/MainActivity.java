package com.tiptop.workoutdiary;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment fragment = null;
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_places:
//                        fragment = new PlacesFragment();
                        break;
                    case R.id.action_exercises:
//                        fragment = new ExcercisesFragment();
                        break;
                    case R.id.action_workouts:
//                        fragment = new WorkoutsFragment();
                        break;
                    case R.id.action_statistics:
//                        fragment = new StatisticsFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}
