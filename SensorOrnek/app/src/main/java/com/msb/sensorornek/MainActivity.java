package com.msb.sensorornek;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private static final float ALPHA = 0.9f;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private TextView gercekIvmeTextView;
    private TextView lineerIvmeTextView;

    private float[] gravity = new float[3];
    private float[] linear_acceleration = new float[3];
    private Vibrator vibrator;
    private float last_x, last_y, last_z = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //gercekIvmeTextView = (TextView) findViewById(R.id.gercekIvmeTextView2);
       // lineerIvmeTextView = (TextView) findViewById(R.id.lineerIvmeTextView2);
    }

    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public final void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            if (z*last_z < 0) {
                vibrator.vibrate(2000);
            }


            last_x = x;
            last_y = y;
            last_z = z;
        }
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}

