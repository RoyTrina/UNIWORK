package assignment2019;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CE203_2019_Ass1 {
    public static void main (String[] args) {
        JFrame frame = new JFrame();    //Frame setup
        frame.setSize(400, 400);
        frame.setTitle("Assignment 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());    //Panel setup with the layout for the main screen
        JPanel extrapanel = new JPanel(new FlowLayout());   //Panel for the 2nd textarea
        JPanel colourpanel = new JPanel(new FlowLayout());  //Panel for the font colour

        JButton Add_word = new JButton(" Add word ");   //Button for adding a word to the list
        JButton display = new JButton(" Display ");     //Button for displaying the list with matching criteria
        JButton remove = new JButton(" Remove ");     //Button for removing occurrence from list
        JButton clear = new JButton(" Clear ");    //Button for clearing the list

        JTextField text = new JTextField(25);     //Textarea setup
        text.setEditable(true);                                     //Textarea is made editable

        JTextArea field = new JTextArea(10,20);     //Textarea for printing results in the display button
        field.setEditable(false);                                  //Textarea is set to not editable

        JTextArea R = new JTextArea(1,1);           //Textarea for the Red value
        JTextArea G = new JTextArea(1,1);           //Textarea for the Green value
        JTextArea B = new JTextArea(1,1);           //Textarea for the Blue value


        ArrayList<String> trial = new ArrayList<>();        //Arraylist initialisation
        trial.add("Roma");
        trial.add("Italia");
        trial.add("Napoli");
        trial.add("Sorrento");
        trial.add("Mangiare");

        panel.add(Add_word);    //Adding buttons to the panel
        panel.add(display);
        panel.add(remove);
        panel.add(clear);
        extrapanel.add(field);      //adding the textareas to the panel
        colourpanel.add(text);
        colourpanel.add(R);
        colourpanel.add(G);
        colourpanel.add(B);


        frame.add(panel, BorderLayout.NORTH);   //Adding the 1st panel to the frame at the top
        frame.add(extrapanel, BorderLayout.CENTER);  //Adding the 2nd panel to the frame at the bottom
        frame.add(colourpanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        Add_word.addActionListener(new ActionListener() {               //Actionlistener for add word
            @Override
            public void actionPerformed(ActionEvent e) {
                String read_word = text.getText();
                trial.add(read_word);
                JOptionPane.showMessageDialog(null, "The word " + read_word + " has been added to the list ");
                field.setForeground(fontcolour(R.getText(),G.getText(),B.getText()));
            }


        });

        display.addActionListener(new ActionListener() {            //Actionlistener for display
            @Override
            public void actionPerformed(ActionEvent e) {
                String read_word = text.getText();
                int check = 0;
                field.setText(null);
                for (String value : trial) {
                    if (String.valueOf(value.charAt(value.length() - 1)).equals(read_word)) {
                        field.append(value + "\n");
                    }
                    else {
                        check += 1;
                    }
                }
                field.setForeground(fontcolour(R.getText(),G.getText(),B.getText()));
            }
        });


        remove.addActionListener(new ActionListener() {             //Actionlistener for remove
            @Override
            public void actionPerformed(ActionEvent e) {
                String read_word = text.getText();
                for (String value : trial) {
                    if (String.valueOf(value.charAt(value.length() - 1)).equals(read_word)) {
                        trial.remove(read_word);
                        JOptionPane.showMessageDialog(null, "The word " + read_word + " has been removed from the list. ");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "The criteria has not been matched. ");
                    }
                }
                field.setForeground(fontcolour(R.getText(),G.getText(),B.getText()));
            }
        });


        clear.addActionListener(new ActionListener() {              ////Actionlistener for clear
            @Override
            public void actionPerformed(ActionEvent e) {
                trial.clear();
                JOptionPane.showMessageDialog(null, "The list " + trial + " has been cleared. ");
                field.setForeground(fontcolour(R.getText(),G.getText(),B.getText()));
            }
        });


        }
    public static Color fontcolour(String Redtint, String Greentint, String Bluetint) {
        try{
            Integer red = Integer.valueOf(Redtint);
            Integer green = Integer.valueOf(Greentint);
            Integer blue = Integer.valueOf(Bluetint);
            return new Color(red, green, blue);
        }
        catch(NumberFormatException e){
            return Color.black;
        }


    }
    }
