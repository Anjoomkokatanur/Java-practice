public class patterns {
    public static void main(String [] args){
        int n = 4;
          // Star pattern
          for(int line = 1 ; line <= n ; line++){
            for(int star = 1; star <= line ;star++){
                System.out.print("*");
            }
            System.out.println();
          }

          System.out.println("inverted pattern");
          // Inverted star pattern 
          for(int line = 1 ; line <= n ; line++){
            for(int star = 1; star <= n-line+1 ;star++){
                System.out.print("*");
            }
            System.out.println();
          }
          //Half pyramid pattern
          int x = 5;
          for(int i =1; i <= x ;i++){
            for(int j = 1; j<= i ; j++){
                System.out.print(j);
            }
            System.out.println();
          }
          //Charecter pattern
          char ch ='A';
          for(int i =1; i <= x ;i++){
            for(int j = 1; j<= i ; j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
          }
    }
}