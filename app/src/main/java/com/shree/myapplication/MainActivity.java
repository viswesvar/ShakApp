package com.shree.myapplication;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {

    private TextView viewCount;
    private TextView viewAxis;
    private int shakes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewCount = (TextView) findViewById(R.id.label_shakes);
        viewAxis = (TextView) findViewById(R.id.label_axis);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

    }

    @Override
    public void hearShake() {
        Toast.makeText(this, "Yes you are", Toast.LENGTH_SHORT).show();
        shakes++;
        viewCount.setText("" + shakes);
    }

    @Override
    public void onAxisChanged(float axis) {
        viewAxis.setText("" + axis);
    }
}
