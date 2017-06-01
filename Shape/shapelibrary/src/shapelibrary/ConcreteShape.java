/*
 * ConcreteShape.java
 *
 * Created on July 18, 2008, 6:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package shapelibrary;

import java.awt.Color;

/**
 *
 * @author ebi
 */
public abstract class ConcreteShape extends Shape{
    
    /** Creates a new instance of ConcreteShape */
    public ConcreteShape() {
        this(0,0,new MyPoint(0,0), Color.BLUE);
    }
    //************************
    public ConcreteShape(int h, int w , MyPoint p, Color c){
        setHeight(h);
        setWidth(w);
        setCenter(p);
        setColor(c);
        baseHeight = height;
        baseWidth = width;
    }
    
    //*******************************************************
    public int getHeight(){return height;}
    public void setHeight(int h){height = h;}
    
    //*******************************
    public int getWidth(){return width;}
    public void setWidth(int w){width = w;}
    
    //*******************************
    public MyPoint getCenter(){return center;}
    public void setCenter(MyPoint center) {
        this.center = center;
    }
    //******************************
    public Color getColor(){return color;}
    public void setColor(Color c){color = c;}
    
    //******************************
    public char getAxis(){return axis;}
     public void setAxis(char axis) {
        this.axis = axis;
    }
     
     //****************************
     public long getTeta(){return teta;}
     public void setTeta(long t){teta = t;}
     
    //****************************
    public boolean getShifting(){return shift;}
    public void setShifting(boolean sh){shift = sh;}
    
    //****************************
    public boolean getStartRotate(){return startRotate;}
    public void setStartRotate(boolean sr){startRotate = sr;}
    
    //********************************
    public long getCycle(){return cycle;}
    public void setCycle(long cy){cycle = cy;}
    
    //********************************
    public int getBaseWidth(){return baseWidth;}
    public void setBaseWidth(int w){baseWidth = w;}
    
    //********************************
    public int getBaseHeight(){return baseHeight;}
    public void setBaseHeight(int b){ baseHeight = b;}
    
    //********************************************************
     public void updateState(long time) {
    }
     
    //********************************************************
     public void rotate(long deegres , char axis){
         teta = deegres;
         this.axis = axis;
     }
    //********************************************************
    public void shifting(long time)
     {
         shift = true;
         cycle = ((time / 37))%29;
     }
    //********************************************************
    private MyPoint zRotate(MyPoint p){
         double x,y;
         double cos = Math.cos(Math.toRadians(teta*1.0));
         double sin = Math.sin(Math.toRadians(teta*1.0));
         
         x = (p.getX() - center.getX()) * cos - (p.getY() - center.getY()) * sin;
         y =  (p.getX() - center.getX()) * sin + (p.getY() - center.getY())*cos;
         
         x += center.getX();
         y += center.getY();
         return new MyPoint((int)x , (int)y);
     }
    //********************************************************
    public MyPoint findPreImage(MyPoint p){
         return zRotate(p);
     }
    //********************************************************
    private int height;
    private int width;
    private MyPoint center;
    private Color color;
    private char axis = 'n';
    private long teta = 0;
    private boolean shift = false;
    private boolean startRotate = false;
    private int baseHeight;
    private int baseWidth;
    private long cycle = 0;
}
