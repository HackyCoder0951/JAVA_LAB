package Assignment_04;

// import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Improved Daily Cost Calculator
 *
 * Features:
 * - Robust user input with validation
 * - Configurable assumptions (semester days, working days per month)
 * - Optional daily extras (meals, books amortized per day, other)
 * - Detailed breakdown: per-day college cost, opportunity loss, total/day,
 *   cost per minute, cost per hour, projected semester cost for attended days
 * - Simple what-if: compute cost for different attendance counts
 * - Loop to run multiple calculations
 */
public class Q2_CostCalculator {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static final DecimalFormat money = new DecimalFormat("₹#,##0.00");

    public static void main(String[] args) {
        System.out.println("WELCOME — DAILY COST CALCULATOR (College vs Missed Job Income)");

        boolean again = true;
        while (again) {
            runOnce();
            again = askYesNo("Do you want to run another calculation? (y/n): ");
            System.out.println();
        }
        System.out.println("Thank you — Goodbye!");
        sc.close();
    }

    private static void runOnce() {
        System.out.println("\n=== Input Section ===");

        // Fees: allow user to specify whether input is per-semester or per-month
        double fees;
        boolean feesPerSemester = askYesNo("Is the college fee amount per SEMESTER? (y = semester / n = monthly): ");
        if (feesPerSemester) {
            fees = promptDouble("Enter your College Fees per Semester (in rupees): ", 0, Double.MAX_VALUE);
        } else {
            double monthlyFees = promptDouble("Enter your College Fees per MONTH (in rupees): ", 0, Double.MAX_VALUE);
            // assume 6 months per semester by default (user can change later)
            fees = monthlyFees * 6;
            System.out.println("Converted to semester fees (6 months assumed): " + money.format(fees));
        }

        double transport = promptDouble("Enter per-day Transport cost (in rupees): ", 0, Double.MAX_VALUE);

        // optional daily extras
        double meals = promptDoubleAllowEmpty("Enter per-day Meal cost (press Enter to skip / default 0): ", 0, Double.MAX_VALUE, 0);
        double otherDaily = promptDoubleAllowEmpty("Enter other per-day expenses (e.g., snacks) (Enter to skip): ", 0, Double.MAX_VALUE, 0);

        // optional one-time costs that we amortize across semester days (e.g., books)
        double oneTime = promptDoubleAllowEmpty("Enter one-time semester costs to amortize (books, laptop) (Enter to skip): ", 0, Double.MAX_VALUE, 0);

        // Learning time
        int hours = (int) promptDouble("Enter how many hours you are learning that day: ", 0, 24);
        int minutes = (int) promptDouble("Enter how many minutes you are learning that day: ", 0, 59);

        // job income (monthly) if working instead of college
        double monthlyJobIncome = promptDouble("Enter your expected monthly job income (if you did NOT attend college): ", 0, Double.MAX_VALUE);

        // configurable assumptions
        int totalSemesterDays = (int) promptDouble("Enter total number of college-days in a semester (default 132): ", 1, 10000, 132);
        int workingDaysPerMonth = (int) promptDouble("Enter number of working days per month (default 22): ", 1, 31, 22);

        // number of days you expect to attend this semester (for projections)
        int expectedAttendDays = (int) promptDouble("Enter how many days you expect to ATTEND this semester (Enter to assume full semester): ",
                0, totalSemesterDays, totalSemesterDays);

        // calculations & validation
        int totalMinutes = hours * 60 + minutes;
        if (totalMinutes == 0) {
            System.out.println("\nError: Total learning time cannot be zero. Please enter > 0 minutes next time.");
            return;
        }

        // Core calculations
        double perDayCollegeCost = fees / (double) totalSemesterDays; // amortized fees/day
        double amortizedOneTime = oneTime / (double) totalSemesterDays;
        double dailyJobIncome = monthlyJobIncome / (double) workingDaysPerMonth; // missed job earnings/day
        double opportunityLoss = dailyJobIncome; // assuming whole day job missed
        double totalPerDayCost = perDayCollegeCost + amortizedOneTime + transport + meals + otherDaily + opportunityLoss;

        double costPerMinute = totalPerDayCost / totalMinutes;
        double costPerHour = costPerMinute * 60;

        // projections
        double totalCostForExpectedAttendance = totalPerDayCost * expectedAttendDays;
        double totalMissedIncomeForSemester = opportunityLoss * expectedAttendDays;
        double collegeFeePortionForSemester = (perDayCollegeCost) * expectedAttendDays;

        // output
        System.out.println("\n=== Result / Breakdown ===");
        System.out.println("Inputs summary:");
        System.out.println("  Semester fees (amortized): " + money.format(fees) + " per semester (" + totalSemesterDays + " days)");
        System.out.println("  One-time amortized per day: " + money.format(amortizedOneTime));
        System.out.println("  Per-day transport: " + money.format(transport));
        System.out.println("  Per-day meals: " + money.format(meals));
        System.out.println("  Other per-day expenses: " + money.format(otherDaily));
        System.out.println("  Monthly job income (if not attending): " + money.format(monthlyJobIncome));
        System.out.println("  Job income missed per day (opportunity loss): " + money.format(opportunityLoss));
        System.out.println();
        System.out.println("Per-day totals:");
        System.out.println("  College fee portion / day: " + money.format(perDayCollegeCost));
        System.out.println("  One-time amortized/day:    " + money.format(amortizedOneTime));
        System.out.println("  Total opportunity loss/day:" + money.format(opportunityLoss));
        System.out.println("  Total per day cost (all included): " + money.format(totalPerDayCost));
        System.out.printf("Time spent today: %d hours %d minutes = %d minutes\n", hours, minutes, totalMinutes);
        System.out.println("  Cost per minute of learning: " + money.format(costPerMinute));
        System.out.println("  Cost per hour of learning:   " + money.format(costPerHour));
        System.out.println();
        System.out.println("Projections for this semester (attending " + expectedAttendDays + " days):");
        System.out.println("  Total cost over attended days: " + money.format(totalCostForExpectedAttendance));
        System.out.println("    - = missed income total: " + money.format(totalMissedIncomeForSemester));
        System.out.println("    - = college fees portion total: " + money.format(collegeFeePortionForSemester));
        System.out.println();

        // quick what-if: show effect of increasing/decreasing monthly job income
        if (askYesNo("Would you like a quick what-if for different monthly-job incomes? (y/n): ")) {
            double[] scenarios = {-1000, monthlyJobIncome * 0.5, monthlyJobIncome, monthlyJobIncome * 1.5, monthlyJobIncome * 2.0};
            System.out.println("\nWhat-if (monthlyJobIncome -> totalPerDayCost):");
            for (double mj : scenarios) {
                double dj = Math.max(0, mj) / (double) workingDaysPerMonth;
                double tp = perDayCollegeCost + amortizedOneTime + transport + meals + otherDaily + dj;
                System.out.printf("  MonthlyIncome %8s => total/day %8s (missed/day %8s)\n",
                        money.format(mj), money.format(tp), money.format(dj));
            }
            System.out.println();
        }

        // attendance simulation
        if (askYesNo("Would you like a small attendance simulation? (y/n): ")) {
            int simulateDays = (int) promptDouble("Enter number of semester days to simulate (1.." + totalSemesterDays + "): ", 1, totalSemesterDays);
            double cost = totalPerDayCost * simulateDays;
            System.out.println("Simulated attended days: " + simulateDays);
            System.out.println("  Total cost over " + simulateDays + " days = " + money.format(cost));
            System.out.println("  Equivalent missed income = " + money.format(opportunityLoss * simulateDays));
            System.out.println();
        }

        System.out.println("Calculation complete.");
    }

    // -------------------- Utility methods --------------------

    private static double promptDouble(String prompt, double min, double max) {
        return promptDouble(prompt, min, max, Double.NaN);
    }

    private static double promptDouble(String prompt, double min, double max, double defaultVal) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (line.isEmpty() && !Double.isNaN(defaultVal)) {
                return defaultVal;
            }
            try {
                double val = Double.parseDouble(line);
                if (val < min || val > max) {
                    System.out.printf("Please enter a value between %.2f and %.2f.%n", min, max);
                    continue;
                }
                return val;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number — try again.");
            }
        }
    }

    private static double promptDoubleAllowEmpty(String prompt, double min, double max, double defaultVal) {
        System.out.print(prompt);
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return defaultVal;
        try {
            double val = Double.parseDouble(line);
            if (val < min || val > max) {
                System.out.println("Value out of range — using default " + money.format(defaultVal));
                return defaultVal;
            }
            return val;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input — using default " + money.format(defaultVal));
            return defaultVal;
        }
    }

    private static boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.isEmpty()) continue;
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Please answer y (yes) or n (no).");
        }
    }
}
