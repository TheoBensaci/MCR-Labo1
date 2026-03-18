/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:11 19.02.2026
 *   Description: Abstract class use to manage all shape
 */

package ch.heig.shapes;

import java.awt.Color;

import ch.heig.render.Window;
import ch.heig.renderShape.Renderer;
import ch.heig.utils.Vector2f;

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

    /**
     * Get a instance of class (using the Renderer interface) use to represent this shape
     */
    public abstract Renderer getRenderShape();
    public Vector2f getPosition(){
        return _position.copy();
    }
    public Vector2f getDirection(){
        return _direction;
    }


    // set
    public void setPosition(float x, float y){
        setPosition(new Vector2f(x,y));
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

    /**
     * Get the normal of the "bounced" surface, will be (0,0) with there is no surface
     * This function serve a way to compute if the shape as touch the border or not
     * Also vector return is not normalize by design, it's use compute shape positon correction during collision or
     * @return bounce normal vector
     */
    public abstract Vector2f getBounceNormalVector();

    // update
    @Override
    public void move(){
        // get actual dir
        Vector2f dir = getDirection();

        // get bounce normal vec
        Vector2f bounceVec = getBounceNormalVector();
        Vector2f bounceVecNormilize = bounceVec.copy().normilize();

        // if bounce vec is not null => bounce
        if(!bounceVecNormilize.isNull()){

            // corr position if out of bounce
            setPosition(getPosition().sub(bounceVec));

            // get vec director
            Vector2f vecDirector = new Vector2f(-1*bounceVecNormilize.y,bounceVecNormilize.x);

            float scaleY=bounceVecNormilize.dot(dir);
            float scaleX=vecDirector.dot(dir);

            // compute new dir
            Vector2f newDir=bounceVecNormilize.mult(-1*scaleY).add(vecDirector.mult(scaleX));
            setDirection(newDir);
        }

        // move shape
        setPosition(getPosition().add(getDirection()));
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
