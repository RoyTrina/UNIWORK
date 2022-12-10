package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter extends JFrame {
    public JLabel text;
    public int numberOfClicks;

    public ClickCounter() {
        setTitle("Click Counter");
        setLayout(new GridLayout(3, 1));
        getContentPane().setPreferredSize(new Dimension(200, 200));
        add(new JPanel());
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me!");
        button.addActionListener(new ButtonListener());
        panel.add(button);
        add(panel);
        panel = new JPanel();
        text = new JLabel();
        panel.add(text);
        add(panel);
        pack();
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberOfClicks++;
            text.setText("You clicked " + numberOfClicks + " times!");
            System.out.println("Hi");
        }
    }

    public static void main(String[] a) {
        new ClickCounter();
    }
}
