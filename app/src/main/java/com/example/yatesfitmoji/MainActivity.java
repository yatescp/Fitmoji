package com.example.yatesfitmoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    GraphView graph;

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


        graph = findViewById(R.id.weightGraph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 200),
                new DataPoint(2, 197),
                new DataPoint(3, 194),
                new DataPoint(4, 193),
                new DataPoint(5, 191)
        });
        graph.addSeries(series);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(210);
        graph.getViewport().setMinY(170);

        graph.setTitle("Weight Progress");
    }
}
