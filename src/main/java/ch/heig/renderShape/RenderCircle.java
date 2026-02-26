package ch.heig.renderShape;

import ch.heig.shapes.Circle;
import ch.heig.shapes.Shape;

import java.awt.*;

public class RenderCircle extends RenderShape {

    public RenderCircle(Circle s, Color c){
        super(s,c);

    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.color);
        int r = ((Circle)this.shape).radius;
        g.fillOval((int)this.shape.getX()-r/2, (int)this.shape.getY()-r/2,r,r);
    }
}
