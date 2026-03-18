/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:11 19.02.2026
 *   Description: cicrle
 */

package ch.heig.shapes;

import java.awt.Color;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererCircle;
import ch.heig.utils.Vector2f;


public class Circle extends Shape {

    public final int radius;

    public Circle(int radius, int x, int y, Vector2f direction){
        super(x,y,direction);
        this.radius=radius;
        this._color=Color.BLUE;
    }

    @Override
    public Vector2f getBounceNormalVector() {
        Vector2f pos = getPosition().add(getDirection());
        return new Vector2f(
                (pos.x+(float)this.radius > Window.getInstance().getWidth())?
                        pos.x+(float)this.radius-Window.getInstance().getWidth()
                        :(pos.x-(float)this.radius <0)?(pos.x-(float)this.radius):0,
                (pos.y+(float)this.radius > Window.getInstance().getHeight())?
                        pos.y+(float)this.radius-Window.getInstance().getHeight()
                        :(pos.y-(float)this.radius <0)?(pos.y-(float)this.radius):0
        );
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererCircle();
    }
}
