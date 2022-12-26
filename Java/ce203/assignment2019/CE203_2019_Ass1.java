package assignment2019;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CE203_2019_Ass1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();    //Frame setup
        frame.setSize(400, 400);
        frame.setTitle("Assignment 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());    //Panel setup with the layout for the main screen
        JPanel extra_panel = new JPanel(new FlowLayout());   //Panel for the 2nd textarea
        JPanel colour_panel = new JPanel(new FlowLayout());  //Panel for the font colour

        JButton Add_word = new JButton(" Add word ");   //Button for adding a word to the list
        JButton display = new JButton(" Display ");     //Button for displaying the list with matching criteria
        JButton remove = new JButton(" Remove ");     //Button for removing occurrence from list
        JButton clear = new JButton(" Clear ");    //Button for clearing the list

        JTextField text = new JTextField(25);     //Textarea setup
        text.setEditable(true);                                     //Textarea is made editable

        JTextArea field = new JTextArea(10, 20);     //Textarea for printing results in the display button
        field.setEditable(false);                                  //Textarea is set to not editable

        JTextArea R = new JTextArea(1, 1);           //Textarea for the Red value
        JTextArea G = new JTextArea(1, 1);           //Textarea for the Green value
        JTextArea B = new JTextArea(1, 1);           //Textarea for the Blue value


        ArrayList<String> trial = new ArrayList<>();        //Arraylist initialisation
        trial.add("Roma");
        trial.add("Italian");
        trial.add("Nepali");
        trial.add("Serrano");
        trial.add("Manager");

        panel.add(Add_word);    //Adding buttons to the panel
        panel.add(display);
        panel.add(remove);
        panel.add(clear);
        extra_panel.add(field);      //adding the text areas to the panel
        colour_panel.add(text);
        colour_panel.add(R);
        colour_panel.add(G);
        colour_panel.add(B);


        frame.add(panel, BorderLayout.NORTH);   //Adding the 1st panel to the frame at the top
        frame.add(extra_panel, BorderLayout.CENTER);  //Adding the 2nd panel to the frame at the bottom
        frame.add(colour_panel, BorderLayout.SOUTH);
        frame.setVisible(true);

        //Action listener for add word
        Add_word.addActionListener(e -> {
            String read_word = text.getText();
            trial.add(read_word);
            JOptionPane.showMessageDialog(null, "The word " + read_word + " has been added to the list ");
            field.setForeground(font_colour(R.getText(), G.getText(), B.getText()));
        });

        //Action listener for display
        display.addActionListener(e -> {
            String read_word = text.getText();
            field.setText(null);
            for (String value : trial) {
                if (String.valueOf(value.charAt(value.length() - 1)).equals(read_word)) {
                    field.append(value + "\n");
                }
            }
            field.setForeground(font_colour(R.getText(), G.getText(), B.getText()));
        });


        //Action listener for remove
        remove.addActionListener(e -> {
            String read_word = text.getText();
            for (String value : trial) {
                if (String.valueOf(value.charAt(value.length() - 1)).equals(read_word)) {
                    trial.remove(read_word);
                    JOptionPane.showMessageDialog(null, "The word " + read_word + " has been removed from the list. ");
                } else {
                    JOptionPane.showMessageDialog(null, "The criteria has not been matched. ");
                }
            }
            field.setForeground(font_colour(R.getText(), G.getText(), B.getText()));
        });


        ////Action listener for clear
        clear.addActionListener(e -> {
            trial.clear();
            JOptionPane.showMessageDialog(null, "The list " + trial + " has been cleared. ");
            field.setForeground(font_colour(R.getText(), G.getText(), B.getText()));
        });


    }

    public static Color font_colour(String Redtint, String Greentint, String Bluetint) {
        try {
            int red = Integer.parseInt(Redtint);
            int green = Integer.parseInt(Greentint);
            int blue = Integer.parseInt(Bluetint);
            return new Color(red, green, blue);
        } catch (NumberFormatException e) {
            return Color.black;
        }
    }
}
