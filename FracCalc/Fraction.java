import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Fraction{

    public int numerator;
    public int denominator;

//클래스명을받는게생성자
//pt1-FractionClass
    public Fraction(int numerator, int denominator){//분수 생성자
        numerator=denominator=1;
        this.numerator=numerator;
        this.denominator=denominator;

        int bunja, bunmo = 1;
        bunja = this.numerator;
        bunmo = this.denominator;

        if(denominator==0){
            throw new IllegalArgumentException("Check your denominator");
        } else if ( denominator<0 || numerator <0){
            //Math.abs()가 절대값 구하는거,음수를 넣어도 양수로 전환되게 하려고
            System.out.print(Math.abs(bunja)+"/"+Math.abs(bunmo));
        } else if(this.denominator==1 && this.numerator>0) {
            System.out.print(this.numerator);
        } else {
            System.out.println(this.numerator+"/"+this.denominator);
        }
    }

    public Fraction(String s) {
        Fraction fraction = new Fraction(this.numerator+ "/" + this.denominator);

    }

    public Fraction() {
        Fraction fraction = new Fraction();
    }


    //여기서부터메소드
    //분자/분모의get/set메소드
    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    
    // override함
    public String toString(){
        return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
    }


    public double toDouble(){
        return(double)(this.numerator/this.denominator);
    }



    //사칙연산부분(+,-,*,/)
    public Fraction add(Fraction fraction, Fraction other){
        //원래 = this, 새로운게 other
        //분자=원래분자*뒤에분모
        int newNumer=(this.numerator*other.denominator)+(this.denominator+other.numerator);
        int newDeno=(this.denominator*other.denominator);
        Fraction result = new Fraction(newNumer+ "/" + newDeno); //이게새로계산한값
        result.toLowestTerms();
        return result;
    }

    public Fraction subtract(Fraction fraction, Fraction other){
        //원래 = this, 새로운게 other
        //분자=원래분자*뒤에분모
        int newNumer=(this.numerator*other.denominator)-(this.denominator+other.numerator);
        int newDeno=(this.denominator*other.denominator);
        Fraction result = new Fraction(newNumer+ "/" + newDeno); //이게새로계산한값
        result.toLowestTerms();
        return result;
    }

    public Fraction multiply(Fraction fraction, Fraction other){
        //원래 = this, 새로운게 other
        //분자=원래분자*뒤에분모
        int newNumer=(this.numerator*other.denominator)*(this.denominator+other.numerator);
        int newDeno=(this.denominator*other.denominator);
        Fraction result = new Fraction(newNumer+ "/" + newDeno); //이게새로계산한값
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction fraction, Fraction other){
        //원래 = this, 새로운게 other
        //분자=원래분자*뒤에분모
        int newNumer=(this.numerator*other.denominator)/(this.denominator+other.numerator);
        int newDeno=(this.denominator*other.denominator);
        if(other.numerator == 0){
            throw new IllegalArgumentException();
        } else {
            Fraction result = new Fraction(newNumer+ "/" + newDeno); //이게새로계산한값
            result.toLowestTerms();
            return result;
        }
    }


    //override사용
    public boolean equals(Object others){//이부분에서기약분수로처리
        if( others instanceof Fraction ){
            Fraction Another = (Fraction) others; //다른 새로운 분수를 분수객체로 강제 형변환
            Another.toLowestTerms();
            Fraction fraction = new Fraction(this.numerator,this.denominator);
            fraction.toLowestTerms();

            return(Another.numerator==fraction.numerator) && (Another.denominator==fraction.denominator);
        } else { //object가 fraction이 아닐경우
            throw new InputMismatchException("분수를 입력하시오");
        }

    }


    public void toLowestTerms(){//여기에서 유클리드 호제법으로 계산한 걸 적용해서 기약분수로 만들어줌
       int gcd = gcd(numerator,denominator);
       if(gcd!=0){
           numerator = numerator/gcd;
           denominator = denominator/gcd;
       }
    }


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
