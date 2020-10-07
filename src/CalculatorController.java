import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

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
                }
                System.out.println(e.getActionCommand()+" button pressed");
                theView.setoutput(theView.getoutput()+e.getActionCommand());
            }


            /*
            TODO:

            have each button pressed change the currentDisplay AKA the textfield on top
            I'm not sure how to get what buttons is pressed from variable e
             */


            //theView.currentDisplay =
        }
    }

    class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed");
            System.out.println(e);

            /*

            To be deleted ==========================

            int firstNumber, secondNumber = 0;
            String op;

            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered

            try{

                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                op = theView.getOp();
                if (op=="+")
                {
                    theModel.addTwoNumbers(firstNumber, secondNumber);
                }
                else if(op=="-")
                {
                    theModel.subTwoNumbers(firstNumber, secondNumber);
                }
                else if(op=="*")
                {
                    theModel.mulTwoNumbers(firstNumber, secondNumber);
                }

                else if(op=="/")
                {
                    theModel.divTwoNumbers(firstNumber, secondNumber);
                }
                theView.setCalcSolution(theModel.getCalculationValue());

            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("You Need to Enter 2 Integers");

            }
            */

        }

    }

}