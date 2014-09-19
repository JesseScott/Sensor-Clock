
//-----------------------------------------------------------------------------------------
// MENU

void State0() {
  if(displayState == 0) {
    // Error
    background(bg);
    rectMode(CORNER);
    image(error, 0, 0);
  }
}

//----

void State1() {
  if(displayState == 1) {
    // About
    background(bg);
    rectMode(CORNER);
    image(about, 0, 0);

    if (mousePressed) {
      gNotificationManager.notify(1, gNotification);
      displayState = 2; 
    }
    
  }
}

//----

void State2() {
  if(displayState == 2) {
    // Instructions
    background(bg);
    rectMode(CORNER);
    image(instructions, 0, 0);
    
    if(mousePressed) {
      gNotificationManager.notify(1, gNotification);
      displayState = 3; 
    }
    
  }
}

//----

void State3() {
  if(displayState == 3) {
    // Calibration
    background(bg);
    fill(255);
    noStroke();
    
    // Recalibrate?
    if(calibState == 0) {
      textFont(largeFont);
      text("RECALIBRATE?", width/4, height/4);
      text("YES", width/4, height/2);
      text("NO", 3*(width/4), height/2);
      
      if(mousePressed) {
        if(mouseY > height/2 - largeText && mouseY < height/2 + largeText) {
          println(mouseY);
          if(mouseX > width/4 - largeText && mouseX < width/4 + largeText) {
            println(mouseX);
            displayState = 4;
            println("NO");
          }
          else if(mouseX > 3*(width/4) - largeText && mouseX < 3*(width/4) + largeText) {
             displayState = 4;
             calibState = 1;
             println("YES");          }
        } 
      } 
    }
    
      // Read TXT
    
    // Set Low
    else if(calibState == 1) {
      text("Set Low Point", width/2, height/2); 
    }
    
    // Set High
    
    // Done
    
    
  }
}

//----

void State4() {
  if(displayState == 4) {
    // Idle
    background(bg);
    fill(255);
    noStroke();
    
    if (or_values != null) {  
      // Time
      h = hour();
      text(" H is " + h, sw/4, sh/4);
      
      // Round Z and Display
      float _z = norm(or_values[2], 23, -28); // maybe a cailbration ?
      float nz = map(_z, 0.0, 1.0, 0.0, 23.0);
      int z = round(nz);
      int cz = constrain(z, 0, 23);
      text(" Z is " + cz, sw/4, sw/4 + 50); 
    if(h == z) {
      //println("YAY!!!!");
      fill(0, 255,0);
      alarm = true;
      weather();
      startPlaying();
    }
    else {
      //println("NO!!!!");
      fill(255,0, 0);
      alarm = false;
    }
    //text(" Alarm ? " + alarm, sw/4, sh/2);
    text(sky, sw/4, sh/2 + 75); 
    }
    else  {
     text("Sensor: null", 8, 20);
    }
    
    
  }
}

//-----------------------------------------------------------------------------------------
