package OOP.lab12;

import java.awt.*;
import java.awt.event.*;

class MyWindow extends Frame implements ActionListener {
    private MenuBar mb = new MenuBar();
    private Menu o1 = new Menu("Option 1");
    private Menu o2 = new Menu("Option 2");
    private Menu o3 = new Menu("Option 3");
    private MenuItem o11 = new MenuItem("Option 1.1");
    private MenuItem o12 = new MenuItem("Option 1.2");
    private Menu o13 = new Menu("Option 1.3");
    private MenuItem exit = new MenuItem("Exit");
    private MenuItem o21 = new MenuItem("Option 2.1");
    private MenuItem o22 = new MenuItem("Option 2.2");
    private MenuItem o31 = new MenuItem("Option 3.1");
    private MenuItem o32 = new MenuItem("Option 3.2");
    private MenuItem o131 = new MenuItem("Option 1.3.1");
    private MenuItem o132 = new MenuItem("Option 1.3.2");
    private MenuItem o133 = new MenuItem("Option 1.3.3");
    private TextField txtMessage = new TextField(20);

    public MyWindow(String title) {
        super(title);
        setLayout(new BorderLayout());

        mb.add(o1);
        mb.add(o2);
        mb.add(o3);
        o1.add(o11);
        o1.add(o12);
        o1.add(o13);
        o1.addSeparator();
        o1.add(exit);
        o2.add(o21);
        o2.add(o22);
        o3.add(o31);
        o3.add(o32);
        o13.add(o131);
        o13.add(o132);
        o13.add(o133);
        setMenuBar(mb);

        add(txtMessage, BorderLayout.SOUTH);

        o11.addActionListener(this);
        o12.addActionListener(this);
        o131.addActionListener(this);
        o132.addActionListener(this);
        o133.addActionListener(this);
        o21.addActionListener(this);
        o31.addActionListener(this);
        exit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Exit"))
            System.exit(0);
        txtMessage.setText(command + " selected");
    }
}

public class MBar {
    public static void main(String[] args) {
        Frame f = new MyWindow("Event handling");
        f.pack();
        f.setBounds(300, 200, 320, 240);
        f.setVisible(true);
    }
}

