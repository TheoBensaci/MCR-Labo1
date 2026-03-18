/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: Render of a square
 */

package ch.heig.renderShape;

import java.awt.Graphics2D;

import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Square;

public class RendererSquare implements Renderer{
    @Override
    public void display(Graphics2D graphics, Bouncable bouncable) {
        graphics.setColor(bouncable.getColor());
        Square sq = (Square)bouncable.getShape();
        graphics.fillRect((int)bouncable.getShape().getX()-sq.width/2, (int)bouncable.getShape().getY()-sq.height/2, sq.width, sq.height);
    }
}
