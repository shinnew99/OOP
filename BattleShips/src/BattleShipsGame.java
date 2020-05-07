import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

//X가 Row, Y가 column

public class BattleShipsGame{
    //Step 1 - Create the Ocean Map
    public static void OceanMap(char[][] a){
        //이 메소드 안에서 parameter값을, 즉 main에 있는 dim을 던져줌
        //그럼 여기 메서드를 돌면서 dim이 main으로 출력
        //char [][] a; 이건 여기 안에서의 지역변수
        System.out.println("****Welcome to Battle ships Game");
        System.out.println("");
        for(int i=0; i<a[0].length; i++){ //그냥 처음 시작 row를 출력하고자
            System.out.println(i);
        }
        for(int i=0; i<a.length; i++){ //게임보드를 for문으로 출력
            System.out.print("\n" + i + "|");
            for(int j=0; i<a[j].length; j++){
                if(a[i][j]==0){
                    System.out.print(" ");
                }else{
                    System.out.print(a[i][j]);
                }
            }
        }
        System.out.print("\n   ");
        for(int i=0; i<a[0].length; i++){
            System.out.print(i);
        }
    }

    //Step2 - Deploy Player's Ships
    public static void deployPlayer(char[][] a, int numberofDeployment){
        //쉽게 얘기하자면 parameter가 input값이고 void가 리턴값
        Scanner s = new Scanner(System.in);
        int[] ar = new int[2];
        //선언과 동시에 방이 2개인 [  ,  ]인 배열 할당
        System.out.println("\n\nDeploy your ships");
        for(int i=1; i<numberofDeployment; i++){
            ar = enterCoordinates(i);
            while(ar[0] >= a.length || ar[1]>=a[i].length || a[ar[0]][ar[1]]!= '\u0000'){
                //앞에가 행의 길이 뒤에가 열의 길이 => 내가 입력한 좌표값이 범위를 벗어나는지 확인
                System.out.println("잘못된 좌표입니다. 다시 입력해 주세요");
                ar= enterCoordinates(i);
                //배열형으로 리턴한다라는 의미
            }
            a[ar[0]][ar[1]] = '@';
            //null인곳에 @찍어라.
        }
    }

    public static int[] enterCoordinates(int deployNumber){
        Scanner s = new Scanner(System.in);
        int [] ar = new int[2];
        System.out.print("Enter Row Coordinate for your" + deployNumber + ".ship: ");
        ar[0] = s.nextInt();
        System.out.print("Enter Column Coordinate for your" + deployNumber + ".ship: ");
        ar[1] = s.nextInt();
        return ar;
    }

    //Step 3 - Deploy Computer's ships
    public static void deployComputer(char[][] a, int numberofDeployment){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int n;
        int m;
        System.out.println("\n\nComputer is deploying ships");
        for(int i=1; i<=numberofDeployment; i++){
            n=r.nextInt(a.length);
            try{
                Thread.sleep(1000);  //1000 ms = 1s
            }catch(InterruptedException e){

            }
            m=r.nextInt(a[i].length);

            while( n>=a.length || m>=a[i].length || a[n][m]!='\u0000'){
                // n
                n=r.nextInt(a.length);
                try{
                    Thread.sleep(1000); //Thread는 process안에서 여러가지 일들을 담당하는 애들
                    //Thread는 병렬처리를 할수 있음
                }catch(InterruptedException e){

                }
                m=r.nextInt(a[i].length);
            }
            System.out.println(i+".ship DEPLOYED");
            a[n][m] = ' ';
        }
        System.out.println("--------------");

    }



    //Step 4 - Battle
    public static void Battle(char[][] a, int numberofDeployment){
        Scanner s = new Scanner(System.in);
        int turn;
        int r;
        int c;
        int playerShips = numberofDeployment;
        int computerShips = numberofDeployment;
        int[] ar= new int[2];
        ArrayList<Integer> computerwrong = new ArrayList<Integer>();

    }


    public static void main(String args[]){
        System.out.println("Please enter the dimension of the map that you wnat");
        System.out.print("Row dimension");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.print("Column dimension");
        int c = sc.nextInt();
        char[][] dim = new char[r][c];
        System.out.println("\n\n\n*** Welcome to Battle Ships Game ****\n");
        System.out.print("Right now, the sea is empty\n");
        OceanMap(dim);
        System.out.println("\n]n+++++++++\n How many times the number of deployment should be: ");
        int z = sc.nextInt();
        deployPlayer(dim, z);
        System.out.println("\n");
        OceanMap(dim);
        deployComputer(dim,z);
        OceanMap(dim);
        Battle(dim,z);
    }
}