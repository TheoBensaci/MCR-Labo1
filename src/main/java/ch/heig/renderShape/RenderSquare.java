package ch.heig.renderShape;

import ch.heig.shapes.Shape;
import ch.heig.shapes.Square;

import java.awt.*;

public class RenderSquare extends RenderShape {

    public RenderSquare(Square s, Color c){
        super(s,c);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        Square sq = (Square)this.shape;
        g.fillRect((int)this.shape.getX()-sq.width/2, (int)this.shape.getY()-sq.height/2, sq.width, sq.height);
    }
}
