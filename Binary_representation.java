import java.util.Scanner;
public class Binary_representation {
    
}

       public static void main(String[] args) {

        Scanner S = new Scanner (System.in);
        System.out.print("input first number: ");


        int num = S.nextInt();
        String binary = Integer.toBinaryString(num);
        int zeroCount=0;
        
        
        for(int i=0; i<binary.length(); i=i+1){
            if(binary.charAt(i)=='0'){
               zeroCount++;
            }
        }

            
         System.out.println("Binary representation of " + num + " is: " + binary);
         System.out.println("Number of zero bits: " + zeroCount);
         
    }
