package ch.heig;

import ch.heig.render.Window;
import ch.heig.renderShape.RenderShape;
import ch.heig.shapes.Cercle;
import ch.heig.shapes.Shape;
import ch.heig.shapes.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Window win = new Window("Bouncers");

        List<Shape> listShape = new ArrayList<>();

        int nbCercle = (int)(Math.random() * 50);
        for (int i = 0; i < nbCercle; ++i){
            listShape.add(new Cercle((int)(Math.random() * 100), (int)(Math.random() * win.getX()), (int)(Math.random() * win.getY())));
        }

        int nbSquare = (int)(Math.random() * 50);
        for (int i = 0; i < nbSquare; ++i){
            listShape.add(new Square((int)(Math.random() * 100), (int)(Math.random() * win.getX()), (int)(Math.random() * win.getY())));
        }


        // shape update
        while(win.isVisible()){

            // update shape
            for (Shape s : listShape){
                RenderShape renderShape = s.getRenderShape();
                renderShape.paint(win.getGraphics());
            }

            // repaint
            win.repaint();
        }
    }
}