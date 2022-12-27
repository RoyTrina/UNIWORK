package labs.Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilledFrame extends JFrame {
    final int size = 400;

    FilledFrame(){
        JButton butSmall = new JButton("Small");
        JButton butMedium = new JButton("Medium");
        JButton butLarge = new JButton("Large");
        JButton butMessage = new JButton("Say Hi!");

        SquarePanel panel = new SquarePanel(this);
        JPanel butPanel = new JPanel();

        butPanel.add(butSmall);
        butPanel.add(butMedium);
        butPanel.add(butLarge);
        butPanel.add(butMessage);
        add(butPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setSize(size+100, size+100);

        butMessage.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hiiiiii");
            }
        });
    }

    public static class SquarePanel extends JPanel{
        FilledFrame theApp;
        public SquarePanel(FilledFrame app){
            theApp = app;
        }

        public SquarePanel() {
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.green);
            g.fillRect(20, 20, theApp.size, theApp.size);
        }
    }
}
