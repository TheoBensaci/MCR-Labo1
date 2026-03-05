package ch.heig.shapes;

import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererSquareBorder;
import ch.heig.utils.Vector2f;

import java.awt.*;

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
