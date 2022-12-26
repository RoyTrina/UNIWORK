package assignment2019;

import javax.swing.*;
import java.awt.*;

public class style {
    public static class BorderLayoutEx {
        public static void main(String... ar) {
            SwingUtilities.invokeLater(A::new);

        }
        //Closing the main method
    }//Closing the class A


    static class A {
        JTextArea textArea;
        final JButton button1;
        final JButton button2;
        final JButton button3;
        final JButton button4;
        final JFrame jf;
        final JPanel jp;


        A() {
            jf = new JFrame("BorderLayout Example");
            jp = new JPanel();

            button1 = new JButton("North");
            button2 = new JButton("South");
            button3 = new JButton("East");
            button4 = new JButton("West");


            textArea = new JTextArea(4, 4);
            //calling TextField (int row, int columns)


            //Setting the positioning of the components in container, JPanel, to BorderLayout
            jp.setLayout(new BorderLayout());

            jp.add(button1, BorderLayout.NORTH);
            //Adding button1, to the NORTH, top side
            jp.add(button2, BorderLayout.SOUTH);
            //Adding button2, to the SOUTH, bottom side
            jp.add(button3, BorderLayout.EAST);
            //Adding button3, to the EAST, far right side
            jp.add(button4, BorderLayout.WEST);
            //Adding button4, to the North, far left side
            jp.add(textArea, BorderLayout.CENTER);
            //Adding textarea, to the CENTER


            jf.add(jp);

            jf.setSize(320, 200);
            jf.setVisible(true);
        }

    }
}
 
