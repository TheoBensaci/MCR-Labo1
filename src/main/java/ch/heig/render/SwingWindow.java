package ch.heig.render;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SwingWindow extends JFrame{
    private RenderCanvas _canvas;
    private Timer _updateTimer=null;
    private final int defaultSize = 800;



    public SwingWindow() {

        _canvas= new RenderCanvas(defaultSize, defaultSize);
        add(_canvas);

        addWindowStateListener(
                e -> {
                    resizeCanavas(getContentPane().getSize().width, getContentPane().getSize().height);
                });

        addComponentListener(
                new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        resizeCanavas(getContentPane().getSize().width, getContentPane().getSize().height);
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {}

                    @Override
                    public void componentShown(ComponentEvent e) {}

                    @Override
                    public void componentHidden(ComponentEvent e) {}
                });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        if(_updateTimer!=null)_updateTimer.stop();
                    }
                });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public RenderCanvas getCanvas(){
        return _canvas;
    }

    /**
     * resize the game canavas to fit new window size
     *
     * @param newWindowWidth new window width
     * @param newWindowHeight new window height
     */
    private void resizeCanavas(int newWindowWidth, int newWindowHeight) {
        _canvas.resizeRender(newWindowWidth, newWindowHeight);
    }

    public void setUpdateTimer(Timer updateTimer){
        this._updateTimer=updateTimer;
    }

}