package calculator;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Calculator");

        init();

        setVisible(true);
    }

    public void init(){


        JTextField jTextField = new JTextField();
        jTextField.setName("EquationTextField");
        jTextField.setBounds(40, 20, 100, 30);
        add(jTextField);

        JButton jButton = new JButton();
        jButton.setName("Solve");
        jButton.setText("Solve");
        jButton.setBounds(40, 60, 100, 30);
        jButton.addActionListener(e->{
            String[] input = jTextField.getText().split("\\+");

            if(input.length==2){
                int a = Integer.parseInt(input[0].strip());
                int b = Integer.parseInt(input[1].strip());
                int sum = a + b;
                String out = a+"+"+b+"="+sum;
                jTextField.setText(out);
            }
        });
        add(jButton);
    }
}
