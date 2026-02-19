package ch.heig.shapes;

import ch.heig.renderShape.RenderShape;

import java.awt.*;

public abstract class Shape {
    private int x;
    private int y;
    int size;
    RenderShape rs;

    Shape(int size, int x, int y /*,vector*/){
        rs = null;
    }

    public int getX(){ return this.x; }
    public int getY(){ return  this.y; }
    public int getSize(){ return this.size; }
    public RenderShape getRenderShape(){ return this.rs; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
