/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:11 19.02.2026
 *   Description: square
 */

package ch.heig.shapes;

import java.awt.Color;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererSquare;
import ch.heig.utils.Vector2f;


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
    public Vector2f getBounceNormalVector() {
        Vector2f pos = getPosition().add(getDirection());
        return new Vector2f(
                (pos.x+(float)this.width/2 > Window.getInstance().getWidth())?
                        pos.x+(float)this.width/2-Window.getInstance().getWidth()
                        :(pos.x-(float)this.width/2 <0)?(pos.x-(float)this.width/2):0,
                (pos.y+(float)this.height/2 > Window.getInstance().getHeight())?
                        pos.y+(float)this.height/2-Window.getInstance().getHeight()
                        :(pos.y-(float)this.height/2 <0)?(pos.y-(float)this.height/2):0
        );
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererSquare();
    }
}
