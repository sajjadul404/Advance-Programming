import java.util.Scanner;

public class Sum {

       public static void main(String[] args) {

        Scanner S = new Scanner (System.in);
        System.out.println("input");
        
        int a = S.nextInt();
        int b = S.nextInt();
        int sum = a+b ;

        int digitCount = String.valueOf(sum).length();



        System.out.println("Sum = " + sum);
        System.out.println("Number of digits = " + digitCount);


       }
    }
