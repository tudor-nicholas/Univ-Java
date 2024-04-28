package OOP.lab10;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    private Label lblN1, lblN2, lblResult;
    private TextField txtN1, txtN2, txtResult;
    private Button btnCalculate, btnExit;

    private Checkbox chkAdd, chkSub, chkMul, chkDiv, chkPow;
    private CheckboxGroup cg;

    public Calculator(String title) {
        super(title);
        setLayout(new FlowLayout());

        // Checkbox group
        cg = new CheckboxGroup();
        chkAdd = new Checkbox("Add", true, cg);
        chkSub = new Checkbox("Subtract", false, cg);
        chkMul = new Checkbox("Multiply", false, cg);
        chkDiv = new Checkbox("Divide", false, cg);
        chkPow = new Checkbox("Power", false, cg);

        add(chkAdd);
        add(chkSub);
        add(chkMul);
        add(chkDiv);
        add(chkPow);

        lblN1 = new Label("First number");
        add(lblN1);
        txtN1 = new TextField(10);
        add(txtN1);

        lblN2 = new Label("Second number");
        add(lblN2);
        txtN2 = new TextField(10);
        add(txtN2);

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

        int n1 = 0, n2 = 0, n3 = 0;

        try {
            n1 = Integer.parseInt(txtN1.getText());
        } catch (NumberFormatException ex) {
            txtN1.setText("Format error");
            return;
        }

        try {
            n2 = Integer.parseInt(txtN2.getText());
        } catch (NumberFormatException ex) {
            txtN2.setText("Format error");
            return;
        }

        if (chkAdd.getState())
            n3 = n1 + n2;
        else if (chkSub.getState())
            n3 = n1 - n2;
        else if (chkMul.getState())
            n3 = n1 * n2;
        else if (chkDiv.getState()) {
            if (n2 != 0)
                n3 = n1 / n2;
            else {
                txtResult.setText("Division by zero");
                return;
            }
        } else if (chkPow.getState()) {
            n3 = (int) Math.pow(n1,n2);
        }

        txtResult.setText(String.valueOf(n3));
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator("Calculator");
        calculator.setSize(180, 320);
        calculator.setVisible(true);
    }
}
