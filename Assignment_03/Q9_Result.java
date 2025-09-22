package Assignment_03;

class Student {
    private int rollNo;
    private String name;
    private int marks1, marks2, marks3;

    Student(int r, String n, int m1, int m2, int m3) {
        rollNo = r;
        name = n;
        marks1 = m1;
        marks2 = m2;
        marks3 = m3;
    }

    int getTotal() {
        return marks1 + marks2 + marks3;
    }

    String getGrade() {
        double avg = getTotal() / 3.0;
        if (avg >= 75)
            return "A";
        else if (avg >= 50)
            return "B";
        else
            return "C";
    }

    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Grade: " + getGrade());
    }
}

public class Q9_Result {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Ravi", 80, 70, 90);
        Student s2 = new Student(2, "Neha", 45, 55, 60);
        s1.display();
        s2.display();
    }
}