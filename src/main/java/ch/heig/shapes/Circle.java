package ch.heig.shapes;

import ch.heig.Main;
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
    public Vector2f getBounceVector() {
        Vector2f pos = getPosition().add(getDirection());
        return new Vector2f(
                (pos.x+(float)this.radius/2 > Main.WIDTH)?1:(pos.x-(float)this.radius/2 <0)?-1:0,
                (pos.y+(float)this.radius/2  > Main.HEIGHT)?1:(pos.y-(float)this.radius/2 <0)?-1:0
        );
    }

    @Override
    public RenderShape getRenderShape() {
        return new RenderCircle(this, new Color(0xff0055));
    }
}
