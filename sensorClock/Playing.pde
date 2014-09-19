
//-----------------------------------------------------------------------------------------
// PLAYER

void startPlaying() {
  //println("Starting File...");
  
  if(!forecast.isPlaying()) {
    try {
      sky = "sdcard/sensorClock/" + sky;
      println("PLAYING " + sky);
      forecast.setDataSource(sky);
      //println("data set");
      forecast.setLooping(false);
      forecast.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
      forecast.prepare();
      forecast.start();
    } 
    catch (IOException e) {
      println("prepare() failed ... no match? ");
      e.printStackTrace();
    }
  }
}

//-----------------------------------------------------------------------------------------
// LISTENER

import android.media.MediaPlayer.OnCompletionListener;

public class MyCompletionListener implements MediaPlayer.OnCompletionListener {

 public void onCompletion(MediaPlayer forecast) {
    println("CALLING...");
    forecast.reset();
    //forecast = null; 
  }
}

