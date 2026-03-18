/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 13:59 19.02.2026
 *   Description: JFram use for the render
 */

package ch.heig.render;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SwingWindow extends JFrame{
    private RenderCanvas _canvas;
    private Timer _updateTimer=null;
    private final int defaultSize = 800;



    public SwingWindow() {

        // create canvas and add it to the window
        _canvas= new RenderCanvas(defaultSize, defaultSize);
        add(_canvas);

        // add listener
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

        // pack and make it visible
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

    /**
     * Use to link the a update timer with the window
     * @param updateTimer timer use to update things
     */
    public void setUpdateTimer(Timer updateTimer){
        this._updateTimer=updateTimer;
    }

}