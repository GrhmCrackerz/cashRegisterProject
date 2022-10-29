package food;

import transactions.Payment;

public class Apple {

    //----------------------------------------------------------
    // Instant variables
    //----------------------------------------------------------
    private String type;
    private double weight;
    private double pricePerUnitWeight;



    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    public Apple(String type, double pricePerUnitWeight, double weightInGrams) {
        // convert gram into lbs
        weight = 0.00220 * weightInGrams;
        this.type = type;
        this.pricePerUnitWeight = pricePerUnitWeight;
    }

    //----------------------------------------------------------
    // Setters and Getters
    //----------------------------------------------------------

    public String getType(){
        return type;
    }



    public double getWeight(){
        return weight;
    }

    public double getPricePreUnitWeight(){
        return pricePerUnitWeight;
    }

    //----------------------------------------------------------
    // Utility methods
    //----------------------------------------------------------

    // setPricePreUnitWeight method
    public void setPricePreUnitWeight(double pricePreUnitWeight, String personal){
        this.pricePerUnitWeight = pricePreUnitWeight;
    }

    // displayInfo method
    // use printf and println method see below
    // Hint code:
    /*
    System.out.println("==========================================");
    System.out.println("Apple Info");
    System.out.println("==========================================");
    System.out.printf("Type:\t\t\t %-15s\n", type);
    System.out.printf("Weight:\t\t\t %-6.4f lbs\n", weight);
    System.out.printf("Price Pre Unit:\t\t %-10.2f\n", pricePreUnitWeight)
    */
    public void displayInfo(){
        System.out.println("==========================================");
        System.out.println("Apple Info");
        System.out.println("==========================================");
        System.out.printf("Type:\t\t\t\t %-15s\n", type);
        System.out.printf("Weight:\t\t\t\t %-6.4f lbs\n", weight);
        System.out.printf("Price Per Unit:\t\t %-10.2f\n", pricePerUnitWeight);
        System.out.printf("Price:\t\t\t\t $%-10.2f\n", price());
    }

    public double price(){
        double price = weight * pricePerUnitWeight;
        return price;
    }

}
