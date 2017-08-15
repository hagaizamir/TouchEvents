package hagai.edu.touchevents;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hide();
        setContentView(new PaintView(this));
//        Handler uiThreadHandler = new Handler();//Thread Handler...
//        uiThreadHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 1000);
    }



    private void hide() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

}
