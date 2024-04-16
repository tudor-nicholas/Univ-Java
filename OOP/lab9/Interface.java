package OOP.lab9;
import java.awt .*;

public class Interface extends Frame {
    private Label lTitle;
    private Label lName ;
    private TextField txtName;
    private Button b1;
    private Button b2;

    public Interface( String windowTitle ) {
        super(windowTitle);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        lTitle = new Label("Title");
        lName = new Label("Name");
        txtName = new TextField(10);
        b1 = new Button("Save");
        b2 = new Button("Exit");

        add(lTitle);
        add(lName);
        add(txtName);
        add(b1);
        add(b2);

        setSize(240, 100);

        setVisible(true);
    }
    public static void main(String[] args) {
        Interface f = new Interface("Window Title");
    }
}
