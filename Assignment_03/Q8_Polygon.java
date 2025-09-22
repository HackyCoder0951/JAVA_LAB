package Assignment_03;

abstract class Polygon {
    abstract double perimeter();
}

class Triangle extends Polygon {
    double a, b, c;

    Triangle(double x, double y, double z) {
        a = x;
        b = y;
        c = z;
    }

    double perimeter() {
        return a + b + c;
    }
}

class Square extends Polygon {
    double side;

    Square(double s) {
        side = s;
    }

    double perimeter() {
        return 4 * side;
    }
}

public class Q8_Polygon {
    public static void main(String[] args) {
        Polygon p1 = new Triangle(3, 4, 5);
        Polygon p2 = new Square(6);
        System.out.println("Triangle Perimeter: " + p1.perimeter());
        System.out.println("Square Perimeter: " + p2.perimeter());
    }
}