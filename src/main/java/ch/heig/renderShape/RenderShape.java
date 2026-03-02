package ch.heig.renderShape;

import ch.heig.shapes.Shape;

import java.awt.*;

public abstract class RenderShape {
    public Shape shape;
    public Color color;

    public RenderShape(Shape shape, Color color){
        this.shape = shape;
        this.color = color;
    }

    public abstract void paint(Graphics g);
}
