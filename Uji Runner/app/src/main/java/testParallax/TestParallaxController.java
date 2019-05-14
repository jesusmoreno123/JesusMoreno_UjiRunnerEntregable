package testParallax;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.example.myapplication.Assets;

import java.util.List;

import framework.Graphics;
import framework.IGameController;
import framework.TouchHandler;
import model.Sprite;

public class TestParallaxController implements IGameController {
    private Context context;
    private int BASELINE;
    private int TOPLINE;
    private int THRESHOLD;
    private int SQUARE_SIZE;
    private float scaleX;
    private float scaleY;
    private int screenWidth;
    private int screenHeight;
    private Graphics graphics;
    private TestParallaxModel model;


    public TestParallaxController(Context context, int width, int height) {
        this.context = context;
        BASELINE = 275;
        TOPLINE = BASELINE - 55;
        THRESHOLD = 50;
        SQUARE_SIZE = 40;
        screenWidth = width;
        screenHeight = height;
        scaleX = (float) TestParallaxModel.STAGE_WIDTH / screenWidth;
        scaleY = (float) TestParallaxModel.STAGE_HEIGHT / screenHeight;
        Assets.createAssets(context, SQUARE_SIZE, TestParallaxModel.STAGE_HEIGHT, TestParallaxModel.STAGE_WIDTH);
        model = new TestParallaxModel(SQUARE_SIZE, BASELINE, TOPLINE, THRESHOLD);
        graphics = new Graphics(context, TestParallaxModel.STAGE_WIDTH, TestParallaxModel.STAGE_HEIGHT);

    }

    @Override
    public void onUpdate(float deltaTime, List<TouchHandler.TouchEvent> touchEvents) {
        model.update(deltaTime);
        for (TouchHandler.TouchEvent event : touchEvents)
            if (event.type == TouchHandler.TouchType.TOUCH_DOWN) {
                model.onTouch(event.x * scaleX, event.y * scaleY);
            }
    }

    @Override
    public Bitmap onDrawingRequested() {
        graphics.clear(Color.WHITE);
        Sprite[] sprites1 = model.getBgParallax();
        Sprite[] sprites2 = model.getShiftedBgParallax();
        for (int i = 0; i < sprites1.length; i++) {
            Graphics graphics1 = new Graphics(context,sprites1[i].getSizeX(),sprites1[i].getSizeY());
            graphics1.drawBitmap(sprites1[i].getBitmapToRender(),sprites1[i].getX(),sprites1[i].getY(),sprites1[i].ishFlip());
            Graphics graphics2 = new Graphics(context,sprites2[i].getSizeX(),sprites2[i].getSizeY());
            graphics2.drawBitmap(sprites2[i].getBitmapToRender(),sprites2[i].getX(),sprites2[i].getY(),sprites2[i].ishFlip());
        }
        graphics.drawLine(0,TOPLINE,screenWidth,TOPLINE,Color.CYAN,5);
        graphics.drawLine(0,BASELINE,screenWidth,BASELINE,Color.GREEN,5);
        graphics.drawRect(model.getSquarex(),model.getSquareY(),SQUARE_SIZE,SQUARE_SIZE,Color.RED);
        return graphics.getFrameBuffer();
    }
}