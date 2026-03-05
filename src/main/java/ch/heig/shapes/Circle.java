package ch.heig.shapes;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererCircle;
import ch.heig.utils.Vector2f;

import java.awt.*;


public class Circle extends Shape {

    public final int radius;

    public Circle(int radius, int x, int y, Vector2f direction){
        super(x,y,direction);
        this.radius=radius;
        this._color=Color.BLUE;
    }

    @Override
    public Vector2f getBounceVector() {
        Vector2f pos = getPosition().add(getDirection());
        return new Vector2f(
                (pos.x+(float)this.radius/2 > Window.getInstance().getWidth())?1:(pos.x-(float)this.radius/2 <0)?-1:0,
                (pos.y+(float)this.radius/2  > Window.getInstance().getHeight())?1:(pos.y-(float)this.radius/2 <0)?-1:0
        );
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererCircle();
    }
}
