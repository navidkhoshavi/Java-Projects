/*
 * Rotating.java
 *
 * Created on July 18, 2008, 9:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package shapelibrary;
import java.awt.*;
/**
 *
 * @author ebi
 */
public class Rotating extends ShapeDecoration{
    
    /** Creates a new instance of Rotating */
    public Rotating() {
    }
    
    //*************************
    public Rotating(Shape shape , char axis){
        base = shape;
        teta = 0;
        this.axis = axis;
    }
    //************************************************
    public void updateState(long time){
        base.updateState(time);
        teta = (long)(time/10%360);
        base.rotate(teta , axis);
    }
    //************************************************
    private char axis;
    private long teta;
    
}
