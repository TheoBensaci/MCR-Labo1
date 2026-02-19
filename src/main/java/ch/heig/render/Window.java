package ch.heig.render;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Window extends JFrame {
    private RenderCanvas _canvas;
    private Timer _updateTimer=null;

    public Window(String title) {
        super(title);

        _canvas= new RenderCanvas();
        add(_canvas);

        // create a empty canvas
        /*
        gameCanvas = new GameRender(this.game);
        add(gameCanvas);
        */

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