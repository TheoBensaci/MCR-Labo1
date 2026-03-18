/**
 *   Autheur: Theo Bensaci
 *   Date: 13:59 19.02.2026
 *   Description: class use to wrap the JFram and implement Displayer cleanly 
 */

package ch.heig.render;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

import javax.swing.Timer;

public class Window implements Displayer{

    private SwingWindow _window;
    private static Window instance; //singleton


    private Window(){
        _window=new SwingWindow();
    }


    public static Window getInstance() {
        if (instance == null) {
            instance = new Window(); // instanciation retardée
            instance._window.getCanvas().clearBuffer();
        }
        return instance;
    }


    @Override
    public int getWidth() {
        return _window.getCanvas().getWidth();
    }

    @Override
    public int getHeight() {
        return _window.getCanvas().getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return _window.getCanvas().getBufferGraphics();
    }

    @Override
    public void repaint() {
        _window.repaint();
    }

    @Override
    public void setTitle(String title) {
        _window.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter keyAdapter) {
        _window.addKeyListener(keyAdapter);
    }

    /**
     * Link to the setUpdateTimer of SwingWindow | use to link a timer to the window
     * @param updateTimer
     */
    public void setUpdateTimer(Timer updateTimer){
        _window.setUpdateTimer(updateTimer);
    }
}
