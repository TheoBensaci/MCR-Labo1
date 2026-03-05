package ch.heig.shapes;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.renderShape.RendererCircle;
import ch.heig.utils.Vector2f;

import java.awt.*;

public abstract class Shape implements Bouncable {
    private Vector2f _position;
    private Vector2f _direction;
    protected Color _color;

    public Shape(int x, int y, Vector2f direction){
        _position=new Vector2f(x,y);
        _direction=direction;
    }

    public float getX(){ return this._position.x; }
    public float getY(){ return this._position.y; }
    public abstract Renderer getRenderShape();
    public Vector2f getPosition(){
        return _position.copy();
    }
    public Vector2f getDirection(){
        return _direction;
    }


    // set
    public void setPosition(float x, float y){
        _position.set(x,y);
    }
    public void setPosition(Vector2f position){
        _position.set(position);
    }
    public void setX(float x){
        setPosition(x,getY());
    }
    public void setY(float y){
        setPosition(getX(),y);
    }

    public void setDirection(float x, float y){
        _direction.set(x,y);
    }
    public void setDirection(Vector2f direction){
        _direction.set(direction);
    }

    public abstract Vector2f getBounceVector();

    // update
    @Override
    public void move(){
        // ...
        Vector2f nextPos=getPosition().add(getDirection());
        // get bounce
        Vector2f dir = getDirection();


        Vector2f bounceNormalVec = getBounceVector().normilize();

        if(!bounceNormalVec.isNull()){
            Vector2f vecDirector = new Vector2f(-1*bounceNormalVec.y,bounceNormalVec.x);
            float scaleY=bounceNormalVec.dot(dir);
            float scaleX=vecDirector.dot(dir);
            Vector2f newDir=bounceNormalVec.mult(-1*scaleY).add(vecDirector.mult(scaleX));
            setDirection(newDir);
            /*
            setDirection(
                    (nextPos.x > Main.WIDTH || nextPos.x<0)?-1f*dir.x:dir.x,
                    (nextPos.y> Main.HEIGHT || nextPos.y<0)?-1f*dir.y:dir.y
            );*/
        }


        setPosition(nextPos);
    }

    @Override
    public Color getColor() {
        return _color;
    }

    @Override
    public void draw() {
        getRenderShape().display(Window.getInstance().getGraphics(), this);
    }

    @Override
    public Shape getShape() {
        return this;
    }
}
