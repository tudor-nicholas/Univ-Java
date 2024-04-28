package OOP.lab10;
import java.awt.*;
import java.awt.event.*;

public class ComplexCalculator extends Frame implements ActionListener {
    private Label lblN1, lblN1I, lblN2, lblN2I, lblResult;
    private TextField txtN1, txtN1I, txtN2, txtN2I, txtResult;
    private Button btnCalculate, btnExit;

    private Checkbox chkAdd, chkSub, chkMul;
    private CheckboxGroup cg;

    public ComplexCalculator(String title) {
        super(title);
        setLayout(new FlowLayout());

        // Checkbox group
        cg = new CheckboxGroup();
        chkAdd = new Checkbox("Add", true, cg);
        chkSub = new Checkbox("Subtract", false, cg);
        chkMul = new Checkbox("Multiply", false, cg);


        add(chkAdd);
        add(chkSub);
        add(chkMul);


        lblN1 = new Label("First number: Real part:");
        add(lblN1);
        txtN1 = new TextField(10);
        add(txtN1);

        lblN1I = new Label("Imaginary part:");
        add(lblN1I);
        txtN1I = new TextField(10);
        add(txtN1I);

        lblN2 = new Label("Second number: Real part:");
        add(lblN2);
        txtN2 = new TextField(10);
        add(txtN2);

        lblN2I = new Label("Imaginary part:");
        add(lblN2I);
        txtN2I = new TextField(10);
        add(txtN2I);

        lblResult = new Label("Result");
        add(lblResult);

        txtResult = new TextField(10);
        txtResult.setEditable(false); // Read only
        add(txtResult);

        btnCalculate = new Button("Calculate");
        add(btnCalculate);
        btnCalculate.addActionListener(this);

        btnExit = new Button("Exit");
        add(btnExit);
        btnExit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnExit)
            System.exit(0);

        int n1r = 0, n1i = 0, n2r = 0, n2i = 0, n3r = 0, n3i = 0;

        try {
            n1r = Integer.parseInt(txtN1.getText());
        } catch (NumberFormatException ex) {
            txtN1.setText("Format error");
            return;
        }
        try {
            n1i = Integer.parseInt(txtN1I.getText());
        } catch (NumberFormatException ex) {
            txtN1I.setText("Format error");
            return;
        }

        try {
            n2r = Integer.parseInt(txtN2.getText());
        } catch (NumberFormatException ex) {
            txtN2.setText("Format error");
            return;
        }
        try {
            n2i = Integer.parseInt(txtN2I.getText());
        } catch (NumberFormatException ex) {
            txtN2I.setText("Format error");
            return;
        }

        if (chkAdd.getState()) {
            n3r = n1r + n2r;
            n3i = n1i + n2i;
        } else if (chkSub.getState()) {
            n3r = n1r - n2r;
            n3i = n1i - n2i;
        } else if (chkMul.getState()) {
            n3r = n1r * n2r;
            n3i = n1i * n2i;
        }

        txtResult.setText(String.valueOf(n3r) + "," + String.valueOf(n3i));
    }
    public static void main(String[] args) {
        ComplexCalculator calculator = new ComplexCalculator("ComplexCalculator");
        calculator.setSize(170, 400);
        calculator.setVisible(true);
    }
}