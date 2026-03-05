package ch.heig.renderShape;

import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Circle;

import java.awt.*;

public class RendererCircle implements Renderer{
    @Override
    public void display(Graphics2D graphics, Bouncable bouncable) {
        graphics.setColor(bouncable.getColor());
        int r = ((Circle)bouncable.getShape()).radius;
        graphics.fillOval((int)bouncable.getShape().getX()-r/2, (int)bouncable.getShape().getY()-r/2,r,r);
    }
}
