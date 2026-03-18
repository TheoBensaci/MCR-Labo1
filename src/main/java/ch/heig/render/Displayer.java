/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 13:49 26.02.2026
 *   Description: interface implemented by the window or any things use for display the UI
 */

package ch.heig.render;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

public interface Displayer {
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String title);
    void addKeyListener(KeyAdapter keyAdapter);
}
