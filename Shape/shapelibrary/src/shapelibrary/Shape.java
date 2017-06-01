/*
 * Shape.java
 *
 * Created on July 18, 2008, 6:25 PM
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
public abstract class Shape {
    
    /** Creates a new instance of Shape */
    public Shape() {
    }
    protected abstract MyPoint getCenter();
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Color getColor();
    protected abstract char getAxis();
    protected abstract boolean isPointInside(MyPoint p);
    public abstract void rotate(long teta , char axis);
    public abstract void updateState(long time);
    public abstract MyPoint findPreImage(MyPoint p);
    public abstract void shifting(long time);
    //*********************************************************
    public void drawMe(Graphics g)
     {
          MyPoint temp = new MyPoint();
          
          for(int i = 1 ; i<= getWidth() ; i++){
              temp.setX(getCenter().getX()-(getWidth()/2)+i);
              for(int j = 1; j <= getHeight() ; j++)
              {
                  temp.setY(getCenter().getY()-(getHeight()/2)+j);
                  if(isPointInside((getAxis() != 'n' ? findPreImage(temp) : temp))){
                      g.setColor(getColor());
                      g.drawLine(temp.getX(),temp.getY(),temp.getX(),temp.getY());
                  }
              }
          }
     }
    //***************************************************************
    
}
