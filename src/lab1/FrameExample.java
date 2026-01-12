package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameExample extends JFrame implements ActionListener {

    JButton button = new JButton("Click me");
    JLabel label = new JLabel();

    public FrameExample(){
        setTitle("Frame Example");
        setSize(500,200);
        setLayout(new FlowLayout());

        button.addActionListener(this);
        add(button);
        add(label);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Click me")){
            label.setText("Button is clicked");
            button.setText("Unclick me");
        }
        else{
            label.setText("");
            button.setText("Click me");
        }

    }
}
