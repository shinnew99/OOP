import java.util.Scanner;

public class FractionCalculator{

    public static Fraction fraction = new Fraction();
    public static Object String;
    public Fraction frac1;
    public Fraction frac2;
    public static Fraction result = new Fraction();



    private static void intro(){
        System.out.println("\n");
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------");

    }

    public static void main(String[]args) {
       intro();
       Fraction fraction = new Fraction();
       String operation = "";
       while(operation != "q" || operation !="quit" || operation != "Q"){
           System.out.println("--------------------------------");
           Scanner input = new Scanner(System.in);

           //operation = (String).getOperation(input);

           break;
       }



    }



    private Fraction getOperation(Scanner input){
        input = new Scanner(System.in);
        String operation = input.next();
        switch(operation){
            case "+":
                result = fraction.add(frac1, frac2);
                break;
            case "-":
                result = fraction.subtract(frac1, frac2);
                break;
            case "/":
                result = fraction.multiply(frac1, frac2);
                break;
            case "*":
                result = fraction.divide(frac1, frac2);
                break;

        }
        return result;

    }


}
