package Assignment_04;
import java.util.Scanner;

public class Q1_DailyCostCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("WELCOME TO THE PROGRAM WHERE I CALCULATE PER DAY COST INCLUDING JOB LOSS AMOUNT");

        System.out.print("Enter Your College Fees per Semester in Rupees: ");
        double fees = input.nextDouble();

        System.out.print("Enter per Day Transport cost in Rupees: ");
        double transport = input.nextDouble();

        System.out.print("Enter how many hours you are learning that day: ");
        int hours = input.nextInt();

        System.out.print("Enter how many minutes you are learning that day: ");
        int minutes = input.nextInt();

        System.out.print("Enter your expected monthly job income (if you didn’t attend college): ");
        double monthlyJobIncome = input.nextDouble();

        // Assumptions
        int totalSemesterDays = 132;       // 6 months × 22 working days
        int workingDaysPerMonth = 22;

        double perDayCollegeCost = fees / totalSemesterDays;
        double dailyJobIncome = monthlyJobIncome / workingDaysPerMonth;
        double opportunityLoss = dailyJobIncome;

        double totalPerDayCost = perDayCollegeCost + transport + opportunityLoss;

        double totalMinutes = hours * 60 + minutes;

        System.out.println("\n RESULT: ");

        if (totalMinutes == 0) {
            System.out.println("Error: Learning time cannot be zero.");
        } else {
            double costPerMinute = totalPerDayCost / totalMinutes;

            System.out.printf("Total cost for the day (College + Transport + Missed Job Income): ₹%.2f\n", totalPerDayCost);
            System.out.printf("Total time spent: %d hours %d minutes (%.0f minutes)\n", hours, minutes, totalMinutes);
            System.out.printf("Cost per minute of learning: ₹%.2f\n", costPerMinute);
        }

        input.close();
    }
}