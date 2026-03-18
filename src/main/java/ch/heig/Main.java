/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 13:54 19.02.2026
 *   Description: Main of the app
 */

package ch.heig;

import ch.heig.render.SwingWindow;
import ch.heig.render.Window;
import ch.heig.shapes.*;
import ch.heig.utils.Vector2f;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Main {

    public final static int UPDATE_RATE=20;
    public final static int WIDTH=800;
    public final static int HEIGHT=800;
    public final static int MIN_SIZE=10;
    public final static int MAX_SIZE=20-MIN_SIZE;

    private LinkedList<Bouncable> bouncers = new LinkedList<>();
    private Window win;

    private final int NB_SHAPE = 10;


    public Main(){
        win = Window.getInstance();
        win.setTitle("Bouncer");

        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_E:
                        bouncers = new LinkedList<>();
                        break;
                    case KeyEvent.VK_F:

                        for (int i = 0; i < NB_SHAPE; ++i){
                            Circle c = new Circle(MIN_SIZE+(int)(Math.random()*MAX_SIZE),(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
                            int size = MIN_SIZE+(int)(Math.random()*MAX_SIZE);
                            Square s = new Square(size,size,(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
                            bouncers.add(c);
                            bouncers.add(s);
                        }
                        break;
                    case KeyEvent.VK_B:
                        for (int i = 0; i < NB_SHAPE; ++i){
                            CircleBorder c = new CircleBorder(MIN_SIZE+(int)(Math.random()*MAX_SIZE),(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
                            int size = MIN_SIZE+(int)(Math.random()*MAX_SIZE);
                            SquareBorder s = new SquareBorder(size,size,(int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT),new Vector2f((float)Math.random(),(float) Math.random()).normilize().mult((float)Math.random()*10));
                            bouncers.add(c);
                            bouncers.add(s);
                        }
                        break;
                    case KeyEvent.VK_Q:
                        System.exit(0);
                        break;
                }
            }
        };

        win.addKeyListener(keyAdapter);
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