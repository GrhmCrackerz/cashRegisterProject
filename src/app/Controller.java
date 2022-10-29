package app;

import food.Apple;
import food.Sandwich;
import machine.Register;
import transactions.Payment;

import java.sql.SQLOutput;

public class Controller {

    public static void main(String[] args){

        System.out.println("=========================================");
        System.out.println("COP 2210 - Project 1 Output");
        System.out.println("Rodney Graham");
        System.out.println("6196375");
        System.out.println("U01");
        System.out.println("=========================================");
        System.out.println("\n");

        Register register = new Register(15, 20 , 10, 20, 50);

        register.cashInfo("Manager");
        register.cashInfo("Staff");

        food.Apple grannySmith = new Apple("Granny Smith", 1.51, 140);
        grannySmith.displayInfo();
        System.out.println();

        transactions.Payment applePayment1 = new Payment(10 , 0, 0, 0, 47);
        applePayment1.displayInfo();
        System.out.println();

        // call the buyApple method on the register object with
        // inputs grannySmith, applePayment1
        register.buyApple(grannySmith, applePayment1);

        // check register cash as a "Manager"
        // call the cashInfo method on the register object with input "Manager"
        register.cashInfo("Manager");

        // create an Apple variable named macintosh with
        // type = "Macintosh"
        // weight = 1.70
        // pricePreUnitWeight = 150
        food.Apple macintosh = new Apple("Macintosh", 1.70 , 150);
        // call displayInfo() on the macintosh object
        macintosh.displayInfo();

        // create a Payment variable named applePayment2 with

        transactions.Payment applePayment2 = new Payment(0, 2, 0, 0, 0);

        // call displayInfo() on the applePayment2 object
        applePayment2.displayInfo();

        // call the buyApple method on the register object with
        // inputs macintosh, applePayment2
        register.buyApple(macintosh, applePayment2);

        // check register cash as a "Manager"
        // call the cashInfo method on the register object with input "Manager"
        register.cashInfo("Manager");

        // create an Sandwich variable named sandwich with
        // meat = true
        // cheese = true
        // veggies = true
        food.Sandwich sandwich = new Sandwich(true, true, true);

        // call displayInfo() on the sandwich object
        sandwich.displayInfo();

        // create an Payment variable named sandwichPayment1 with
        // 5 dollars
        // 2 quarters
        // 1 dimes
        // 1 nickels
        // 2 pennies
        transactions.Payment sandwichPayment1 = new Payment(5, 2,1,1,2);

        // call displayInfo() on the sandwichPayment1 object
        sandwichPayment1.displayInfo();

        // call the buySandwich method on the register object with
        // inputs sandwich, sandwichPayment1
        register.buySandwich(sandwich, sandwichPayment1);

        // check register cash as a "Manager"
        // call the cashInfo method on the register object with input "Manager"
        register.cashInfo("Manager");

        // create booleans

        boolean meat = true;
        boolean cheese = true;
        boolean veggies = true;
        System.out.println("");
        // Create all type sandwichs combinations
        // then buy each sandwich by creating a payment with
        // 10 dollars
        // 0 quarters
        // 0 dimes
        // 0 nickels
        // 0 pennies
        // YOU MUST USE A FOR LOOP AND IF ELSE STATEMENTS
        // YOUR CODE HERE
        Payment sandwichPayment2 = new Payment(10,0,0,0,0);

        for(int a = 1; a<=8; a++){

            if(a<=4) {
                meat = true;
            }else{
                meat = false;
            }
            if(a<=2 || a == 5 || a==6){
                cheese = true;
            }else{
                cheese = false;
            }
            if(a%2==1){
                veggies = true;
            }else{
                veggies = false;
            }
            food.Sandwich sandwich2 = new Sandwich(meat, cheese, veggies);
            sandwich2.displayInfo();

            sandwichPayment2.displayInfo();
            register.buySandwich(sandwich2, sandwichPayment2);


            register.cashInfo("Manager");
        }


    }
}
