
//-----------------------------------------------------------------------------------------

void setup() {
  // Screen 
  size(displayWidth, displayHeight);
  sw = displayWidth; // 480.0 on Nexus One
  sh = displayHeight; // 800.0 on Nexus One
  orientation(PORTRAIT);
 
  // Power
  wake = new screenLock(this);
  wake.Start();
 
  // Setup Fonts:
  fontList = PFont.list();
  largeFont = createFont(fontList[0], largeText, true);
  smallFont = createFont(fontList[0], smallText, true);
  textFont(largeFont);
  
  // Directory
  try{
    dirName = "//sdcard//sensorClock";
    File newFile = new File(dirName);
    newFile.mkdirs();
    if(newFile.exists()) {
      println("Directory Exists...");
      if(newFile.isDirectory()) {
        println("isDirectory = true...");
      } else println("isDirectory = false...");
    } else {
      println("Directory Doesn't Exist...");
    }
  }
  catch(Exception e) {
    println("Exception creating folder... " + e); 
    e.printStackTrace();
  }
  
  // Check Files
  File a = new File("//sdcard//sensorClock//alarm.mp3");
  File b = new File("//sdcard//sensorClock//cloudy.mp3");
  File c = new File("//sdcard//sensorClock//rainy.mp3");
  File d = new File("//sdcard//sensorClock//sunny.mp3");
  File e = new File("//sdcard//sensorClock//snowy.mp3");

  if (a.exists() && b.exists() && c.exists() && d.exists() && e.exists() ) { 
    println("All Files Exist");
    displayState = 1;
  }
  else if (!a.exists() || !b.exists() || !c.exists() || !d.exists() || !e.exists() ) { 
    println("Some Files Missing");
    displayState = 0;
  }
 
  //Media Players
  forecast = new MediaPlayer();
  listener = new MyCompletionListener();
  forecast.setOnCompletionListener(listener);
  
  // Images
  about = loadImage("about.png");
  instructions = loadImage("instructions.png");
  error = loadImage("error.png");
  
  println();
  println("******");
  println("SETUP FINISHED");
  println("******");
  println();
}

//-----------------------------------------------------------------------------------------

void draw() {
  frameRate(30);
  background(10);

  // Display State
  if(displayState == 0) {
    State0(); 
  }
  else if(displayState == 1) {
    State1(); 
  }
  else if(displayState == 2) {
    State2(); 
  }
  else if(displayState == 3) {
    State3(); 
  }
  else if(displayState == 4) {
    State4(); 
  }
  //println("STATE IS " + displayState);
    
  if(GPSactive == true) {
    if(frameCount % 300 == 0) {
      //println("Latitude is " + currentLatitude);
      //println("Longitude is " + currentLongitude);
      //println("Accuracy is " + currentAccuracy);
      //println("Network is " + currentProvider);
      //println("FrameRate is " + frameRate);
    }
  }
  
}

//-----------------------------------------------------------------------------------------
