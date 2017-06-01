/*
 * Rectangle.java
 *
 * Created on July 18, 2008, 8:01 PM
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
public class Rectangle extends ConcreteShape{
    
    /** Creates a new instance of Rectangle */
    public Rectangle(){
         this(0, 0, new MyPoint(0,0), Color.BLUE);
    }
    
    //*************************
    public  Rectangle(int h, int w, MyPoint p, Color c){
        super(h,w,p,c);
       //**********ezafe 
        MyPoint help = new MyPoint();
        help.setXY(super.getCenter().getX()-(super.getBaseWidth()/2) , super.getCenter().getY()-(super.getBaseHeight()/2) );
         
        super.setWidth(help.calcDistance(new MyPoint(help.getX()+super.getWidth() , help.getY()+super.getHeight()))+6);
        super.setHeight(super.getWidth()) ;
        //***********ezafe
    }
    
    //********************************************************************
    public boolean isPointInside(MyPoint p){
        boolean result = false;
        
        if(((long)((p.getX() + p.getY()) % 29) == super.getCycle()) && super.getShifting())
            return false;
            
        result = (p.getX()>=(super.getCenter().getX()-super.getBaseWidth()/2) && p.getX() <= (super.getCenter().getX()+super.getBaseWidth()/2) && p.getY() >= (super.getCenter().getY()-super.getBaseHeight()/2) && p.getY() <= (super.getCenter().getY()+super.getBaseHeight()/2));
        return result;
    }
    
}
