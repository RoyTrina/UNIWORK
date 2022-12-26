package assignment2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Form extends JFrame {

    final JPanel pnl = new JPanel();
    final JPanel pnl1 = new JPanel();
    final JPanel pnl2 = new JPanel();
    final JLabel f_name = new JLabel("First name: ");
    final JLabel l_name = new JLabel("Last name: ");
    final JLabel contact = new JLabel("Contact number: ");
    final JLabel email = new JLabel("Email address: ");
    final JLabel address = new JLabel("Address: ");
    final JLabel num_psns = new JLabel("Number of persons: ");
    final JTextField f_nameField = new JTextField(25);
    final JTextField l_nameField = new JTextField(25);
    final JTextField contactField = new JTextField(25);
    final JTextField emailField = new JTextField(25);
    final JTextArea txt_add = new JTextArea(5, 25);
    final JButton submit = new JButton("Submit");

    final SpinnerModel sm = new SpinnerNumberModel(1, 0, 30, 1);
    final JSpinner spinner = new JSpinner(sm);

    public Form() {

        this.setTitle("Reservation Form");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Border border = new CompoundBorder(
                new TitledBorder(null, "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, null),
                new EmptyBorder(10, 10, 10, 10));

        pnl.setBorder(border);
        getContentPane().add(pnl, gbc);

        pnl.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //first column of the grid//
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;

        pnl.add(f_name, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        pnl.add(l_name, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        pnl.add(contact, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        pnl.add(email, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        pnl.add(address, gc);

        //second column//
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 0;
        pnl.add(f_nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        pnl.add(l_nameField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        pnl.add(contactField, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        pnl.add(emailField, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        pnl.add(txt_add, gc);

        //second Titled Border//
        pnl1.setBorder(BorderFactory.createTitledBorder(null, "Booking Details", TitledBorder.CENTER, TitledBorder.CENTER));

        add(pnl1, gbc);

        pnl1.setLayout(new GridBagLayout());
        GridBagConstraints gc1 = new GridBagConstraints();

        //first column//
        gc1.weightx = 0.5;
        gc1.weighty = 0.5;

        gc1.gridx = 0;
        gc1.gridy = 0;

        pnl1.add(num_psns, gc1);

        gc1.anchor = GridBagConstraints.WEST;
        gc1.gridx = 1;
        gc1.gridy = 0;
        pnl1.add(spinner, gc1);

        //third titled border
        pnl2.setBorder(BorderFactory.createTitledBorder(null, "Submit", TitledBorder.CENTER, TitledBorder.CENTER));
        pnl2.add(submit);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            Form frame = new Form();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
