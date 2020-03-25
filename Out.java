package shiwuzhou;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Out {

     public static void main (String args[])
        {
             Toolkit t=Toolkit.getDefaultToolkit();
            Dimension s=t.getScreenSize(); 
            EventQueue.invokeLater(() -> {
                JFrame frame = new Main1();
                frame.setBounds(0, 0,(int)s.getWidth(),(int)s.getHeight());
                frame.setTitle("ÒßÇé·À¿Ø");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
             });        
        }
 
}