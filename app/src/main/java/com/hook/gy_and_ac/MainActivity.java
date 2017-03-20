package com.hook.gy_and_ac;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor accSensor;
    private Sensor gyroSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }
    public SensorEventListener accListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }

        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];



            Log.d("x acc","X : " + (int)x + " rad/s");
            Log.d("x acc","Y : " + (int)y + " rad/s");
            Log.d("x acc","Z : " + (int)z + " rad/s");
        }
    };

    public SensorEventListener gyroListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }

        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];


            Log.d("x gyro","X : " + (int)x + " rad/s");
            Log.d("x gyro","Y : " + (int)y + " rad/s");
            Log.d("x gyro","Z : " + (int)z + " rad/s");
        }
    };

    public void onResume() {
        super.onResume();
        sensorManager.registerListener(accListener, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(gyroListener, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(gyroListener);
        sensorManager.unregisterListener(accListener);
    }
}
