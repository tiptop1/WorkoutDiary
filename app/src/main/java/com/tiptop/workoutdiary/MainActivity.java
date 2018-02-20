package com.tiptop.workoutdiary;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.tiptop.workoutdiary.db.WorkoutDiaryDb;
import com.tiptop.workoutdiary.db.dao.PlacesDao;
import com.tiptop.workoutdiary.db.entity.Place;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment fragment;
    private static WorkoutDiaryDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (db == null) {
            db = Room.databaseBuilder(getApplicationContext(), WorkoutDiaryDb.class,
                    "WorkoutDiary").build();
            populateDbWithTestData(db);
        }
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_places:
                        fragment = new PlacesFragment();
                        break;
                    case R.id.action_exercises:
                        fragment = new ExercisesFragment();
                        break;
                    case R.id.action_workouts:
                        fragment = new WorkoutsFragment();
                        break;
                    case R.id.action_statistics:
                        fragment = new StatisticsFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
        bottomNavigation.setSelectedItemId(R.id.action_places);
    }

    private void populateDbWithTestData(final WorkoutDiaryDb db) {
        AsyncTask<WorkoutDiaryDb, Void, Void> task = new AsyncTask<WorkoutDiaryDb, Void, Void>() {
            @Override
            protected Void doInBackground(WorkoutDiaryDb... dbs) {
                // #TODO - For test purpose - add some database content
                WorkoutDiaryDb db = dbs[0];
                PlacesDao placesDao = db.placesDao();

                Place place = new Place();
                place.name = "Gym";
                place.description = "My favorite gym";
                placesDao.addPlace(place);

                place = new Place();
                place.name = "Wellnes";
                place.description = "Not my favorite club";
                placesDao.addPlace(place);

                place = new Place();
                place.name = "Home";
                place.description = "Sweet home";
                placesDao.addPlace(place);
                return null;
            }
        };
        task.execute(db);
    }

}
