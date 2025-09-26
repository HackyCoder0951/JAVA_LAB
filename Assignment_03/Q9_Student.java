package Assignment_03;

public class Q9_Student {
    private int rollNo;
    private String name;
    private int marks1, marks2, marks3;

    // Constructor
    public Q9_Student(int rollNo, String name, int marks1, int marks2, int marks3) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Getter methods (controlled access)
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    // No direct setters for marks, only getters
    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    // Calculate total marks
    public int getTotal() {
        return marks1 + marks2 + marks3;
    }

    // Calculate grade
    public String getGrade() {
        double avg = getTotal() / 3.0;
        if (avg >= 75)
            return "A";
        else if (avg >= 50)
            return "B";
        else
            return "C";
    }

    // Display student details
    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name +
                ", Total: " + getTotal() + ", Grade: " + getGrade());
    }

    // Main method to test
    public static void main(String[] args) {
        Q9_Student s1 = new Q9_Student(1, "Ravi", 80, 70, 90);
        Q9_Student s2 = new Q9_Student(2, "Neha", 45, 55, 60);
        s1.display();
        s2.display();
    }
}