package testFramework;

import android.content.Context;
import android.util.DisplayMetrics;

import framework.GameActivity;

public class TestFramework extends GameActivity {

    public TestFrameworkController buildGameController(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TestFrameworkController controller = new TestFrameworkController(this, 100, displayMetrics.widthPixels, displayMetrics.heightPixels);
        return controller;
    }
}
