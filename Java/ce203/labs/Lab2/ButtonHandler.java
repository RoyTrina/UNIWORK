package labs.Lab2;

import labs.Lab2.solutions.lab2_Solution.FilledFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    private final FilledFrame frame;
    private final int size;


    ButtonHandler(labs.Lab2.solutions.lab2_Solution.FilledFrame setFrame, int size) {
        this.frame = setFrame;
        this.size = size;
    }


    public void actionPerformed(ActionEvent e) {

    }

    public int getSize() {
        return size;
    }

    public FilledFrame getFrame() {
        return frame;
    }

}