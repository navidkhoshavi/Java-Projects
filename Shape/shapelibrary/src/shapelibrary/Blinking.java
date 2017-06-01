/*
 * Blinking.java
 *
 * Created on July 18, 2008, 8:50 PM
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
public class Blinking extends ShapeDecoration{
    
    /** Creates a new instance of Blinking */
    public Blinking() {
    }
    
    //**********************
    public Blinking(Shape shape){
        base = shape;
        color = base.getColor();
    }
    
    //**********************************************
    public Color getColor(){
        return color;
    }
    
    //**********************************************
    public void updateState(long time){
        base.updateState(time);
        color = (time % 2000 < 1000 ? Color.BLACK : base.getColor() );
    }
    //**********************************************
    private Color color;
    
}
