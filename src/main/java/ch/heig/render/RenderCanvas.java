package ch.heig.render;

import ch.heig.renderShape.Renderer;
import ch.heig.utils.Vector2f;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderCanvas extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(0x16162a); // game render background colore

    // GAME SETTINGS

    private int _width; // origin render width
    private int _height; // origin render height


    private float _renderScale = 1f; // actual render scale
    private Vector2f _renderOffset = new Vector2f(0, 0);

    private List<Renderer> _shapes=new ArrayList<>();

    public RenderCanvas(int width, int height) {
        this._width=width;
        this._height=height;
        setFocusable(false);

    }

    /**
     * Resize the game render
     *
     * @param targetWidth target width
     * @param targetHeight target height
     */
    public void resizeRender(int targetWidth, int targetHeight) {
        this._width = targetWidth;
        this._height = targetHeight;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(_width, _height);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw background 2
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, _width, _height);

        ((Graphics2D)g).drawImage(Window.getInstance().flush(),0,0,null);
    }


    public void addShape(Renderer shape){
        _shapes.add(shape);
    }
}