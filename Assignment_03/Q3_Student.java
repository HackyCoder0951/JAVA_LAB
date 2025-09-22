package Assignment_03;

class Student {
    private int rollNo;
    private String name;
    private double marks;

    // Constructor
    Student(int r, String n, double m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks);
    }

    // Destructor simulation
    protected void finalize() {
        System.out.println("Object destroyed for student: " + name);
    }
}

public class Q3_Student {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Anita", 87.5);
        s1.display();
        s1 = null; // Eligible for GC
        System.gc(); // Request GC
    }
}