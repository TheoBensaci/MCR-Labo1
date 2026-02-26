package ch.heig.shapes;

import ch.heig.renderShape.RenderShape;
import ch.heig.renderShape.RenderSquare;
import ch.heig.utils.Vector2f;

import java.awt.*;


public class Square extends Shape{

    public final int width;
    public final int height;

    public Square(int width,int height, int x, int y, Vector2f direction){
        super(x,y,direction);
        this.width=width;
        this.height=height;
    }

    @Override
    public RenderShape getRenderShape() {
        return new RenderSquare(this, Color.yellow);
    }
}
