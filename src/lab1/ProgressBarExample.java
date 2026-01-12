package lab1;

import javax.swing.*;
import java.awt.*;

public class ProgressBarExample extends JFrame {

    JProgressBar pb = new JProgressBar(0, 100);
    JButton button = new JButton("Start Progress Bar");
    public ProgressBarExample(){

        pb.setValue(50);
        add(pb);
        add(button);

        setTitle("Progress Bar Example");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        button.addActionListener(e -> {
            new Thread(() -> {
                int value = 0;
                while (value <= 100) {
                    pb.setValue(value);
                    value += 5;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        });

    }

}
