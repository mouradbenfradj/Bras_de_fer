package com.example.bras_de_fer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
	SensorManager sensorMgr;
	boolean accelSupported;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
 
   @SuppressWarnings("deprecation")
@Override
   protected void onStart(){
   	super.onStart();
   	sensorMgr = (SensorManager)getSystemService(SENSOR_SERVICE);
   	accelSupported =  sensorMgr.registerListener(this, sensorMgr.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_UI) ;
   	if(!accelSupported)
   	{
   		sensorMgr.unregisterListener(this,sensorMgr.getDefaultSensor(Sensor.TYPE_ORIENTATION));
   		
   	}
   }
   
   @SuppressWarnings("deprecation")
@Override
   
   protected void onStop(){
   	super.onStop();
   	sensorMgr.unregisterListener(this,sensorMgr.getDefaultSensor(Sensor.TYPE_ORIENTATION));
   
   }

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
	
}

@Override
public void onSensorChanged(SensorEvent event) {
	// TODO Auto-generated method stub
	float x,y,z;
	x = event.values[0];
	y = event.values[1];
	z = event.values[2];
	((TextView) findViewById(R.string.axex)).setText("Axe X:"+x+"m/s^2");
}

}

