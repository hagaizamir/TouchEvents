package hagai.edu.touchevents;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NESS";
    private GestureDetectorCompat detector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new HatView(this /*context*/));

        detector = new GestureDetectorCompat(
                this /*context*/ ,
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        if (e1 == null || e2 == null) return true;
                        float x1 = e1.getX();
                        float x2 = e2.getX();

                        float y1 = e1.getY();
                        float y2 = e2.getY();

                        float dx = x2 - x1;
                        float dy = y2 - y1;

                        if (Math.abs(dx) > Math.abs(dy)){
                            //Horizontal swipe.
                            if (x2 > x1){
                                Log.d(TAG, "Swipe Right");
                            }else {
                                Log.d(TAG , "Swipe Left");
                            }

                        }else {
                            //vertical swipe
                            if (y2 > y1){
                                Log.d(TAG , "Swipe Down");

                            }else {
                                Log.d(TAG , "Swipe Up");
                            }
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        /*

        int action = e.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG , "onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG , "onTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG , "onTouchEvent:ACTION_MOVE");
                break;
        }
       float x =  e.getX();
        float y = e.getY();

        PointF p = new PointF(x, y);
        Log.d(TAG , "onTouchEvent:" + p);

        return super.onTouchEvent(e);
        */
        return  super.onTouchEvent(e);
    }
}
