package ch.heig.shapes;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererSquare;
import ch.heig.utils.Vector2f;

import java.awt.*;


public class Square extends Shape{

    public final int width;
    public final int height;

    public Square(int width,int height, int x, int y, Vector2f direction){
        super(x,y,direction);
        this.width=width;
        this.height=height;
        this._color= Color.YELLOW;
    }

    @Override
    public Vector2f getBounceVector() {
        Vector2f pos = getPosition().add(getDirection());
        return new Vector2f(
                (pos.x+(float)this.width/2 > Window.getInstance().getWidth())?1:(pos.x-(float)this.width/2 <0)?-1:0,
                (pos.y+(float)this.height/2  > Window.getInstance().getHeight())?1:(pos.y-(float)this.height/2 <0)?-1:0
        );
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererSquare();
    }
}
