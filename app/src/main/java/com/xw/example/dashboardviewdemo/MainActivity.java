package com.xw.example.dashboardviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        show();
    }

    private void show() {
        int startAngle = 150;
        int sweepAngle = 240;
        int maxValue = 120;
        int realValue = 72;
        String unit = "km/h";

        DashboardView dashboardView = (DashboardView) findViewById(R.id.dashboard_view);
        dashboardView.setRadius(110);
        dashboardView.setArcColor(getResources().getColor(android.R.color.black));
        dashboardView.setTextColor(getResources().getColor(android.R.color.black));
        dashboardView.setPointerColor(getResources().getColor(android.R.color.holo_red_light));
        dashboardView.setBgColor(getResources().getColor(android.R.color.holo_blue_dark));
        dashboardView.setStartAngle(startAngle);
        dashboardView.setPointerRadius(80);
        dashboardView.setCircleRadius(8);
        dashboardView.setSweepAngle(sweepAngle);
        dashboardView.setBigSliceCount(12);
        dashboardView.setMaxValue(maxValue);
        dashboardView.setMeasureTextSize(14);
        dashboardView.setHeaderRadius(-40);
        dashboardView.setHeaderTitle(unit);
        dashboardView.setHeaderTextSize(16);
        dashboardView.setStripeWidth(10);
        dashboardView.setRealTimeValue(realValue);
        dashboardView.setStripeMode(DashboardView.StripeMode.OUTER);
        List<HighlightCR> highlight3 = new ArrayList<>();

        int realAngle = realValue * sweepAngle / maxValue;
        highlight3.add(new HighlightCR((startAngle+sweepAngle) % 360, startAngle, Color.parseColor("#FFFFFF")));
        highlight3.add(new HighlightCR(startAngle, realAngle, Color.parseColor("#4CAF50")));
        highlight3.add(new HighlightCR(startAngle + realAngle, sweepAngle - realAngle, Color.parseColor("#FFFFFF")));
        dashboardView.setStripeHighlightColorAndRange(highlight3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
