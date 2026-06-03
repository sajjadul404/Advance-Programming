package Complex;
import java.util.Scanner;

class Complex {
    int real;
    int imag;

    Complex() {
        real = 0;
        imag = 0;
    }

    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    void Read(Scanner sc) {
        System.out.print("Enter real and imaginary numbers respectively: ");
        real = sc.nextInt();
        imag = sc.nextInt();
    }

    Complex Add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    void Display() {
        System.out.println("Sum = " + real + " + " + imag + "i");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Complex c1 = new Complex();
        Complex c2 = new Complex();

        c1.Read(sc);
        c2.Read(sc);

        Complex result = c1.Add(c2);

        result.Display();

        sc.close();
    }
}