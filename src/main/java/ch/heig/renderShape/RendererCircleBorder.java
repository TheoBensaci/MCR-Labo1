package ch.heig.renderShape;

import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Circle;

import java.awt.*;

public class RendererCircleBorder extends RendererCircle{
    @Override
    public void display(Graphics2D graphics, Bouncable bouncable) {
        graphics.setColor(bouncable.getColor());
        int r = ((Circle)bouncable.getShape()).radius;
        graphics.setStroke(new BasicStroke(2));
        graphics.drawOval((int)bouncable.getShape().getX()-r, (int)bouncable.getShape().getY()-r,r*2,r*2);
    }
}
