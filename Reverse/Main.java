package Reverse;

import java.util.Scanner;

class Reverse {
    private int number;


    Reverse() {
        number = 0;
    }


    Reverse(int number) {
        this.number = number;
    }

    void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        number = sc.nextInt();
    }


    void doReverse() {
        int temp = number;
        int reverse = 0;

        while (temp != 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp = temp / 10;
        }

        System.out.println("Original Number: " + number);
        System.out.println("Reversed Number: " + reverse);
    }
}

public class Main {
    public static void main(String[] args) {


        Reverse obj = new Reverse();


        obj.getInput();

   
        obj.doReverse();
    }
}