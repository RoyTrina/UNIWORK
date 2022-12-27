package labs.Lab2.solutions.lab2_Solution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler1 implements ActionListener { 
   
   final FilledFrame theApp; //variable of type filled frame
   final int size;           //variable of type int to store size used to resize the coloured shape

   ButtonHandler1( FilledFrame app, int newSize) { 
      
      theApp = app; 
      size = newSize;
      System.out.println(theApp.size);
      // set the parameters passed into the constructor to instance variables defined above  
   }

   public void actionPerformed(ActionEvent e) { 
   
         // The action of resizing the coloured shape that is performed when the button is pressed
         // Set the filledframe size to the size you have assigned to your instance variable (in the consstructor)
         // you need to perform a refrash on the frame in order to effectively redraw the resized shape
          
         theApp.size = size;
         theApp.repaint(); 
   }
       
 }