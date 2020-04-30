package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    GraphView weightGraph;
    GraphView pushupGraph;
    GraphView crunchesGraph;
    GraphView plankGraph;

    int maxWeight, minWeight, maxPushup, minPushup, maxCrunch, minCrunch, maxPlank, minPlank;

    private User mUser;

    private FitmojiViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(FitmojiViewModel.class);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        String name = sharedPreferences.getString("userName", "default");

        //create default user, this is for testing purposes
        //mUser = new User("default", 200.0f, 180.0f, "Lose Weight");

        //model.insertUser(mUser);


        //pull these values from the database
        maxWeight = 210; //starting weight from database/user preferences
        minWeight = 170; //goal weight from database/user preferences
        maxPushup = 50; //based on intensity level from user preferences
        minPushup = 0;
        maxCrunch = 50; //based on intensity level from user preferences
        minCrunch = 0;
        maxPlank = 120; //based on intensity level from user preferences
        minPlank = 0;



        weightGraph = findViewById(R.id.weightGraph);
        pushupGraph = findViewById(R.id.PushupsGraph);
        crunchesGraph = findViewById(R.id.cruchesGraph);
        plankGraph = findViewById(R.id.PlankTimeGraph);

        //Each DataPoint is a day, x is day from start, y is weight on that day
        LineGraphSeries<DataPoint> weightSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 200),
                new DataPoint(2, 197),
                new DataPoint(3, 194),
                new DataPoint(4, 193),
                new DataPoint(5, 191)
        });
        weightGraph.addSeries(weightSeries);
        weightGraph.getViewport().setYAxisBoundsManual(true);
        weightGraph.getViewport().setMaxY(maxWeight);
        weightGraph.getViewport().setMinY(minWeight);
        weightGraph.setTitle("Weight Progress");


        LineGraphSeries<DataPoint> pushupSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 15),
                new DataPoint(2, 16),
                new DataPoint(3, 18),
                new DataPoint(4, 20),
                new DataPoint(5, 21)
        });
        pushupGraph.addSeries(pushupSeries);
        pushupGraph.getViewport().setYAxisBoundsManual(true);
        pushupGraph.getViewport().setMaxY(maxPushup);
        pushupGraph.getViewport().setMinY(minPushup);
        pushupGraph.setTitle("Daily Push Up Progress");

        LineGraphSeries<DataPoint> crunchSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 25),
                new DataPoint(2, 28),
                new DataPoint(3, 30),
                new DataPoint(4, 32),
                new DataPoint(5, 33)
        });
        crunchesGraph.addSeries(crunchSeries);
        crunchesGraph.getViewport().setYAxisBoundsManual(true);
        crunchesGraph.getViewport().setMaxY(maxCrunch);
        crunchesGraph.getViewport().setMinY(minCrunch);
        crunchesGraph.setTitle("Daily Crunches Progress");

        LineGraphSeries<DataPoint> plankSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 30),
                new DataPoint(2, 36),
                new DataPoint(3, 38),
                new DataPoint(4, 43),
                new DataPoint(5, 47)
        });
        plankGraph.addSeries(plankSeries);
        plankGraph.getViewport().setYAxisBoundsManual(true);
        plankGraph.getViewport().setMaxY(maxPlank);
        plankGraph.getViewport().setMinY(minPlank);
        plankGraph.setTitle("Daily Plank Time Progress");
    }
}
