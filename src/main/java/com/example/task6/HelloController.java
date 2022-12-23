package com.example.task6;

import Figure.Circle;
import Figure.Line;
import Figure.Rectangle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label Statusbar;
    @FXML
    ListView listViewShape;
    @FXML
    Canvas myCanvas;
    @FXML
    ColorPicker colorPickerShape;
    @FXML
    TextField tFStrokeWidth;
    private ObservableList<Shape> itemsShape;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsShape = FXCollections.observableArrayList(
                new Line(), new Rectangle(), new Circle());
        listViewShape.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewShape.setCellFactory (new Callback<ListView<Shape> ,
                ListCell<Shape>>() {
            @Override
            public ListCell<Shape>  call(ListView<Shape> listView) {
                return new ShapeCell();
            }

          }

        );
        listViewShape.setItems(itemsShape);
    }

    public void OnMouseClickCanvas(MouseEvent mouseEvent) {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        int indexShape = GetIndexListView(listViewShape);

        Shape shape = (Shape) itemsShape.get(indexShape).clone();

        shape.setColor(colorPickerShape.getValue());
        shape.setXY(mouseEvent.getX(), mouseEvent.getY());
        shape.draw(gc);
        Statusbar.setText("Нарисована фигура" + shape.toString() );
    }

    public void OnBtnClear() {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        gc.setEffect(null);
        gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
    }

    private int GetIndexListView(ListView listView) {
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return 0;
        }
        return index;
    }


}