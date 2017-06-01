/*
 * Triangle.java
 *
 * Created on July 18, 2008, 7:48 PM
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
public class Triangle extends ConcreteShape{
    
    /** Creates a new instance of Triangle */
    public Triangle() {
        this(0,0,new MyPoint(0,0),Color.BLUE);
    }
    
    //******************
    public Triangle(int h, int w, MyPoint p, Color c)
    {
        super(h,w,p,c);
        
        middleUpPoint = new  MyPoint(super.getCenter().getX(),super.getCenter().getY()-(super.getHeight()/2));
        bottomLeftPoint = new  MyPoint(super.getCenter().getX()-(super.getWidth()/2),super.getCenter().getY()+(super.getHeight()/2));
        bottomRightPiont = new  MyPoint(super.getCenter().getX()+(super.getWidth()/2),super.getCenter().getY()+(super.getHeight()/2));
        
        mRightLine = (float)(middleUpPoint.getY()-bottomRightPiont.getY())/(float)(middleUpPoint.getX()-bottomRightPiont.getX());
        mLeftLine = -mRightLine;
        
        bLeftLine = middleUpPoint.getY() - mLeftLine*middleUpPoint.getX();
        bRightLine = middleUpPoint.getY() - mRightLine*middleUpPoint.getX();
        
        //***********ezafe
        MyPoint help = new MyPoint();
        help.setXY(super.getCenter().getX()-(super.getBaseWidth()/2) , super.getCenter().getY()-(super.getBaseHeight()/2) );
         
        super.setWidth(help.calcDistance(new MyPoint(help.getX()+super.getWidth() , help.getY()+super.getHeight())));
        super.setHeight(super.getWidth()) ;
        //***********ezafe   
    }
    
    //**********************************************
    public boolean isPointInside(MyPoint p){
        
        if(((long)((p.getX() + p.getY()) % 29) == super.getCycle()) && super.getShifting())
            return false;
        
        if(p.getY()< middleUpPoint.getY() || p.getY() > bottomLeftPoint.getY())
            return false;
        MyPoint pLeft = new MyPoint(0,0),pRight = new MyPoint(0,0);
        pLeft.setY(p.getY());
        pRight.setY(p.getY());
        
        pLeft.setX((int)((p.getY()-bLeftLine)/(mLeftLine)));
        pRight.setX((int)((p.getY()-bRightLine)/(mRightLine)));
        
        return (p.getX() >= pLeft.getX() && p.getX() <= pRight.getX());
        
    }
    
    //**********************************************
    private MyPoint middleUpPoint;
    private MyPoint bottomLeftPoint;
    private MyPoint bottomRightPiont;
    
    private float mLeftLine=0;
    private float mRightLine=0;
    
    private float bLeftLine=0;
    private float bRightLine=0;
    
}
