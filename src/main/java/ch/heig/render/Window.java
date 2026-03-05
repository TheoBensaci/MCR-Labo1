package ch.heig.render;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

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
        return _window.getWidth();
    }

    @Override
    public int getHeight() {
        return _window.getHeight();
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

    }

    public void setUpdateTimer(Timer updateTimer){
        _window.setUpdateTimer(updateTimer);
    }
}
