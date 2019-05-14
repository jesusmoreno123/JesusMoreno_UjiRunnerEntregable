package testParallax;

import com.example.myapplication.Assets;

import framework.TouchHandler;
import model.Sprite;
import java.lang.Math;

public class TestParallaxModel {
    public static int STAGE_WIDTH = 480;
    public static int STAGE_HEIGHT = 320;
    public int PARALLAX_WIDTH;
    public int PARALLAX_LAYERS;
    private static final float UNIT_TIME = 1f / 30;
    private int playerWidth;
    private int baseline;
    private int topline;
    private int threshold;
    private float tickTime;
    private int squareX;
    private int squareY;
    private int squareXAux;
    private int squareYAux;
    private Sprite[] bgParallax;
    private Sprite[] shiftedBgParallax;

    public TestParallaxModel(int playerWidth, int baseline, int topline, int threshold) {
        this.playerWidth = playerWidth;
        this.baseline = baseline;
        this.topline = topline;
        this.threshold = threshold;
        squareX = this.playerWidth / 5;
        squareY = baseline - this.playerWidth;
        squareXAux=squareX;
        squareYAux=squareY;
        tickTime = 0f;
        bgParallax = new Sprite[PARALLAX_LAYERS];
        shiftedBgParallax = new Sprite[PARALLAX_LAYERS];
        for (int i = 0; i < PARALLAX_LAYERS; i++) {
            int speed = 40 - (PARALLAX_LAYERS * i);
            bgParallax[i] = new Sprite(Assets.bgLayers[i], false, 0f, 0f, -speed,
                    0, PARALLAX_WIDTH, STAGE_HEIGHT);
            shiftedBgParallax[i] = new Sprite(Assets.bgLayers[i], false, PARALLAX_WIDTH,
                    0f, -speed, 0, PARALLAX_WIDTH, STAGE_HEIGHT);
        }
    }

    public void update(float deltaTime) {
        tickTime += deltaTime;
        while (tickTime >= UNIT_TIME) {
            tickTime -= UNIT_TIME;
            updateParallaxBg();
        }
    }

    private void updateParallaxBg() {
        for(int i=0;i<bgParallax.length;i++){
            bgParallax[i].move(UNIT_TIME);
            if(bgParallax[i].getX()<=(-bgParallax[i].getSizeX())){
                bgParallax[i].setX(PARALLAX_WIDTH);
                shiftedBgParallax[i].setX(PARALLAX_WIDTH);
            }
        }
    }

    public void onTouch(float scaledX, float scaledY) {
            if (scaledX > squareX + playerWidth + threshold && squareXAux==squareX) {
                squareX = STAGE_WIDTH * 3 / 5;
            } else if (scaledX < squareX - threshold && squareXAux!=squareX) {
                squareX = STAGE_WIDTH / 5;
            }
            if (scaledY < topline && squareY!=topline-playerWidth) {
                squareY -= playerWidth;
            } else if (scaledY > baseline && squareY != baseline) {
                squareY = playerWidth;
            } else if (scaledY < baseline && scaledY > topline) {
                if(squareY==topline-playerWidth){
                    squareY+=playerWidth;
                }
                else if(squareY==baseline){
                    squareY-=playerWidth;
                }
            }
    }


    public int getSquareY() {
        return squareY;
    }

    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    public int getSquarex() {
        return squareX;
    }

    public void setSquarex(int squarex) {
        this.squareX = squareX;
    }
    public Sprite[] getBgParallax() {
        return bgParallax;
    }

    public void setBgParallax(Sprite[] bgParallax) {
        this.bgParallax = bgParallax;
    }
    public Sprite[] getShiftedBgParallax() {
        return shiftedBgParallax;
    }

    public void setShiftedBgParallax(Sprite[] shiftedBgParallax) {
        this.shiftedBgParallax = shiftedBgParallax;
    }

}

