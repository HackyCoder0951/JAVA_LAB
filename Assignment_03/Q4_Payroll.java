package Assignment_03;

class Employee {
    String name;
    double basicSalary;

    Employee(String n, double b) {
        name = n;
        basicSalary = b;
    }

    double calculateSalary() {
        return basicSalary;
    }
}

class Manager extends Employee {
    double allowance;

    Manager(String n, double b, double a) {
        super(n, b);
        allowance = a;
    }

    double calculateSalary() {
        return basicSalary + allowance;
    }
}

class Programmer extends Employee {
    double deduction;

    Programmer(String n, double b, double d) {
        super(n, b);
        deduction = d;
    }

    double calculateSalary() {
        return basicSalary - deduction;
    }
}

public class Q4_Payroll {
    public static void main(String[] args) {
        Employee e1 = new Manager("Raj", 50000, 10000);
        Employee e2 = new Programmer("Simran", 40000, 5000);
        System.out.println(e1.name + " Salary: " + e1.calculateSalary());
        System.out.println(e2.name + " Salary: " + e2.calculateSalary());
    }
}