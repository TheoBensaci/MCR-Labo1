/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: empty square with border
 */

package ch.heig.shapes;

import java.awt.Color;

import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererSquareBorder;
import ch.heig.utils.Vector2f;

public class SquareBorder extends Square {
    public SquareBorder(int width,int height, int x, int y, Vector2f direction){
        super(width, height,x,y,direction);
        this._color= Color.RED;
    }

    @Override
    public Renderer getRenderShape() {
        return new RendererSquareBorder();
    }
}
