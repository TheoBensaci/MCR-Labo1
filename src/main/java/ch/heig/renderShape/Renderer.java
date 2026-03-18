/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: Interface implemented by all class use for render
 */

package ch.heig.renderShape;

import java.awt.Graphics2D;

import ch.heig.shapes.Bouncable;

public interface Renderer {
    void display(Graphics2D graphics, Bouncable bouncable);
}
