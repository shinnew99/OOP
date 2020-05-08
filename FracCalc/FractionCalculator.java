import java.util.Scanner;

public class FractionCalculator{

    public static Object String;
    public Fraction fraction = new Fraction();
    public Fraction fraction1 = new Fraction();
    public Fraction fraction2 = new Fraction();
    public Fraction result = getOperation();

    private static void intro(){
        System.out.println("\n");
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------");
    }

    public static void main(String[]args) {
       intro();

       boolean booleanResult = true;
       boolean yes = true;

       Fraction neg = new Fraction();
       Fraction zero = new Fraction();

       Fraction result = new Fraction(1,1);
       while (yes) {
           int bug = 0;
           String operation = getOperation();
           Fraction fac1 = new Fraction();
           Fraction fac2 = new Fraction();
           if (fac2.equals(zero) && operation.equals("/")) {
                bug = 1;
           } else {
               if (operation.equals("=")) {
                   booleanResult = fac1.equals(fac2);
               } else if (operation.equals("+")) {
                   result = fac1.add(fac1, fac2);
               } else if (operation.equals("-")) {
                   result = fac1.subtract(fac1, fac2);
               } else if (operation.equals("/")) {
                   result = fac1.divide(fac1, fac2);
               } else if (operation.equals("*")) {
                   result = fac1.multiply(fac1, fac2);
               }
           }

            //Print results
           if (bug == 0) {
               if (result.getDenominator() < 0) {
                   result.numerator = result.numerator*(-1);
                   result.denominator = result.denominator*(-1);
               }

               if (result.getNumerator() ==0) {
                    System.out.println(fac1 + " " + operation + " " + fac2 + " = " + "0");
               }
                else if (result.getNumerator() % result.getDenominator() == 0) {
                    System.out.println(fac1+" "+ operation+" "+ fac2 + " = " + (result.getNumerator()/result.getDenominator()));
               }
                else{
                    System.out.println(fac1 + " " + operation + " " + fac2 + " = " + result);
               }
            } else {
                System.out.println("Can not divide by 0, please try again");
            }
        }



    }


    private Fraction getOperation(Scanner input){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit ) : ");
        input = new Scanner(System.in);
        String operation = input.next();

        if( operation != "+" || operation != "-" || operation != "*" || operation != "/" ){
            System.out.println("Invalid input ( +, -, /, *, = or Q to quit");
        } else if ( operation == "Q" || operation == "q" || operation == "quit") {
            System.exit(0);
        } else {
            switch(operation){
                case "+":
                    result = fraction.add(fraction1, fraction2);
                    break;
                case "-":
                    result = fraction.subtract(fraction1, fraction2);
                    break;
                case "/":
                    result = fraction.multiply(fraction1, fraction2);
                    break;
                case "*":
                    result = fraction.divide(fraction1, fraction2);
                    break;
            }
        }
        return result;
    }

    public boolean validFraction(String fractioninput){
        boolean valid = true;

        if(fractioninput.contains("/")) {
            fractioninput = fractioninput.replace("/", " ");
        }

        if(fractioninput.contains("-")) {
            fractioninput = fractioninput.replace("-", " ");
        }

        if(fractioninput.matches("[0-9]+")){
            valid = true;
        } else{
            valid = false;
        }
        return valid;
    }


    public Fraction getFraction(Scanner input){
        System.out.println("Please enter a fraction (a/b) or integer(a)");
        String fraction = input.nextLine();

        while (!validFraction(fraction)) {
            System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fraction = input.nextLine();
        }

        int numerator = 0;
        int denominator = 0;

        if (fraction.contains("/")) {
            numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
            denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/")+1, fraction.length()));
        } else {
            numerator = Integer.parseInt(fraction);
            denominator = 1;
        }

        Fraction frac = new Fraction(numerator, denominator);
        return frac;
    }
}
