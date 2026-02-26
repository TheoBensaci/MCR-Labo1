package ch.heig.render;

import java.awt.*;

public class Window implements Displayer{
    private SwingWind window;


    public Window(String title, int width,int height){
        this.window=new SwingWind(title,width,height);
    }

    public SwingWind getSwingWind(){
        return this.window;
    }


    @Override
    public int getWidth() {
        return this.window.getTargetWidth();
    }

    @Override
    public int getHeight() {
        return this.window.getTargetHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return this.window.getCanavasGraphics2D();
    }

    @Override
    public void repaint() {
        this.window.repaint();
    }

    @Override
    public void setTitle(String title) {
        this.window.setTitle(title);
    }
}
