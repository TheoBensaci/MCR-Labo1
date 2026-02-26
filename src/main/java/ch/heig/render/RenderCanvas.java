package ch.heig.render;

import ch.heig.renderShape.RenderShape;
import ch.heig.utils.Vector2f;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class RenderCanvas extends JPanel {

    public static final Color BACKGROUND_COLOR = new Color(0x16162a); // game render background colore
    public static final Color BACKGROUND_COLOR_2 = new Color(0x383850); // game render background colore

    // GAME SETTINGS

    public int actualWidth; // actual render width
    public int actualHeight; // actual render height
    public final int width; // origin render width
    public final int height; // origin render height


    private float _renderScale = 1f; // actual render scale
    private Vector2f _renderOffset = new Vector2f(0, 0);

    private List<RenderShape> _shapes=new ArrayList<>();

    public RenderCanvas(int width, int height) {
        this.width=this.actualWidth=width;
        this.height=this.actualHeight=height;
        setFocusable(false);

    }

    /**
     * Resize the game render
     *
     * @param targetWidth target width
     * @param targetHeight target height
     */
    public void resizeRender(int targetWidth, int targetHeight) {
        actualWidth = targetWidth;
        actualHeight = targetHeight;
        if (targetWidth > targetHeight) {
            _renderScale = (float) (actualHeight) / width;
            _renderOffset.set((actualWidth - height * _renderScale) / 2, 0);
        } else {
            _renderScale = (float) (actualWidth) / height;
            _renderOffset.set(0, (actualHeight - width * _renderScale) / 2);
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

        // draw background 1
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, actualWidth + 10, actualHeight + 10);

        // apply tranform, use to creat screen shake
        AffineTransform renderTransform = new AffineTransform();
        renderTransform.translate(_renderOffset.x, _renderOffset.y);
        renderTransform.scale(_renderScale, _renderScale);
        ((Graphics2D) g).transform(renderTransform);

        // draw background 2
        g.setColor(BACKGROUND_COLOR_2);
        g.fillRect(0, 0, width, height);

        // draw shapes
        for (RenderShape shape : _shapes){
            shape.paint(g);
        }


        g.setColor(Color.ORANGE);
        g.drawString("Prout", 10, 60);
        g.drawString("Dim : "+actualWidth+" | "+actualHeight, 10, 100);
    }

    /** Close the game render */
    public void close() {

    }

    public void addShape(RenderShape shape){
        _shapes.add(shape);
    }

}