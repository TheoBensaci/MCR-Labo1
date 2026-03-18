/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:20 05.03.2026
 *   Description: Interface use by all shape
 */

package ch.heig.shapes;

import java.awt.Color;

public interface Bouncable {

    /**
     * Render the shape on the UI
     */
    void draw();

    /**
     * Move the shape
     */
    void move();

    /**
     * Get shape color
     */
    Color getColor();

    /**
     * Get shape ref
     */
    Shape getShape();
}
