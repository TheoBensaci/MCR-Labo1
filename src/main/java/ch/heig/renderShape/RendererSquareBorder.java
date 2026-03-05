package ch.heig.renderShape;

import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Square;
import ch.heig.shapes.SquareBorder;

import java.awt.*;

public class RendererSquareBorder extends RendererSquare{
    @Override
    public void display(Graphics2D graphics, Bouncable bouncable) {
        graphics.setColor(bouncable.getColor());
        Square sq = (SquareBorder)bouncable.getShape();
        graphics.setStroke(new BasicStroke(2));
        graphics.drawRect((int)bouncable.getShape().getX()-sq.width/2, (int)bouncable.getShape().getY()-sq.height/2, sq.width, sq.height);
    }
}
