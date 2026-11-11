package org.example.model.factory;

import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;
import org.example.model.fill.NoFill;

import java.awt.*;

public class ShapeFactory {

    private static ShapeFactory instanse;
    private ShapeFactory() {

    }

    public static ShapeFactory getInstanse() {
        synchronized (ShapeFactory.class) {
            if (instanse == null) {
                instanse = new ShapeFactory();
            }
            return instanse;
        }
    }

    public MyShape createShape(ShapeType shapeType, Color color, boolean isFill) {
        FillBehavior fillBehavior = isFill ? new Fill() : new NoFill();
        return shapeType.createShape(fillBehavior, color);
    }
}
