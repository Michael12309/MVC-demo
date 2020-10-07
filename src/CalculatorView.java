// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CalculatorView {

    final private int WIDTH = 300;
    final private int HEIGHT = (int) (WIDTH * 1.5);

    /* all calculator buttons ======================= */
    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");

    private JButton divide = new JButton("÷");
    private JButton multiply = new JButton("×");
    private JButton add = new JButton("+");
    private JButton subtract = new JButton("-");
    private JButton equals = new JButton("=");
    private JButton point = new JButton(".");
    private JButton clear = new JButton("C");

    private JTextField answer = new JTextField();

    /* calculator variables ======================= */
    public String currentDisplay;


    CalculatorView(){

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container calcPane = frame.getContentPane();
        calcPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Sets up the view and adds the components

        /*
        Information on how to use GridBagLayout can be found here:
        https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        */
        calcPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        calcPane.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        answer.setEnabled(false);
        calcPane.add(answer, c);
        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 1;
        seven.setMnemonic(KeyEvent.VK_7);   // 7 key
        calcPane.add(seven, c);

        c.gridx = 1;
        c.gridy = 1;
        eight.setMnemonic(KeyEvent.VK_8);   // 8 key
        calcPane.add(eight, c);

        c.gridx = 2;
        c.gridy = 1;
        nine.setMnemonic(KeyEvent.VK_9);   // 9 key
        calcPane.add(nine, c);

        c.gridx = 3;
        c.gridy = 1;
        divide.setMnemonic(KeyEvent.VK_SLASH);   // / key
        calcPane.add(divide, c);

        c.gridx = 0;
        c.gridy = 2;
        four.setMnemonic(KeyEvent.VK_4);   // 4 key
        calcPane.add(four, c);

        c.gridx = 1;
        c.gridy = 2;
        five.setMnemonic(KeyEvent.VK_5);   // 5 key
        calcPane.add(five, c);

        c.gridx = 2;
        c.gridy = 2;
        six.setMnemonic(KeyEvent.VK_6);   // 6 key
        calcPane.add(six, c);

        c.gridx = 3;
        c.gridy = 2;
        calcPane.add(multiply, c);

        c.gridx = 0;
        c.gridy = 3;
        one.setMnemonic(KeyEvent.VK_1);   // 1 key
        calcPane.add(one, c);

        c.gridx = 1;
        c.gridy = 3;
        two.setMnemonic(KeyEvent.VK_2);   // 2 key
        calcPane.add(two, c);

        c.gridx = 2;
        c.gridy = 3;
        three.setMnemonic(KeyEvent.VK_3);   // 3 key
        calcPane.add(three, c);

        c.gridx = 3;
        c.gridy = 3;
        add.setMnemonic(KeyEvent.VK_ADD);   // + key
        calcPane.add(add, c);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        zero.setMnemonic(KeyEvent.VK_0);   // 0 key
        calcPane.add(zero, c);
        c.gridwidth = 1;

        c.gridx = 2;
        c.gridy = 4;
        point.setMnemonic(KeyEvent.VK_PERIOD);   // . key
        calcPane.add(point, c);

        c.gridx = 3;
        c.gridy = 4;
        subtract.setMnemonic(KeyEvent.VK_SUBTRACT);   // - key
        calcPane.add(subtract, c);
        c.gridwidth = 4;

        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 5;
        equals.setMnemonic(KeyEvent.VK_EQUALS);   // = key
        calcPane.add(equals, c);

        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 5;
        equals.setMnemonic(KeyEvent.VK_CLEAR);   // C key
        calcPane.add(clear, c);

        // End of setting up the components --------

        frame.pack();
        frame.setVisible(true);

    }

    public String getoutput(){

        return answer.getText();

    }
    public void setoutput(String output){

        answer.setText(output);

    }

    public void addButtonListeners(ActionListener listener) {
        one.addActionListener(listener);
        two.addActionListener(listener);
        three.addActionListener(listener);
        four.addActionListener(listener);
        five.addActionListener(listener);
        six.addActionListener(listener);
        seven.addActionListener(listener);
        eight.addActionListener(listener);
        nine.addActionListener(listener);
        zero.addActionListener(listener);

        divide.addActionListener(listener);
        multiply.addActionListener(listener);
        add.addActionListener(listener);
        subtract.addActionListener(listener);
        point.addActionListener(listener);
        clear.addActionListener(listener);


    }

    // If the calculateButton is clicked execute a method
    // in the Controller named actionPerformed

    void CalculateListener(ActionListener listenForCalcButton){

        equals.addActionListener(listenForCalcButton);

    }

    // Open a popup that contains the error message passed

    void displayErrorMessage(String errorMessage){

        //JOptionPane.showMessageDialog(this, errorMessage);

    }

}