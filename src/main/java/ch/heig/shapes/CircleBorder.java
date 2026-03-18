/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: empty circle with border
 */

package ch.heig.shapes;

import java.awt.Color;

import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererCircleBorder;
import ch.heig.utils.Vector2f;

public class CircleBorder extends Circle {
    public CircleBorder(int radius, int x, int y, Vector2f direction){
        super(radius,x,y,direction);
        this._color= Color.GREEN;
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererCircleBorder();
    }
}
