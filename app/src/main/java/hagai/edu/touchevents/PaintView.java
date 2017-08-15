package hagai.edu.touchevents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Hagai Zamir on 15-Aug-17.
 */

public class PaintView extends View {

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    //properties:
    private Paint mPaint;
    private Path mPath;
    private Random r = new Random();
    private android.os.Handler h;
    Runnable randomColorRunnable = new Runnable() {
        @Override
        public void run() {
            mPaint.setColor(getRandomColor());
        }
    };

    private int getRandomColor(){
        return Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setAntiAlias(true); //line smoothing.
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPath = new Path();
        h = new android.os.Handler();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getAction();
        float x = e.getX();
        float y = e.getY();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                mPath.addCircle(x, y, 1, Path.Direction.CW);//clock wise.
                break;
            case  MotionEvent.ACTION_MOVE:

                int historySize = e.getHistorySize();
                for (int i = 0; i < historySize; i++) {
                    mPath.lineTo(e.getHistoricalX(i), e.getHistoricalY(i));
                }

                mPath.lineTo(x, y);

                break;
            case MotionEvent.ACTION_UP:
                h.postDelayed(randomColorRunnable, 500);
                break;
        }
        invalidate();//redraw, please.


        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255, 255, 255, 255);
        canvas.drawPath(mPath, mPaint);
    }
}
