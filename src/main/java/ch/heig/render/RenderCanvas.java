/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:05 19.02.2026
 *   Description: class canavas use to render all things
 */

package ch.heig.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ch.heig.renderShape.Renderer;
import ch.heig.utils.Vector2f;

public class RenderCanvas extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(0x16162a); // game render background colore

    // GAME SETTINGS

    private int _width; // origin render width
    private int _height; // origin render height


    private float _renderScale = 1f; // actual render scale
    private Vector2f _renderOffset = new Vector2f(0, 0);

    private List<Renderer> _shapes=new ArrayList<>();

    private BufferedImage _img;     // buffer image use for render
    private Graphics2D  _g2d=null;  // Graphics2D of the buffer image

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

        // draw background
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, _width, _height);

        // draw shape buffer
        _g2d.dispose();
        ((Graphics2D)g).drawImage(_img,0,0,null);

        // clear buffer
        clearBuffer();
    }

    /**
     * Get buffer image graphics
     * @return
     */
    public Graphics2D getBufferGraphics(){
        return _g2d;
    }

    /**
     * Clear buffer image
     */
    public void clearBuffer(){
        _img=new BufferedImage(Window.getInstance().getWidth(),Window.getInstance().getHeight(), BufferedImage.TYPE_INT_ARGB);
        _g2d=_img.createGraphics();
    }
}