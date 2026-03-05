package ch.heig.shapes;

import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererCircleBorder;
import ch.heig.utils.Vector2f;

import java.awt.*;

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
