import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

//X가 Row, Y가 column

public class BattleShipsGame{

    public static char [][] dim = new char[10][10]; //배열 초기화

    //Step 1 - Create the Ocean Map
    public static void OceanMap(char[][] gameBoard){

        System.out.println("   0123456789   ");
        for(int i=0; i<gameBoard.length; i++){ //게임보드를 for문으로 출력 //줄
            System.out.print(i + " |");
            for(int j=0; j<gameBoard[i].length; j++){ //칸
                //System.out.print(gameBoard[i][j]);
                //deployPlayer(char[][] a, int numberofDeployment);
                //deployComputer();
                System.out.print(" ");

            }
            System.out.print("| " + i );
            System.out.println();
        }
        System.out.println("   0123456789   ");

    }

    //Step2 - Deploy Player's Ships
    public static void deployPlayer(char[][] gameboard, int numberofDeployment){
        //쉽게 얘기하자면 parameter가 input값이고 void가 리턴값
        Scanner s = new Scanner(System.in);
        int[] ar = new int[2];
        //선언과 동시에 방이 2개인 [  ,  ]인 배열 할당
        System.out.println("\n\nDeploy your ships");
        for(int i=1; i<=numberofDeployment; i++){
            ar = enterCoordinates(i);
            while(ar[0] >= gameboard.length || ar[1]>=gameboard[i].length || gameboard[ar[0]][ar[1]]!= '\u0000'){
                //앞에가 행의 길이 뒤에가 열의 길이 => 내가 입력한 좌표값이 범위를 벗어나는지 확인
                System.out.println("Invalid Coordinate. Please try again");
                ar= enterCoordinates(i);
                //배열형으로 리턴한다라는 의미
            }
            gameboard[ar[0]][ar[1]] = '@';
            //null인곳에 @찍어라.
        }
    }



    //Step 3 - Deploy Computer's ships
    public static void deployComputer(char[][] gameboard, int numberofDeployment){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int n;
        int m;
        System.out.println("\n\nComputer is deploying ships");
        for(int i=1; i<=numberofDeployment; i++){
            n = r.nextInt(gameboard.length);
            try{
                Thread.sleep(1000);  //1000 ms = 1s
            }catch(InterruptedException e){

            }
            m=r.nextInt(gameboard[i].length);

            while( n>=gameboard.length || m>=gameboard[i].length || gameboard[n][m]!='\u0000'){
                // n
                n=r.nextInt(gameboard.length);
                try{
                    Thread.sleep(1000); //Thread는 process안에서 여러가지 일들을 담당하는 애들
                    //Thread는 병렬처리를 할수 있음
                }catch(InterruptedException e){

                }
                m=r.nextInt(gameboard[i].length);
            }
            System.out.println(i+".ship DEPLOYED");
            gameboard[n][m] = ' ';
        }
        System.out.println("++++++++++++");

    }

    public static int[] enterCoordinates(int deployNumber){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int [] ar = new int[2];
        System.out.print("Enter X Coordinate for your " + deployNumber + ".ship: ");
        ar[0] = s.nextInt();
        System.out.print("Enter Y Coordinate for your " + deployNumber + " .ship: ");
        ar[1] = s.nextInt();
        return ar;
    }



    //Step 4 - Battle
    public static void Battle(char[][] gameboard, int numberofDeployment){
        Scanner s = new Scanner(System.in);
        int turn;
        int r;  //x
        int c;  //y
        int playerShips = numberofDeployment;
        int computerShips = numberofDeployment;
        int[] ch= new int[2];
        ArrayList<Integer> computerwrong = new ArrayList<Integer>();
        Random random = new Random();
        while(!gaveOver(playerShips, computerShips)){
            r = gameboard.length;
            c=gameboard[0].length;
            turn = 0;
            System.out.println("Your Turn");
            while( r>=gameboard.length || c>=gameboard[0].length){
                System.out.print("Enter X coordinate : ");
                r= s.nextInt();
                System.out.print("Enter Y coordinate : ");
                c= s.nextInt();
            }
            ch= checkHit(gameboard, r,c, playerShips, computerShips, turn, computerwrong);
            playerShips -= ch[0];
            computerShips -= ch[1];
            turn = 1;
            System.out.println("COMPUTER's TURN");
            r=gameboard.length;
            c=gameboard[0].length;
            while(r>=gameboard.length || c>=gameboard[0].length){
                r = random.nextInt(gameboard.length);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ex){

                }
                c=random.nextInt(gameboard[0].length);
                for(int i=0; i<computerwrong.size(); i++){
                    r=gameboard.length;
                    c=gameboard[0].length;
                }
            }

            System.out.println("여기통과");
            ch= checkHit(gameboard, r,c, playerShips, computerShips, turn, computerwrong);
            playerShips -= ch[0];
            computerShips -= ch[1];
            OceanMap(gameboard);
            System.out.println(" \n\nYour ships : " + playerShips + "| Computer Ships : " + computerShips + " \n+++++++++++++++++" );
        }
        if(playerShips>computerShips){
            System.out.println("Hooray! You win the battle :)");
        }else {
            System.out.println("Sorry, You loose :(  ");
        }

    }

    public static int[] checkHit(char[][] gameboard, int r, int c, int playerShips, int computerShips, int turn, ArrayList<Integer> computerwrong) {
        int [] ar = new int[2];
        if(turn ==0){
            switch (gameboard[r][c]){
                case '@':
                    System.out.println("On no, you sunk your own ship :( ");
                    gameboard[r][c]='x';
                    ar[0]=1;
                    break;
                case ' ':
                    System.out.println("Boom! You sunk the ship!");
                    gameboard[r][c]='!';
                    ar[1]=1;
                    break;
                case '\u0000':
                    System.out.println("Sorry, you missed.");
                    gameboard[r][c] = '-';
                    break;
            }
        }else{
            int q = r*gameboard.length + c;
            switch(gameboard[r][c]){
                case '@':
                    System.out.println("The computer sunk one of your ships!");
                    gameboard[r][c] = 'x';
                    ar[0]=1;
                    break;
                case ' ':
                    System.out.println("The computer sunk of of its own ships");
                    gameboard[r][c] = '!';
                    ar[1] = 1;
                    break;
                default:
                    System.out.println("Computer missed");
                    computerwrong.add(q);
                    break;
            }
        }
        return ar;

    }

    public static boolean gaveOver(int playerShips, int computerShips) {
        if(playerShips == 0 || computerShips ==0){
            return true;
        } else {
            return false;
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        System.out.println("****Welcome to Battle ships Game****");
        System.out.print("\nRight now, the sea is empty.\n");
        System.out.println("\n");
        OceanMap(dim);
        System.out.print("\n\nHow many times the number of deployment should be: ");
        int x=sc.nextInt();

        deployPlayer(dim,x);
        System.out.println("\n");
        OceanMap(dim);
        deployComputer(dim,x);
        OceanMap(dim);
        Battle(dim,x);
    }
}