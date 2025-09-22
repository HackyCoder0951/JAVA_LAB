package Assignment_03;

class Vehicle {
    void fuelType() {
        System.out.println("Generic fuel type");
    }
}

class Car extends Vehicle {
    void fuelType() {
        System.out.println("Car uses Petrol/Diesel");
    }
}

class Bike extends Vehicle {
    void fuelType() {
        System.out.println("Bike uses Petrol");
    }
}

public class Q6_Vehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        v1.fuelType();
        v2.fuelType();
    }
}