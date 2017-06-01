/*
 * ShapeDecoration.java
 *
 * Created on July 18, 2008, 8:34 PM
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
public abstract class ShapeDecoration extends Shape{
    
    /** Creates a new instance of ShapeDecoration */
    public ShapeDecoration() {
    }
    
    //************************
    public ShapeDecoration(Shape base){
        this.base = base;
    }
    
    //**************************************************
    protected MyPoint getCenter(){
        return base.getCenter();
    }
    
    //**************************
    protected int getWidth() {
        return base.getWidth();
    }
    
    //**************************
    protected int getHeight(){
        return base.getHeight();
    }
    //**************************
    protected Color getColor(){
        return base.getColor();
    }
    
    //**************************************************
    public void rotate(long teta , char axis){
        base.rotate(teta , axis);
    }
    //**************************************************
    public  void shifting(long time){
        base.shifting(time);
    }
    
    //**************************************************
    public MyPoint findPreImage(MyPoint p){
        return base.findPreImage(p);
    }
    
    //**************************************************
    public char getAxis(){
        return base.getAxis();
    }
    
   //**********************************************
    protected boolean isPointInside(MyPoint p){
        return base.isPointInside(p);
    }
    
    //**************************************************
    protected Shape base;
}
