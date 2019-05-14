package model;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

public class Sprite {
    private Bitmap bitmapToRender;
    private boolean hFlip;
    private boolean spriteAnimated;
    private float x;
    private float y;
    private int speedX;
    private int speedY;
    private int sizeX;
    private int sizeY;
    private List listAnimations;
    private Rect rect;
    public Sprite(Bitmap bitmapToRender,boolean hFlip,float x, float y, int speedX, int speedY, int sizeX, int sizeY){
        this.bitmapToRender=bitmapToRender;
        this.hFlip=hFlip;
        this.x=x;
        this.y=y;
        this.speedX=speedX;
        this.speedY=speedY;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        listAnimations=new ArrayList<Animation>(null);
        rect=null;
        spriteAnimated=false;
    }

    public Bitmap getBitmapToRender() {
        return bitmapToRender;
    }

    public void setBitmapToRender(Bitmap bitmapToRender) {
        this.bitmapToRender = bitmapToRender;
    }

    public boolean ishFlip() {
        return hFlip;
    }

    public void sethFlip(boolean hFlip) {
        this.hFlip = hFlip;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
    public void move(float time){ //Tengo dudas de que se calculen así las coordenadas.
        x=speedX*time;
        y=speedY*time;
    }
}
