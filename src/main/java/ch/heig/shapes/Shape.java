package ch.heig.shapes;

import ch.heig.Main;
import ch.heig.render.Window;
import ch.heig.renderShape.RenderShape;
import ch.heig.utils.Vector2f;

import javax.swing.text.Position;
import java.awt.*;

public abstract class Shape {
    private Vector2f _position;
    private Vector2f _direction;
    public Shape(int x, int y, Vector2f direction){
        _position=new Vector2f(x,y);
        _direction=direction;
    }

    public float getX(){ return this._position.x; }
    public float getY(){ return this._position.y; }
    public abstract RenderShape getRenderShape();
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

    // update

    public void update(){
        // ...
        Vector2f nextPos=getPosition().add(getDirection());
        // get bounce
        Vector2f dir = getDirection();
        setDirection(
                (nextPos.x > Main.WIDTH || nextPos.x<0)?-1f*dir.x:dir.x,
                (nextPos.y> Main.HEIGHT || nextPos.y<0)?-1f*dir.y:dir.y
        );

        setPosition(nextPos);
    }
}
