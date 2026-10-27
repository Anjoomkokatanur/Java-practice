public class recursion {
    public static void printDec(int n){
        if (n==1) {
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if (n==1) {
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int factorial(int n){
        if (n == 0) {
           return 1; 
        }
        int fact = n;
        return fact*factorial(n-1);
    }

    public static int Sum(int n){
        if(n == 1){
            return 1;
        }
        int s =n;
        s = s + Sum(n-1);
        return s;
    }

    public static int fibonacci(int n){
        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fibonacci(n-1);
        int fnm2 = fibonacci(n-2);
        int fn = fnm1 + fnm2;
        return fn; 
    }

    public static boolean isSorted(int arr[] , int i){
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int key,int i){
        if(i == arr.length){
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccur(arr, key, i+1);

    }

    public static int power(int x, int n){
        if (n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }

    public static int optimizedPower(int a, int n){
        if (n == 0) {
            return 1;
        }
        int halfPow = optimizedPower(a, n/2);
        int halfPowerSq = halfPow * halfPow;

        //n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tailingProblem(int n){//floorSize n*2
        //base case
        if (n == 0 || n == 1) {
            return 1;
        }

        //choice
        //vertical choice
        int fnm1 = tailingProblem(n-1);

        //horizontal choice
        int fnm2 = tailingProblem(n-2);

        return fnm1+fnm2;
    }

    public static void removeDublicates(String str, int idx ,StringBuilder newStr,boolean map[]){
        if(idx ==str.length()){
            System.out.println(newStr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar-'a']== true){
            //duplicate
            removeDublicates(str,idx+1,newStr,map);
        }
        else{
            map[currChar-'a'] = true;
            removeDublicates(str,idx+1,newStr.append(currChar),map);
        }
    }

    public static int friendsParing(int n){
        if (n==1 || n==2) {
            return n;
        }
        //choice
        //single
        // int fnm1 = friendsParing(n-1);

        // //pair
        // int fnm2 = friendsParing(n-2);
        // int pairWays = (n-1)*fnm2;

        // //total ways
        // int totWays = fnm1 + pairWays;

        return friendsParing(n-1) + (n-1) * friendsParing(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, String str){

        //base case
        if (n==0) {
            System.out.println(str);
            return;
        }
        //kaam
        printBinStrings(n-1, 0, str+"0");
        
        if(lastPlace == 0){
            printBinStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args){
        //int n = 25;
        // printDec(n);
        // System.out.println();
        // printInc(n);
        //System.out.println(factorial(n));
        // System.out.println(Sum(n));
        //System.out.println(fibonacci(n));
        //int arr[] = {1,2,3,5,4};
        //System.out.println(isSorted(arr, 0));
        //System.out.println(firstOccur(arr, 3, 0));
        // System.out.println(optimizedPower(2, 10));

        //System.out.println(tailingProblem(4));

        // String str = "appnnacollege";
        // removeDublicates(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsParing(3));
        printBinStrings(3, 0, "");
    }
}
