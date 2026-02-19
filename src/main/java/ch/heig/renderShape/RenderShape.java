package ch.heig.renderShape;

import ch.heig.shapes.Shape;

import java.awt.*;

public abstract class RenderShape {
    Shape shape;
    Color color;

    public RenderShape(Shape shape, Color color){
        this.shape = shape;
        this.color = color;
    }

    abstract void paint(Graphics g);
}
