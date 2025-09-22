package Assignment_03;

class Complex {
    double real, imag;

    Complex() { // Default constructor
        real = 0;
        imag = 0;
    }

    Complex(double r, double i) { // Parameterized constructor
        real = r;
        imag = i;
    }

    Complex(Complex c) { // Copy constructor
        real = c.real;
        imag = c.imag;
    }

    void display() {
        System.out.println(real + " + " + imag + "i");
    }
}

public class Q7_Complex {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex(5, 6);
        Complex c3 = new Complex(c2);
        c1.display();
        c2.display();
        c3.display();
    }
}