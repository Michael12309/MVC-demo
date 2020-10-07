import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;
    private String operation;
    private double firstNumber, secondNumber;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        // Tell the View that when ever the calculate button
        // is clicked to execute the actionPerformed method
        // in the CalculateListener inner class

        this.theView.CalculateListener(new CalculateListener());
        this.theView.addButtonListeners(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="C")
            {
                theView.setoutput("");
            }
            else
            {
                if (e.getActionCommand() == "+" || e.getActionCommand() == "-" || e.getActionCommand() == "×" || e.getActionCommand() == "÷")
                {
                    System.out.println("Do "+e.getActionCommand() +" op");
                    operation=e.getActionCommand();
                    firstNumber=Double.parseDouble(theView.getoutput());
                }
                System.out.println(e.getActionCommand()+" button pressed");
                theView.setoutput(theView.getoutput()+e.getActionCommand());
            }
        }
    }

    class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand()+" button pressed");


            if (operation=="+")
            {
                secondNumber=Double.parseDouble(theView.getoutput().substring(theView.getoutput().indexOf("+")+1,theView.getoutput().length()));
                theModel.addTwoNumbers(firstNumber, secondNumber);
            }
            else if(operation=="-")
            {
                secondNumber=Integer.parseInt(theView.getoutput().substring(theView.getoutput().indexOf("-")+1,theView.getoutput().length()));
                theModel.subTwoNumbers(firstNumber, secondNumber);
            }
            else if(operation=="×")
            {
                secondNumber=Integer.parseInt(theView.getoutput().substring(theView.getoutput().indexOf("×")+1,theView.getoutput().length()));
                theModel.mulTwoNumbers(firstNumber, secondNumber);
            }

            else if(operation=="÷")
            {
                secondNumber=Integer.parseInt(theView.getoutput().substring(theView.getoutput().indexOf("÷")+1,theView.getoutput().length()));
                theModel.divTwoNumbers(firstNumber, secondNumber);
            }
            System.out.println(firstNumber +operation+ secondNumber+"="+theModel.getCalculationValue());
            theView.setoutput(theModel.getCalculationValue());
        }

    }

}