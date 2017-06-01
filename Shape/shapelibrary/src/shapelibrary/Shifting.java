/*
 * Shifting.java
 *
 * Created on July 18, 2008, 9:31 PM
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
public class Shifting extends ShapeDecoration{
    
    /** Creates a new instance of Shifting */
    public Shifting() {
    }
    
    //**************************************
    public Shifting(Shape shape){
        base = shape;
    }
    
    //****************************************************
    public void updateState(long time){
        base.updateState(time);
        base.shifting(time);
    }
    
}
