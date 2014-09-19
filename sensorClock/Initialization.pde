
//-----------------------------------------------------------------------------------------
// IMPORTS
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;

import android.app.Notification;
import android.app.NotificationManager;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import apwidgets.*;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;

import java.io.File;
import java.io.IOException;


//-----------------------------------------------------------------------------------------
// DECLARATIONS

MediaPlayer forecast;
MyCompletionListener listener;

screenLock wake;

Looper looper;

GestureDetector mGestureDetector;

NotificationManager gNotificationManager;  
Notification gNotification; 

LocationManager locationManager;
MyLocationListener locationListener;

SensorManager mSensorManager;
MySensorEventListener orSensorEventListener;
Sensor or_sensor;

//-----------------------------------------------------------------------------------------
// VARIABLES

// screen
float sw, sh;
int displayState;
color bg = #231F20;

// Font Data:
String[] fontList;
PFont largeFont, smallFont;
int largeText = 32;
int smallText = 24;

// Images
PImage about, instructions, error; // Screens 0, 1, 2

// Vibrate
long[] gVibrate = {10, 20, 10, 30, 10, 40}; // Vibration Pattern

// System
String dirName;

// Weather
String sky = ""; // This will set the data path to the audio file
int forecastLine;
int temperature;

// Location
boolean GPSactive = false;
float currentLatitude  = 0;
float currentLongitude = 0;
float currentAccuracy  = 0;
String currentProvider = "";

// Orientation
float[] or_values;
int h, m, s;
boolean alarm = false;

// Calibration
int calibState = 0;
boolean calib1, calib2 = false;
float calibLow, calibHigh;

//-----------------------------------------------------------------------------------------
