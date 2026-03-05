package ch.heig.renderShape;

import ch.heig.shapes.Bouncable;
import java.awt.*;

public interface Renderer {
    void display(Graphics2D graphics, Bouncable bouncable);
}
