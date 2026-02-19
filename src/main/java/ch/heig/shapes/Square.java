package ch.heig.shapes;

import ch.heig.renderShape.RenderSquare;

import java.awt.*;


public class Square extends Shape{
    Square(int size, int x, int y){
        super(size, x, y);
        rs = new RenderSquare(this, Color.yellow);
    }
}
