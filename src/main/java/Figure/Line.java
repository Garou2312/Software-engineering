package Figure;

import com.example.task6.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    public Line() {type = "Линия";}

    Color colorShape;

    double x,y, strokeWidth;
    @Override
    public void setColor(Color color) {colorShape = color;}

    @Override
    public void setStrokeWidth(double value) {strokeWidth = value;}

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(colorShape);
        gc.setLineWidth(strokeWidth);
        gc.strokeLine(x, y, x + 150, y+100 );
    }
    @Override
    public String toString() {return type;}
}
