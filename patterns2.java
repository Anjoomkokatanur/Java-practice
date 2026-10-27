import java.util.Scanner;
public class patterns2 {
    public static void hollowRectangle(){
        Scanner sc = new Scanner(System.in);
        int row , col ;
        System.out.println("Enter number of rows");
        row = sc.nextInt();
        System.out.println("Enter number of columns");
        col = sc.nextInt();

        System.out.println("-------------------");
        for(int i = 1 ; i <= row ; i++){
            for(int j = 1 ; j <= col ; j++){
                if(i == 1 || i == row || j == 1 || j == col){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void invertedHalfPyramid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();
        System.out.println("-------------------");
        for(int i = 1; i <= n ; i++){
            //Spaces
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            //Stars
            for(int k = 1 ; k <= i ; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void invertedHalfPyramidNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();
        System.out.println("-------------------");
     
        for(int i = 1; i <= n ; i++){
            //Spaces
            for(int j = 1 ; j <= n-i+1 ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void floyedsTriangle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();
        int num = 1;
        System.out.println("-------------------");
        for(int i = 1; i <= n ; i++){
            //Spaces
            for(int j = 1 ; j <= i ; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
        System.out.println("-------------------");

        sc.close();
    }

    public static void Triangle_01(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("-------------------");
        for(int i = 1; i <= n ; i++){
            //Spaces
            for(int j = 1 ; j <= i ; j++){
                if((i + j)%2 == 0){
                    System.out.print("1"+" ");
                }
                else{
                    System.out.print("0"+" ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");

        sc.close();
    }

    public static void butterfly(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("-------------------");

        //1st half
        for(int i = 1 ; i <= n ; i++){
            //Stars
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            //Spaces
            for(int j = 1 ; j <= 2*(n-i) ; j++){
                System.out.print(" ");
            }
            //Stars
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2nd half
        for(int i = n ; i >= 1 ; i--){
            //Stars
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            //Spaces
            for(int j = 1 ; j <= 2*(n-i) ; j++){
                System.out.print(" ");
            }
            //Stars
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void solidRhombus(){

         Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("-------------------");
        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= n ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void hollowRhombus(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("-------------------");
        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int k = 1 ; k <= n ; k++){
                if(i == 1 || i == n || k == 1 || k == n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }

    public static void diamond(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("-------------------");
        //1st half
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for(int i = n; i >= 1 ; i--){
            for(int j = 1; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        sc.close();
    }
    public static void main(String[] args){
        // hollowRectangle();
        // invertedHalfPyramid();
        //invertedHalfPyramidNumber();
        //floyedsTriangle();
        //Triangle_01();
        //butterfly();
        //solidRhombus();
        //hollowRhombus();
        diamond();
    }
}
