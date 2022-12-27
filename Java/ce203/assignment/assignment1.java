package assignment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class assignment1 {
    public static void main (String[] args) {
        JFrame frame = new JFrame();    //This is the JFrame that I created
        frame.setSize(400, 400);
        frame.setTitle("Assignment 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(new FlowLayout());

        JButton Add_word = new JButton(" Add word ");   //The button for adding a word to the list
        JButton display = new JButton(" Display words matching criteria ");     //the button fro displaying the list with the
        JButton remove = new JButton(" Remove occurrences from list ");
        JButton clear = new JButton(" Clear the list ");
        JTextArea search = new JTextArea(20, 60);

        panel.add(Add_word);
        panel.add(display);
        panel.add(remove);
        panel.add(clear);

        frame.add(panel, FlowLayout.LEFT);

        List<String> trial = new ArrayList<>();
        trial.add("String");
        trial.add("Integer");
        trial.add("Double");
        trial.add("Io sono stanca e voglio andare via da qui!!");


        Add_word.addActionListener(e -> {
            String word = search.getText();
            //char lastletter = word.charAt(word.lastIndexOf(word));

            char[] word_array = new char[word.length()];    //Creating the array of the string length
            for (int i = 0; i < word.length(); i++){
                word_array[i] = word.charAt(i);
                }
                System.out.println(word_array);

            trial.add(word);
            JOptionPane.showMessageDialog(null, "The word " + word + " has been added to the list ");
        });

        display.addActionListener(e -> {
                    //JTextField search2 = new JTextField();
                    //String word = search2.getText();
                    //char lastchar = word.charAt(word.lastIndexOf(word));
                    //word.indexOf();
                    JOptionPane.showMessageDialog(null, "The list " + trial + " has been displayed. ");
        });


        remove.addActionListener(e -> {
            //if (trial )
        });


        clear.addActionListener(e -> {
            trial.clear();
            JOptionPane.showMessageDialog(null, "The list has been cleared.");
        });

    }
}