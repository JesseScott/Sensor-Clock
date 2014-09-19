//-----------------------------------------------------------------------------------------
// WEATHER

void weather() {
  try{
    String weather[] = loadStrings("http://weather.yahooapis.com/forecastrss?w=1132599&u=c");    
    // println("This contains " + weather.length + " lines...");
    for (int i = 0; i < weather.length; i++) {
      //println("They are... " + weather[i]);
      if (weather[i].equals("<BR /><b>Forecast:</b><BR />")) {
        //println("The Line is " + i);
        forecastLine = i + 1;
        println ("Full Forecast is " + weather[forecastLine]);
      }
      if (weather[forecastLine].contains("Showers")) {
        //println("It's Gonna Rain!");
        sky = "rainy.mp3";
        break;
      }
      else if (weather[forecastLine].contains("Cloudy")) {
        //println("It's Cloudy");
        sky = "cloudy.mp3";
        break;
      }
      else if (weather[forecastLine].contains("Sunny") || weather[forecastLine].contains("Clear") ) {
        //println("It's Sunny");
        sky = "sunny.mp3";
        break;
      }
      else if (weather[forecastLine].contains("Snow")) {
        //println("It's Snowing");
        sky = "snowy.mp3";
        break;
      }
      else {
       sky = ""; 
      }
      //break;
    }
  }
  catch(Exception e) {
    println("Couldn't connect to internet... setting alarm to default");
    sky = "alarm.mp3";
  }  
}

////
