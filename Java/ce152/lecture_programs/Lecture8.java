package lectures_programs;

import javax.swing.*;
import java.awt.*;

public class Lecture8 {
    public static void main(String[] args) {
        helloWorldDemo();
        testFlowLayout();
        testBorderLayout();
        testGridLayout();
    }


    public static void helloWorldDemo() {
        JFrame frame = new JFrame("Hello World");
        frame.getContentPane().setPreferredSize(new Dimension(400, 200));
        JButton button = new JButton("Hello World!");
        frame.add(button, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void testFlowLayout() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        for (int i = 0; i < 10; i++) {
            JButton jb = new JButton("Button " + i);
            frame.add(jb);
        }
        frame.getContentPane().setPreferredSize(new Dimension(300, 200));
        frame.setTitle("FlowLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void testBorderLayout() {
        JFrame frame = new JFrame();
        frame.getContentPane().setPreferredSize(new Dimension(300, 200));
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("Center"), BorderLayout.CENTER);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.setTitle("BorderLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void testGridLayout() {
        JFrame frame = new JFrame();
        frame.getContentPane().setPreferredSize(new Dimension(300, 200));
        frame.setLayout(new GridLayout(3, 4));
        for (int i = 0; i < 12; i++) {
            JButton jb = new JButton("Button " + i);
            frame.add(jb);
        }
        frame.setTitle("GridLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
