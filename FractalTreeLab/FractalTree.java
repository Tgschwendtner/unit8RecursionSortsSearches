//********************************************************************
//  KochSnowflakeViewer.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of recursion.
//  @gcschmit (19 July 2014): converted from an applet to an application
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FractalTree extends JPanel
{
    private final int WIDTH = 400;
    private final int HEIGHT = 500;

    private final int MIN = 1, MAX = 9;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private TreePanel drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        FractalTree viewer = new FractalTree();
    }

    public FractalTree()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("Fractal Tree");
        titleLabel.setForeground (Color.black);
        drawing = new TreePanel();
        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractak Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
        
    }
}
