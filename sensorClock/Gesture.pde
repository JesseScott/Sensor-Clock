//-----------------------------------------------------------------------------------------
// GESTURE

class LearnGestureListener extends GestureDetector.SimpleOnGestureListener {
  @Override
    public boolean onSingleTapUp(MotionEvent ev) {
    //println("onSingleTapUp");
    return true;
  }
  @Override
    public boolean onDoubleTap(MotionEvent ev) {
    //println("onDoubleTap");
    return true;
  }
  @Override
    public void onShowPress(MotionEvent ev) {
    //println("onShowPress");
  }
  @Override
    public void onLongPress(MotionEvent ev) {
    //println("onLongPress");
  }
  @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    //println("onScroll");
    return true;
  }
  @Override
    public boolean onDown(MotionEvent ev) {
    //println("onDown");
    return true;
  }
  @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    //println("onFling");
    return true;
  }
}

//

public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  mGestureDetector = new GestureDetector(this, new LearnGestureListener());
}

//

public boolean surfaceTouchEvent(MotionEvent me) {
  if (mGestureDetector.onTouchEvent(me)) {
    //return true;
    return super.surfaceTouchEvent(me);
  }
  else  {
    return false;
  }
}

