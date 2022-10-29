package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Register {

    //----------------------------------------------------------
    // Class variables
    // Check UML Diagram
    //----------------------------------------------------------
    private static int registerCounter = 0;
    private static final String REGISTERCODE = "US-FL-032020-";
    private static final double DOLLARVALUE = 1.00;
    private static final double QUARTERVALUE = 0.25;
    private static final double DIMEVALUE = 0.10;
    private static final double NICKELVALUE = 0.05;
    private static final double PENNYVALUE = 0.01;

    //----------------------------------------------------------
    // Instant variables
    // Check UML Diagram
    //----------------------------------------------------------
    private String registerID;
    private int numberOfOneDollarBills;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;
    private double currentTotal;

    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------

    public Register(int numberOfOneDollarBills,
                    int numberOfQuarters,
                    int numberOfDimes,
                    int numberOfNickels,
                    int numberOfPennies) {
        registerCounter++;
        registerID = REGISTERCODE + registerCounter;
        currentTotal = 0.0;
        this.numberOfOneDollarBills = numberOfOneDollarBills;
        this.numberOfQuarters = numberOfQuarters;
        this.numberOfDimes = numberOfDimes;
        this.numberOfNickels = numberOfNickels;
        this.numberOfPennies = numberOfPennies;

    }
        //----------------------------------------------------------
        // Utility methods
        // Check UML Diagram
        //----------------------------------------------------------

    private double cashValue(){
        double total = numberOfOneDollarBills * DOLLARVALUE +
                numberOfQuarters * QUARTERVALUE +
                numberOfDimes * DIMEVALUE +
                numberOfNickels * NICKELVALUE +
                numberOfPennies * PENNYVALUE;
        return total;
    }

    public void cashInfo(String personal){

        if(personal == "Manager") {
            System.out.println("==========================");
            System.out.println("Register Cash Info");
            System.out.println("==========================");
            System.out.println("Access Level:\t\t\t Valid" );
            System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
            System.out.printf("Dollars:\t\t\t\t %-15d\n", numberOfOneDollarBills);
            System.out.printf("Quarters:\t\t\t\t %-15d\n", numberOfQuarters);
            System.out.printf("Dimes:\t\t\t\t\t %-15d\n", numberOfDimes);
            System.out.printf("Nickels:\t\t\t\t %-15d\n", numberOfNickels);
            System.out.printf("Pennies:\t\t\t\t %-15d\n", numberOfPennies);
            System.out.println();
        }else if(personal != "Manager") {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t Not Valid by " + personal);
            System.out.println(" ");
        }

    }


    public void buyApple(Apple apple, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Apple");
        System.out.println("==========================================");
        System.out.printf("Apple Price:\t\t $%-15.2f\n" , apple.price() );
        System.out.printf("Payment:\t\t\t $%-15.2f\n" , payment.paymentValue() );

        if(payment.paymentValue() < apple.price()){
            double shortAmount = apple.price() - payment.paymentValue();
            System.out.printf("You need:\t\t\t $%-15.2f\n", shortAmount );
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Apple");
            System.out.println("==========================================");
            System.out.println("\n");
        }else if (payment.paymentValue() >= apple.price()){
            giveChange(apple.price(), payment);
        }
    }//end buyApple()

    public void buySandwich(Sandwich sandwich, Payment payment) {
        System.out.println("==========================================");
        System.out.println("Register Buy Sandwich");
        System.out.println("==========================================");

        if(payment.paymentValue() < sandwich.getPrice()){
            double shortAmount = sandwich.getPrice() - payment.paymentValue();
            System.out.printf("Sandwich Price:\t\t $%-15.2f\n" , sandwich.getPrice() );
            System.out.printf("Payment:\t\t\t $%-15.2f\n" , payment.paymentValue() );
            System.out.printf("You need:\t\t\t $%-15.2f\n", shortAmount);
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Sandwich");
            System.out.println("==========================================");
            System.out.println("\n");
        }else if (payment.paymentValue() >= sandwich.getPrice()){
            System.out.printf("Sandwich Price:\t\t $%-15.2f\n" , sandwich.getPrice() );
            System.out.printf("Payment:\t\t\t $%-15.2f\n" , payment.paymentValue() );
            giveChange(sandwich.getPrice(), payment);



        }

    }//end buySandwich()

        private void giveChange(double price, Payment payment){

            numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
            numberOfQuarters += payment.getNumberOfQuarters();
            numberOfDimes += payment.getNumberOfDimes();
            numberOfNickels += payment.getNumberOfNickels();
            numberOfPennies += payment.getNumberOfPennies();


            // calculate needed change
            double neededChange = payment.paymentValue() - price;
            neededChange = payment.getNumberOfOneDollarBills();

            // rounded to whole number so you can use the % operator for the change
            // example 9.65 becomes 965
            int neededChangeWhole = (int)Math.round(neededChange * 100);

            System.out.printf("Change:\t\t\t\t $%-15.2f\n", neededChange);
            int changeDollars = neededChangeWhole / 100;
            neededChangeWhole -= changeDollars*100;


            // figure out the quarters to give back
            int changeQuarters = neededChangeWhole / 25;

            // update the remaining change to give back
            neededChangeWhole -= changeQuarters * 25;

            // figure out the dimes to give back
            int changeDimes = neededChangeWhole / 10;

            // update the remaining change to give back
            neededChangeWhole -= changeDimes * 10;

            // figure out the nickels to give back
            int changeNickels = neededChangeWhole / 5;

            // update the remaining change to give back
            neededChangeWhole = changeNickels % 5;

            // figure out the pennies to give back
            int changePennies = neededChangeWhole / 1;
            neededChange -= changePennies*1;

            // give the change back
            // remove the dollars, quarters, dimes, nickels, pennies
            // from the register
            // Hint code:
            // numberOfOneDollarBills -= changeDollars;
            // YOUR CODE HERE
            numberOfOneDollarBills -= changeDollars;
            numberOfQuarters -= changeQuarters;
            numberOfDimes -= changeDimes;
            numberOfNickels -= changeNickels;
            numberOfPennies -= changePennies;

            System.out.printf("Dollars:\t\t\t %-15d\n", changeDollars);
            System.out.printf("Quarters:\t\t\t %-15d\n", changeQuarters);
            System.out.printf("Dimes:\t\t\t\t %-15d\n", changeDimes);
            System.out.printf("Nickels:\t\t\t %-15d\n", changeNickels);
            System.out.printf("Pennies: \t\t\t %-15d\n", changePennies);


    }//end buySandwich()
}
