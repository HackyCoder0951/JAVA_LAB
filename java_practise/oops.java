package java_practise;

import java.util.*;
import java_practise.bank;

class shape {
    public void area(){
        System.out.println("Area is");
    }
}

class Triangle extends shape {
    public void area(int l, int h){
        System.out.println(1/2 * l * h);
    }
}

class EquilateralTriangle extends Triangle {
    public void area(int l, int h){
        System.out.println(1/2 * l * h);
    }
}

class Circle extends shape {
    public void area(int r){
        System.out.println((3.14) * r * r);
    }
}


public class oops {
    public static void main(String args[]) {
       bank.Account a1 = new bank.Account();
       a1.name = "John";
       System.out.println(a1.name);
    }
}
