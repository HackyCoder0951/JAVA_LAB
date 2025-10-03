package Assignment_04;
import java.util.Scanner;

public class Q1_DailyCostCalculator {

    // Method to calculate cost per minute
    public static double calculateCostPerMinute(double totalCost, double totalMinutes) {
        if (totalMinutes == 0) {
            return -1; // Error indicator
        }
        return totalCost / totalMinutes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== LEARNING INVESTMENT ANALYZER ===");
        System.out.println("This tool calculates your daily investment in education.\n");

        // Input section
        System.out.print("Enter semester tuition fees (₹): ");
        double tuition = sc.nextDouble();

        System.out.print("Enter daily travel expense (₹): ");
        double travelCost = sc.nextDouble();

        System.out.print("Enter study duration (hours): ");
        int studyHours = sc.nextInt();

        System.out.print("Enter study duration (minutes): ");
        int studyMins = sc.nextInt();

        System.out.print("Enter potential monthly salary if not studying (₹): ");
        double altIncome = sc.nextDouble();

        // Constants / assumptions
        final int semesterWorkingDays = 6 * 22; // 6 months × 22 days
        final int workDaysInMonth = 22;

        // Calculations
        double perDayFee = tuition / semesterWorkingDays;
        double foregoneDailyIncome = altIncome / workDaysInMonth;
        double totalDailyCost = perDayFee + travelCost + foregoneDailyIncome;

        double totalMinutes = (studyHours * 60) + studyMins;
        double perMinuteCost = calculateCostPerMinute(totalDailyCost, totalMinutes);

        // Output
        System.out.println("\n--- DAILY LEARNING REPORT ---");
        System.out.printf("Fixed Academic Cost (per day): ₹%.2f\n", perDayFee);
        System.out.printf("Travel Expense: ₹%.2f\n", travelCost);
        System.out.printf("Opportunity Cost (Missed Salary): ₹%.2f\n", foregoneDailyIncome);
        System.out.printf("Total Daily Investment: ₹%.2f\n", totalDailyCost);

        if (perMinuteCost == -1) {
            System.out.println("Error: Study time cannot be zero.");
        } else {
            System.out.printf("Total Study Duration: %d hr %d min (%.0f minutes)\n", studyHours, studyMins, totalMinutes);
            
            System.out.printf("Learning Cost per Minute: ₹%.2f\n", perMinuteCost);
        }

        sc.close();
    }
}
