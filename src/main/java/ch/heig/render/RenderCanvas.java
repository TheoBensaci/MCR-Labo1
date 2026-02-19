package ch.heig.render;

import ch.heig.utils.Vector2f;

import javax.swing.*;
import java.awt.*;

public class RenderCanvas extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(0x16162a); // game render background colore

    // GAME SETTINGS
    public static final int WIDTH = 800; // default render width
    public static final int HEIGHT = 800; // default render height

    public int actualWidth = WIDTH; // actual render width
    public int actualHeight = HEIGHT; // actual render height
    private float _renderScale = 1f; // actual render scale
    private Vector2f _renderOffset = new Vector2f(0, 0);

    public RenderCanvas() {
        this.actualWidth = WIDTH;
        this.actualHeight = HEIGHT;
        setFocusable(false);

    }

    /**
     * Resize the game render
     *
     * @param targetWidth target width
     * @param targetHeight target height
     */
    public void resizeGameRender(int targetWidth, int targetHeight) {
        actualWidth = targetWidth;
        actualHeight = targetHeight;
        if (targetWidth > targetHeight) {
            _renderScale = (float) (actualHeight) / HEIGHT;
            _renderOffset.set((actualWidth - WIDTH * _renderScale) / 2, 0);
        } else {
            _renderScale = (float) (actualWidth) / WIDTH;
            _renderOffset.set(0, (actualHeight - HEIGHT * _renderScale) / 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(actualWidth, actualHeight);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    /**
     * get the actual render scale
     *
     * @return
     */
    public float getRenderScale() {
        return _renderScale;
    }

    public Vector2f getRenderOffset() {
        return _renderOffset.copy();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);

        // apply tranform, use to creat screen shake
    /*
    AffineTransform at = new AffineTransform();
    //at.rotate(2);
    at.rotate(Math.PI/4,WIDTH / 2, HEIGHT / 2);
    ((Graphics2D) g).transform(at);
    */

        /*
        AffineTransform renderTransform = new AffineTransform();
        // renderTransform.rotate(Math.PI/1,WIDTH/2,HEIGHT/2);
        renderTransform.translate(_renderOffset.x, _renderOffset.y);
        renderTransform.scale(_renderScale, _renderScale);
        ((Graphics2D) g).transform(renderTransform);

        // draw arena
        if (Arena.active) Arena.drawBackground(g);

        try {
            _semaphore.acquire();
            for (IDrawable drawable : _drawables) {
                if (drawable instanceof Entity ent) {
                    if (ent.getGroup() != actualGroupRender) continue;
                }
                drawable.draw(g);
            }
            _semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // arena outline
        if (Arena.active) Arena.drawOutline(g);

        // UI render

        g.setColor(Color.ORANGE);
        float a = (float) (System.nanoTime() - _updateStart) / 1000000;
        g.drawString("Game engine delta Time : " + game.getDeltaTime() + "ms", 10, 40);
        g.drawString("Paint delta time : " + a + "ms", 10, 60);
        g.drawString("Number of IUpdateble : " + game.getNumberOfUpdatable(), 10, 80);

        g.setColor(Color.ORANGE);
        Point p = game.input.getMousePos();
        g.fillRect(p.x - 5, p.y - 5, 10, 10);
        */
    }


    // #region DEFAULT GRAPHIC

    /**
     * Draw a background color
     *
     * @param g
     */
    private void drawBackground(Graphics g) {
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, actualWidth + 10, actualHeight + 10);
    }

    // #endregion

    /** Close the game render */
    public void close() {

    }
}