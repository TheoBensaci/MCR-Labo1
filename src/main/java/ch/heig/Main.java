package ch.heig;

import ch.heig.render.Window;
import ch.heig.shapes.Bouncable;
import ch.heig.shapes.Circle;
import ch.heig.shapes.Shape;
import ch.heig.shapes.Square;
import ch.heig.utils.Vector2f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Main {

    public final static int UPDATE_RATE=10;
    public final static int WIDTH=800;
    public final static int HEIGHT=800;
    public final static int MIN_SIZE=20;
    public final static int MAX_SIZE=50-MIN_SIZE;

    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    private Window win;


    public Main(){
        win = Window.getInstance();
        win.setTitle("Bouncer");



        // init shapes
        int nbCercle = (int)(Math.random() * 50);
        for (int i = 0; i < nbCercle; ++i){
            Circle c = new Circle(MIN_SIZE+(int)(Math.random() * MAX_SIZE),(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
            win.getCanvas().addShape(c.getRenderShape());
            bouncers.add(c);
        }

        int nbSquare = (int)(Math.random() * 50);
        for (int i = 0; i < nbSquare; ++i){
            int size =MIN_SIZE+(int)(Math.random() * MAX_SIZE);
            Square s = new Square(size,size,(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
            win.getCanvas().addShape(s.getRenderShape());
            bouncers.add(s);
        }
    }

    public void run(){
        Timer timer = new Timer(UPDATE_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                for (Bouncable s : bouncers){
                    s.move();
                    s.draw();
                }

                // repaint
                win.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();

        win.setUpdateTimer(timer);
    }


    public static void main(String[] args) {
        new Main().run();
    }
}