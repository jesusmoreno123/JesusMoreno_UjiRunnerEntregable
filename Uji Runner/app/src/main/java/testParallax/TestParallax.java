package testParallax;

import android.util.DisplayMetrics;

import framework.GameActivity;

public class TestParallax extends GameActivity {

    public TestParallaxController buildGameController(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TestParallaxController controller = new TestParallaxController(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        return controller;
    }
}
