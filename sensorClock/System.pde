//-----------------------------------------------------------------------------------------
// HARDWARE

// Enter Sketch
void onResume() {
  super.onResume();
  println("RESUMED! (Sketch Entered...)");
  
  // Orientation Sensor
  mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
  orSensorEventListener = new MySensorEventListener();
  or_sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
  mSensorManager.registerListener(orSensorEventListener, or_sensor, SensorManager.SENSOR_DELAY_GAME);
  
   //GPS Sensor
  locationListener = new MyLocationListener();
  locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
  locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
  
  // Notification Manager
  gNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  gNotification = new Notification();
  gNotification.vibrate = gVibrate;
  
}

// Exit Sketch
void onPause() {
  println("PAUSED! (Sketch Exited...)");
  super.onPause();
  super.onStop();
  
  // Unregister all of our SensorEventListeners upon exit:
  mSensorManager.unregisterListener(orSensorEventListener);
  
  // Release Power Manager
  wake.Stop();
  
  // Release Media Players
  if(forecast != null) {
    forecast.release();
    forecast = null; 
  }

} 

// Wake Lock
public class screenLock {
  PowerManager pm;
  Context context;
  WakeLock wl;

  public screenLock(Context parent) {
    this.context = parent;
    pm =(PowerManager) parent.getSystemService(Context.POWER_SERVICE);
    wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
  }

  public void Start() {
    wl.acquire();
  }

  public void Stop() {
    wl.release();
  }
}


//-----------------------------------------------------------------------------------------
// SENSOR

class MySensorEventListener implements SensorEventListener {
  void onSensorChanged(SensorEvent event) {
    int eventType = event.sensor.getType();
    if(eventType == Sensor.TYPE_ORIENTATION) {
      or_values = event.values;
    }
  }
  void onAccuracyChanged(Sensor sensor, int accuracy) {
    // do nothin...
  }
}


//-----------------------------------------------------------------------------------------
// LOCATION

class MyLocationListener implements LocationListener {
   void onLocationChanged(Location location) {
      // Turn Boolean True when Location Found
      GPSactive = true;
      
      // Called when a new location is found by the network location provider.
      currentLatitude  = (float)location.getLatitude();
      currentLongitude = (float)location.getLongitude();
      currentAccuracy  = (float)location.getAccuracy();
      currentProvider  = location.getProvider();
    }
    
    void onProviderDisabled (String provider) { 
      currentProvider = "";
    }

    void onProviderEnabled (String provider) {
      println("Provider is " + provider);
      currentProvider = provider;
    }
    
    void requestSingleUpdate(String provider, LocationListener MyLocationListener, Looper looper) {
     println("Requesting Updated Location...");   
    }

    void onStatusChanged (String provider, int status, Bundle extras) {
      println("New Status...");
    }
    
}

//-----------------------------------------------------------------------------------------
