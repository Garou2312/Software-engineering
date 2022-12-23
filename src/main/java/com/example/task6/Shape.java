package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    protected String type;
    public abstract void setColor(Color color);
    public abstract void setStrokeWidth(double value);
    public abstract void setXY(double x, double y);
    public abstract void draw(GraphicsContext graphicsContext);
    @Override
    public String toString(){ return super.toString(); }
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException exception){
            exception.printStackTrace();
        }
        return clone;
    }
    protected String Type;

}
