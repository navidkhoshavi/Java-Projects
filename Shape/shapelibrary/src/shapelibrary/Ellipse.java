/*
 * Ellipse.java
 *
 * Created on July 18, 2008, 7:17 PM
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
public class Ellipse extends ConcreteShape{
    
    /** Creates a new instance of Ellipse */
    public Ellipse() {
        this(0,0,new MyPoint(0,0),Color.BLUE);
    }
    
    public Ellipse(int h, int w, MyPoint p, Color c){
        super(h,w,p,c);
        
        rBottom = new  MyPoint(super.getCenter().getX()+(super.getWidth()/2),super.getCenter().getY()+(super.getHeight()/2));
        lTop = new MyPoint(super.getCenter().getX()-(super.getWidth()/2),super.getCenter().getY()-(super.getHeight()/2));
        
        //***********ezafe
        MyPoint help = new MyPoint();
        help.setXY(super.getCenter().getX()-(super.getBaseWidth()/2) , super.getCenter().getY()-(super.getBaseHeight()/2) );
         
        super.setWidth(help.calcDistance(new MyPoint(help.getX()+super.getWidth() , help.getY()+super.getHeight()))+6);
        super.setHeight(super.getWidth()) ;
        //***********ezafe
    }
    
    
    //***********************************************
    public boolean isPointInside(MyPoint p){
        double r1,r2;
	double dx,dy;
	double result;
        
        if(((long)((p.getX() + p.getY()) % 29) == super.getCycle()) && super.getShifting())
            return false;

	dx = 1.0* (p.getX() - super.getCenter().getX());
	dy = 1.0* (p.getY() - super.getCenter().getY());
	r1 = (Math.abs(1.0*(lTop.getX() - rBottom.getX()))/2);
	r2 = (Math.abs(1.0*(lTop.getY() - rBottom.getY()))/2);
        
        r1 = r1 - (r1 >= 8 ? 5 :0);
        r2 = r2 - (r2 >= 8 ? 5 :0);
		
	result= (Math.pow((dx/r1),2)) + Math.pow((dy/r2),2);

	if ((int)((result*10))<=10)
	    return true;
	else
	    return false;
    }
    
    //***********************************************
    private MyPoint lTop;
    private MyPoint rBottom;
}
