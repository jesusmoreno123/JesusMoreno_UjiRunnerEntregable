package testFramework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.List;

import framework.Graphics;
import framework.IGameController;
import framework.TouchHandler;

public class TestFrameworkController implements IGameController {
    private Context context;
    private int squareSize;
    private int screenWidth;
    private int screenHeight;
    private int squareX;
    private int squareY;
    private int BASELINE;
    private int TOPLINE;
    private int THRESHOLD;
    private int squareXAux;
    private int squareYAux;
    private Graphics graphics;

    public TestFrameworkController(Context context, int size, int width, int height){
        this.context=context;
        squareSize=size;
        screenWidth=width;
        screenHeight=height;
        graphics=new Graphics(context,screenWidth, screenHeight);
        BASELINE=300;
        TOPLINE=BASELINE-100;
        THRESHOLD=100;
        squareX = this.screenWidth/5;
        squareY = BASELINE - this.squareSize;
        squareXAux=squareX;
        squareYAux=squareY;

    }
    @Override
    public void onUpdate(float deltaTime, List<TouchHandler.TouchEvent> touchEvents) {
        for (TouchHandler.TouchEvent event : touchEvents)
            if (event.type == TouchHandler.TouchType.TOUCH_DOWN) {
                if(event.x > squareX+squareSize+THRESHOLD && squareXAux==squareX){
                    squareX=screenWidth*3/5;
                }
                else if(event.x < squareX-THRESHOLD && squareXAux!=squareX){
                    squareX=screenWidth/5;
                }
                if(event.y < TOPLINE && squareY!=TOPLINE-squareSize){
                    squareY-=squareSize;
                }
                else if(event.y > BASELINE && squareY!=BASELINE){
                    squareY+=squareSize;
                }
                else if(event.y > TOPLINE && event.y < BASELINE){
                    if(squareY==TOPLINE-squareSize){
                        squareY+=squareSize;
                    }
                    else if(squareY==BASELINE){
                        squareY-=squareSize;
                    }
                }
            }
    }

    @Override
    public Bitmap onDrawingRequested() {
        graphics.clear(Color.WHITE);
        graphics.drawLine(0,BASELINE,screenWidth,BASELINE,Color.GREEN,5);
        graphics.drawLine(0,TOPLINE,screenWidth,TOPLINE,Color.CYAN,5);
        graphics.drawRect(squareX,squareY,squareSize,squareSize,Color.RED);
        return graphics.getFrameBuffer();
    }
}
