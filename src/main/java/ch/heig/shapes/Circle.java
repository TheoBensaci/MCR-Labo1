package ch.heig.shapes;

import ch.heig.renderShape.RenderCircle;
import ch.heig.renderShape.RenderShape;
import ch.heig.utils.Vector2f;

import java.awt.*;


public class Circle extends Shape {

    public final int radius;

    public Circle(int radius, int x, int y, Vector2f direction){
        super(x,y,direction);
        this.radius=radius;
    }

    @Override
    public RenderShape getRenderShape() {
        return new RenderCircle(this, new Color(0xff0055));
    }
}
