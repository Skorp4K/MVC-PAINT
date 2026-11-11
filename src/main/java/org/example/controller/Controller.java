package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.factory.ShapeFactory;
import org.example.model.factory.ShapeType;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;

// TODO: Сделать singleton класс
public class Controller {
    private final Model model;
    private final MyFrame frame;
    private final MyPanel panel;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private ShapeFactory shapeFactory;


    public Controller() {
        model = new Model();
        shapeFactory = ShapeFactory.getInstanse();
        MyShape shape = shapeFactory.createShape(ShapeType.RECTANGULAR_SHAPE, Color.BLUE, true);
        model.setDrawableShape(shape);

        panel = new MyPanel(this);
        // TODO: Поменять наблюдатель на более современную реализацию
        model.addObserver(panel);

        frame = new MyFrame();
        frame.setPanel(panel);
        panel.revalidate();
        panel.repaint();
    }
    public void mousePressed(Point2D p){
        firstPoint = p;
        MyShape shape = shapeFactory.createShape(ShapeType.RECTANGULAR_SHAPE, Color.RED, false);
        model.setDrawableShape(shape);
        model.addShape(shape);
    }
    public void mouseDragged(Point2D p){
        secondPoint = p;
        model.changeShape(firstPoint, secondPoint);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
