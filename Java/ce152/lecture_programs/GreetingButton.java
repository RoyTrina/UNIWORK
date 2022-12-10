package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingButton {

    public static void main(String[] a) {
        JFrame f = new JFrame("Hello World");
        f.setLayout(new GridLayout(3, 1));
        f.getContentPane().setPreferredSize(new Dimension(200, 200));
        JPanel jp = new JPanel(new BorderLayout());
        JButton b = new JButton("Button 1");
        b.addActionListener(new ButtonListener());
        jp.add(b, BorderLayout.CENTER);
        f.add(new JPanel());
        f.add(jp);
        f.pack();
        f.setVisible(true);
    }
}

class ButtonListener implements ActionListener {
    boolean firstTime = true;

    public void actionPerformed(ActionEvent event) {
        System.out.print("Hi");
        if (!firstTime)
            System.out.print(", again");
        else
            firstTime = false;
        System.out.println("!");
    }
}
