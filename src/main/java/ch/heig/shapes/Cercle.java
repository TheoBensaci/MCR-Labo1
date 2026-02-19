package ch.heig.shapes;

import ch.heig.renderShape.RenderCercle;

import java.awt.*;


public class Cercle extends Shape {
    public Cercle(int size, int x, int y){
        super(size, x, y);
        rs = new RenderCercle(this, Color.blue);
    }
}
