//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double SQ = Math.sqrt(3.0) / 6;

   private final int TOPX = 200, TOPY = 20;
   private final int LEFTX = 60, LEFTY = 300;
   private final int RIGHTX = 340, RIGHTY = 300;
   private final int branchingAngle = 45;
   private final double fractionLength = 1.0/8.0;
   private final double length = 100;

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel ()
   {
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (double dLength, int startX, int startY, double angle, Graphics2D g2)
   {
      double angleLeft, angleRight;
      double newLength;
      int xL, yL, xR, yR;
      //g.draw(new Line2D.Double(startX, startY, endX1, endY1));
      if (dLength <= 1)
      {   
         angleLeft = angle + branchingAngle;
         angleRight = angle - branchingAngle;
         newLength = fractionLength * dLength;
         
         xL = (int) (dLength*Math.sin(angleLeft));
         xR = (int) (dLength*Math.sin(angleRight));
         yL = (int) (dLength*Math.cos(angleLeft));
         yR = (int) (dLength*Math.cos(angleRight));
         
         int endX1L = (int)(startX + xL);
         int endY1L = (int)(startY - xL);
         int endX1R = (int)(startX + xR);
         int endY1R = (int)(startY - xR);
         
         g2.drawLine( startX, startY, endX1L, endY1L); 
         g2.drawLine( startX, startY, endX1R, endY1R);
      }
      else
      {
         angleLeft = angle + branchingAngle;
         angleRight = angle - branchingAngle;
         newLength = fractionLength * dLength;
         
         xL = (int) (dLength*Math.sin(angleLeft));
         xR = (int) (dLength*Math.sin(angleRight));
         yL = (int) (dLength*Math.cos(angleLeft));
         yR = (int) (dLength*Math.cos(angleRight));
         
         int endX1L = (int)(startX + xL);
         int endY1L = (int)(startY - xL);
         int endX1R = (int)(startX + xR);
         int endY1R = (int)(startY - xR);
         
         g2.drawLine( startX, startY, endX1L, endY1L); 
         g2.drawLine( startX, startY, endX1R, endY1R); 
         drawFractal (newLength, xL , yL, angleLeft, g2);
         drawFractal (newLength, xR , yR, angleRight , g2);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      Graphics2D g2 = (Graphics2D) page;
      int startx1 = 200;
      int starty1 = 350;
      int endy2 = 250;
      int endx2 = 200;
      
      super.paintComponent ( g2);
      g2.setColor( Color.RED);
      g2.drawLine(startx1, starty1, endx2, endy2); 
      drawFractal( length , endx2, endy2, 90 , g2);
   }

}
