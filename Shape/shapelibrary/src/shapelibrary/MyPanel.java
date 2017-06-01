/*
 * MyPanel.java
 *
 * Created on July 16, 2008, 1:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package shapelibrary;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;

/**
 *
 * @author ebi
 */
public class MyPanel extends JPanel
  {
       
     public MyPanel()
     {
         //rect = new Rectangle(100,150,new MyPoint(150,150),Color.BLUE);
         //tri = new Triangle(100,100,new MyPoint(250,150),Color.GREEN);
         elp = new Ellipse(200,100,new MyPoint(500,100),Color.MAGENTA);
         sht = new Shifting(elp);
         blink = new Blinking(sht);
         rot = new Rotating(blink , 'z');
         
         //rect2 = new Rectangle(70,100,new MyPoint(700,150),Color.BLACK);
         
     }
     //***********************************************
     public void paintComponent( Graphics g )
     {
        super.paintComponent( g );
        //g.setColor((rect == null ? Color.GREEN : rect.getColor()));
        g.drawRoundRect(100,100,20,20,5,5);
        //rect.drawMe(g);
        rot.drawMe(g);
        /*if(rect != null)
          rect.drawMe(g);
        g.setColor(tri.getColor());
        tri.drawMe(g);
        
        g.setColor(rect2.getColor());
        rect2.drawMe(g);
        
        g.setColor(elp.getColor());
        elp.drawMe(g);*/
        
     }
     //***********************************************
     public void setPixel(Graphics g,Color c,float x , float y){
         this.x = x;
         this.y = y;
         color = c;
         paintComponent( g );  
     }
     //**********************************************************
     //********************My variables**************************
      private float x=0 , y=0;
      private Color color;
      //public Rectangle rect ,rect2;
      Shifting sht;
      Rotating rot;
      //public Triangle tri;
      Blinking blink;
      //public MyPoint temp;
      public Ellipse elp;
}