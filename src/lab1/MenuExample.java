package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuExample extends JFrame implements ActionListener {

    private JTextArea textArea = new JTextArea();

    public MenuExample() {
        setTitle("Menu Example");
        setSize(500, 400);

        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(save);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);


        JButton bold = new JButton("Bold");
        JButton italic = new JButton("Italic");
        JToolBar toolBar = new JToolBar();
        toolBar.add(bold);
        toolBar.add(italic);

        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);

        save.addActionListener(e-> JOptionPane.showMessageDialog(this, "Saved Successfully"));
        exit.addActionListener( e-> System.exit(0) );
        bold.addActionListener(this);
        italic.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        if(text.isBlank()){
            JOptionPane.showMessageDialog(this, "Please enter some content first");
            return;
        }
        if(e.getActionCommand().equals("Bold")){
            textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        }else if(e.getActionCommand().equals("Italic")){
            textArea.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        }else {
            JOptionPane.showMessageDialog(null,"No Operation");
        }
    }
}
