package ch.heig.renderShape;

import ch.heig.shapes.Shape;

import java.awt.*;

public class RenderCercle extends RenderShape {

    public RenderCercle(Shape s, Color c){
        super(s,c);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.color);
        g.fillOval(this.shape.getX(), this.shape.getY(), this.shape.getSize(), this.shape.getSize());
    }
}
