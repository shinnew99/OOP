import java.util.Scanner;
import java.util.ArrayList;

public class Fraction{

    public int numerator;
    public int denominator;

//클래스명을받는게생성자
//pt1-FractionClass
    public Fraction(){//분수생성자
        numerator=denominator=1;

        Scanner input = new Scanner(System.in);
        int bunja,bunmo;//a가분자,b가분모
        bunja=input.nextInt();
        System.out.println("Please enter a fraction (a/b) or integer(a):");
        bunmo=input.nextInt();
        this.numerator=bunja;
        this.denominator=bunmo;

        try{
            if(denominator==0){
                System.out.println("Check your denominator");
            }

        } catch( IllegalArgumentException ex){
            ex.printStackTrace();
            //System.out.println("IllegalArgumentExceptionhasoccurred");
        }

        if( denominator<0 || numerator <0){
            //Math.abs()가절대값구하는거,음수를넣어도양수로전환되게하려고
            System.out.print(Math.abs(bunja)+"/"+Math.abs(bunmo));
        }
    }

    public Fraction(int numerator,int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }




    //여기서부터메소드
    //분자/분모의get/set메소드
    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return numerator;
    }

    
    // override함
    public String toString(){
        //data형자체가fraction은존재하지않으니분자,분모는int로받고합친건string으로받아줘야함
        String frac="";
        if (this.denominator==1){
            frac=Integer.toString(this.numerator);
        }else{
            frac=this.numerator+"/"+this.denominator;
        }
        return frac;
    }


    public double toDouble(){
        return(double)(this.numerator/this.denominator);
    }



    //사칙연산부분(+,-,*,/)
    public static Fraction add(Fraction frac1,Fraction frac2){
        //새로운 분자랑 새로운 분모
        //분자=원래분자*뒤에분모

        int newNumer=(frac1.numerator+frac2.denominator)+(frac1.denominator+frac2.numerator);
        int newDeno=(frac1.denominator*frac2.denominator);
        Fraction result = new Fraction(newNumer,newDeno);//이게새로계산한값
        result.toLowestTerms();
        return result;
    }

  /*  public Fraction add(Fraction object){ add를 object로 받는 함수
        //새로운 분자랑 새로운 분모
        //분자=원래분자*뒤에분모

        int newNumer=(numerator*object.denominator)+(denominator*object.numerator);
        int newDeno=(frac1.denominator*frac2.denominator);
        Fraction result = new Fraction(newNumer,newDeno);//이게새로계산한값
        result.toLowestTerms();
        return result;
    }*/



    public Fraction subtract(Fraction frac1,Fraction frac2){
        int newNumer=(frac1.numerator+frac2.denominator)-(frac1.denominator+frac2.numerator);
        int newDeno=(frac1.denominator*frac2.denominator);
        Fraction result = new Fraction(newNumer,newDeno);
        result.toLowestTerms();
        return result;
    }


    public Fraction multiply(Fraction frac1,Fraction frac2){
        int newNumer=(frac1.numerator+frac2.denominator)*(frac1.denominator+frac2.numerator);
        int newDeno=(frac1.denominator*frac2.denominator);
        Fraction result = new Fraction(newNumer,newDeno);
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction frac1,Fraction frac2){
        int newNumer=(frac1.numerator+frac2.denominator)/(frac1.denominator+frac2.numerator);
        int newDeno=(frac1.denominator*frac2.denominator);
        Fraction result;
        if(newNumer%newDeno==0){//나머지가0이니까분자가분모의배수인경우,즉약분하면자연수로나오는경우
            result = new Fraction( newNumer, newDeno);
        }else{//반대로 분모가 분자의 배수인경우
            result=new Fraction(newNumer,newDeno);
        }
        return result;
    }


    //override사용
    public boolean equals(Fraction object){//이부분에서기약분수로처리
        int newNumer,newDeno,simpleNumer,simpleDeno;
        newNumer=newDeno=simpleNumer=simpleDeno=1;

        //newNumer=object.numerator;
        //newDeno=object.denominator;

        simpleNumer=this.numerator;
        simpleDeno=this.denominator;

        if(simpleDeno>newDeno){
            newDeno=this.denominator;
        }else{

        }

        return equals(simpleNumer/simpleDeno);

    }


    public void toLowestTerms(){//여기에서 유클리드 호제법으로 계산
       int gcd = gcd(numerator,denominator);
       if(gcd!=0){
           numerator = numerator/gcd;
           denominator = denominator/gcd;
       }

    }

    //
    public static int gcd(int num, int den){ //최대공약수 구하는 메서드
        //유클리드 호제법:두 수 중 큰 수를 작은 수로 나눠서 나머지가 0이 될 때 까지 나누는 방법
        while(num!=0 && den!=0){
            int temp = num%den;
            num = den;
            den = temp;
        }
        return num;
    }

    public String validFraction(String input){

        return input;
    }


}
