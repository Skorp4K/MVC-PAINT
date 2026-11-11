package org.example.model.factory;

import java.awt.*;
import java.util.Objects;

public class ShapeState {
    private ShapeType shapeType;
    private Color color;
    private  boolean isFill;

    public ShapeState(ShapeType shapeType, Color color, boolean isFill) {
        this.shapeType = Objects.requireNonNullElse(shapeType, ShapeType.RECTANGULAR_SHAPE);
        this.color = Objects.requireNonNullElse(color, Color.BLACK);
        this.isFill = isFill;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public boolean isFill() {
        return isFill;
    }

    public Color getColor() {
        return color;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFill(boolean fill) {
        isFill = fill;
    }
}
