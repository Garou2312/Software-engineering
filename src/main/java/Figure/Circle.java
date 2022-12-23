package Figure;

import com.example.task6.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    Color colorShape;
    double x,y, strokeWidth;

    public Circle() {type = "Круг";}
    @Override
    public void setColor(Color color) {colorShape = color;}


    @Override public void setStrokeWidth(double value) {strokeWidth = value;}



    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(colorShape);
        gc.setLineWidth(strokeWidth);
        gc.fillOval(x, y, 50, 50);
    }

    @Override
    public String toString() {return type;}
}

