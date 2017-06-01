/*
 * MyPoint.java
 *
 * Created on April 20, 2008, 1:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package shapelibrary;

public class MyPoint {
	private int x;
	private int y;
	
	//Defult Constructot
	public MyPoint()
	{
		x=0;
		y=0;
	}

	//Standard Constructor
	public MyPoint(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//Copy Constructor
	public MyPoint(MyPoint p)
	{
		x=p.x;
		y=p.y;
	}
	
	//
	public static MyPoint add(MyPoint p,MyPoint q)
	{
		p.x=p.x+q.x;
		p.y=p.y+q.y;
		return p;
	}
	
	//Accessor
	public int getX()
	{
		return x;
	}
	
	//Accessor
	public int getY()
	{
		return y;
	}
        //setter
        public void setX(int x){
            this.x = x;
        }
        //settre
         public void setY(int y){
            this.y = y;
        }
         
        public void setXY(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        
       public int calcDistance(MyPoint p)
	{
		return (int)(Math.sqrt((Math.pow((double)x-p.x,2)+Math.pow((double)y-p.y,2))));
	}

   
    
}




