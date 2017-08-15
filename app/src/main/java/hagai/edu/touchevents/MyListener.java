package hagai.edu.touchevents;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Hagai Zamir on 15-Aug-17.
 */

public class MyListener extends GestureDetector.SimpleOnGestureListener {


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return super.onDown(e);
    }
}
