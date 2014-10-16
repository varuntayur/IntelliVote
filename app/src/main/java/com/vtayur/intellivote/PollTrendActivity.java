package com.vtayur.intellivote;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;

/**
 * Created by vtayur on 10/15/2014.
 */
public class PollTrendActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_trend);
//        linearChart = (LinearLayout) findViewById(R.id.linearChart);
//        drawChart(5);
        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[]{
                new GraphView.GraphViewData(1d, 2200d)
                , new GraphView.GraphViewData(2d, 800d)
                , new GraphView.GraphViewData(3d, 500d)
                , new GraphView.GraphViewData(4d, 700d)
        });

        GraphView graphView = new BarGraphView(
                this // context
                , "Now Trending" // heading
        );
        graphView.addSeries(exampleSeries); // data
        graphView.setHorizontalLabels(new String[]{"A:New Delhi", "B:Mumbai", "C:Kolkata", "D:Chennai"});
        graphView.setVerticalLabels(new String[]{"100k", "50k", "10k"});

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearChart);
        layout.addView(graphView);

        Button btn = (Button) findViewById(R.id.buttonReturnToHome);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
