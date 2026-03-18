/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: Render of circle
 */

package ch.heig.renderShape;

import java.awt.Graphics2D;

import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Circle;

public class RendererCircle implements Renderer{
    @Override
    public void display(Graphics2D graphics, Bouncable bouncable) {
        graphics.setColor(bouncable.getColor());
        int r = ((Circle)bouncable.getShape()).radius;
        graphics.fillOval((int)bouncable.getShape().getX()-r, (int)bouncable.getShape().getY()-r,r*2,r*2);
    }
}
