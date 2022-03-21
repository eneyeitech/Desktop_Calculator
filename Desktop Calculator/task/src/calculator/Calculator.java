package calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    private JTextField jTextField;
    public void init(){
        // create a object of class


        jTextField = new JTextField();
        jTextField.setName("EquationTextField");
        jTextField.setBounds(40, 20, 100, 30);
        //add(jTextField);
        // I find it easier to create a panel and SET it as the content pane
        JPanel gui = new JPanel(new BorderLayout(5,5));
        // add some padding to the main GUI
        gui.setBorder(new EmptyBorder(4,4,4,4));

        // not needed if only a single compoinent is to be added!
        //JPanel panelScreen = new JPanel(new GridLayout(0,1));

        // add some constraints to make the output field bigger.
        // if it is intended to be single line, a JTextField should be used.

        gui.add(jTextField, BorderLayout.NORTH);
        //panelScreen.add(screen);

        setContentPane(gui);

        // Action Listener
        ListenForButton listenForButton = new ListenForButton();

        // add padding around the buttons
        JPanel panelButtons = new JPanel(new GridLayout(3,3,4,4));

        JButton oneButton = new JButton("1");
        oneButton.setName("One");
        panelButtons.add(oneButton);
        oneButton.addActionListener(listenForButton);

        JButton twoButton = new JButton("2");
        twoButton.setName("Two");
        panelButtons.add(twoButton);
        twoButton.addActionListener(listenForButton);

        JButton threeButton = new JButton("3");
        threeButton.setName("Three");
        panelButtons.add(threeButton);
        threeButton.addActionListener(listenForButton);

        JButton fourButton = new JButton("4");
        fourButton.setName("Four");
        panelButtons.add(fourButton);
        fourButton.addActionListener(listenForButton);

        JButton fiveButton = new JButton("5");
        fiveButton.setName("Five");
        panelButtons.add(fiveButton);
        fiveButton.addActionListener(listenForButton);

        JButton sixButton = new JButton("6");
        sixButton.setName("Six");
        panelButtons.add(sixButton);
        sixButton.addActionListener(listenForButton);

        JButton sevenButton = new JButton("7");
        sevenButton.setName("Seven");
        panelButtons.add(sevenButton);
        sevenButton.addActionListener(listenForButton);

        JButton eightButton = new JButton("8");
        eightButton.setName("Eight");
        panelButtons.add(eightButton);
        eightButton.addActionListener(listenForButton);

        JButton nineButton = new JButton("9");
        nineButton.setName("Nine");
        panelButtons.add(nineButton);
        nineButton.addActionListener(listenForButton);

        JButton zeroButton = new JButton("0");
        zeroButton.setName("Zero");
        panelButtons.add(zeroButton);
        zeroButton.addActionListener(listenForButton);

        JButton addButton = new JButton("+");
        addButton.setName("Add");
        panelButtons.add(addButton);
        addButton.addActionListener(listenForButton);

        JButton subtractButton = new JButton("-");
        subtractButton.setName("Subtract");
        panelButtons.add(subtractButton);
        subtractButton.addActionListener(listenForButton);

        JButton divideButton = new JButton("/");
        divideButton.setName("Divide");
        panelButtons.add(divideButton);
        divideButton.addActionListener(listenForButton);

        JButton multiplyButton = new JButton("x");
        multiplyButton.setName("Multiply");
        panelButtons.add(multiplyButton);
        multiplyButton.addActionListener(listenForButton);

        JButton equalsButton = new JButton("=");
        equalsButton.setName("Equals");
        panelButtons.add(equalsButton);
        equalsButton.addActionListener(listenForButton);



        //frame.getContentPane().add(new JSeparator(), BorderLayout.CENTER);

        // Add the buttons to the CENTER and they will
        // fill whatever space they are provided.
        gui.add(panelButtons, BorderLayout.CENTER);
        //frame.setBounds(50, 50, 500, 500);
        //frame.setResizable(false);

    }

    private int result = 0;
    private boolean flag=false;
    private String out = "%s%s%s=%s";
    private String tempValue = "";
    private Integer[] nn = new Integer[2];
    private String operator = "";

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String value = e.getActionCommand();

            if(value != "=") {
                try {
                    Integer.parseInt(value);
                    tempValue += value;

                } catch (NumberFormatException err){
                    operator = value;
                    /**if (flag){
                        nn[1] = Integer.parseInt(tempValue);
                        tempValue = "";
                    } else {
                        nn[0] = Integer.parseInt(tempValue);
                        flag=!flag;
                        tempValue = "";
                    }*/
                    nn[0] = Integer.parseInt(tempValue);
                    tempValue = "";
                } finally {
                    jTextField.setText(value);

                }

            } else {
                nn[1] = Integer.parseInt(tempValue);
                tempValue = "";
                int a = nn[0];
                int b = nn[1];
                if(true){
                    if(operator=="+"){
                        result =a+b;
                        jTextField.setText(String.format(out,a,operator,b,result));
                    }
                    if(operator=="-"){
                        result = a-b;
                        jTextField.setText(String.format(out,a,operator,b,result));
                    }
                    if(operator=="x"){
                        result = a*b;
                        jTextField.setText(String.format(out,a,operator,b,result));
                    }
                    if(operator=="/"){
                        result = a/b;
                        jTextField.setText(String.format(out,a,operator,b,result));
                    }
                    flag = false;
                } else {

                }

            }

        }
    }
}
