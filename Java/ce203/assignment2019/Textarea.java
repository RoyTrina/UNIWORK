package assignment2019;

import java.awt.*;

public class Textarea {
    Textarea() {

    }

    public static class TextAreaEx1 {
        final Frame jf;
        final TextArea textArea1;
        final TextArea textArea2;
        final TextArea textArea3;
        final TextArea textArea4;

        TextAreaEx1() {
            jf = new Frame("TextArea");

            textArea1 = new TextArea();
            textArea2 = new TextArea(2, 2);
            textArea3 = new TextArea("Third textarea", 10, 10);
            textArea4 = new TextArea("Fourth textarea", 5, 20);


            textArea1.append("First textarea");
            textArea2.append("Second textarea");


            jf.add(textArea1);
            jf.add(textArea2);
            jf.add(textArea3);
            jf.add(textArea4);

            jf.setLayout(new FlowLayout());
            jf.setSize(500, 400);
            jf.setVisible(true);
        }


        public static void main(String[] args) {
            new TextAreaEx1();
        }

    }
}
