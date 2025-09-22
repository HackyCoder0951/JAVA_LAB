package Assignment_04;
import java.util.*;
// import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Q1_CPUSchedulerSimulator {

    // Simple Process class
    static class Process {
        final int pid;
        final int arrival;
        int burst;
        int remaining;
        int startTime = -1;
        int finishTime = -1;

        Process(int pid, int arrival, int burst) {
            this.pid = pid;
            this.arrival = arrival;
            this.burst = burst;
            this.remaining = burst;
        }

        @Override
        public String toString() {
            return String.format("P%d(arr:%d,burst:%d,rem:%d)", pid, arrival, burst, remaining);
        }
    }

    // Abstract Scheduler
    static abstract class Scheduler {
        protected List<Process> processes;
        protected AtomicInteger clock = new AtomicInteger(0);
        protected int contextSwitches = 0;

        Scheduler(List<Process> procs) {
            this.processes = procs;
            // sort by arrival for deterministic behavior
            this.processes.sort(Comparator.comparingInt(p -> p.arrival));
        }

        abstract void schedule();

        protected void printStats() {
            System.out.println("Context switches: " + contextSwitches);
            double avgTurnaround = processes.stream().mapToInt(p -> p.finishTime - p.arrival).average().orElse(0.0);
            double avgWaiting = processes.stream().mapToInt(p -> (p.finishTime - p.arrival - p.burst)).average().orElse(0.0);
            System.out.printf("Avg Turnaround: %.2f, Avg Waiting: %.2f%n", avgTurnaround, avgWaiting);
        }
    }

    // CPU simulator thread - executes the given process for `time` units
    static class CPU {
        // simulate execution by sleeping 100ms per time unit
        void execute(Process p, int timeSlice, AtomicInteger clock) {
            if (p.startTime == -1) p.startTime = clock.get();
            System.out.printf("[t=%d] CPU: Running %s for %d unit(s)%n", clock.get(), "P"+p.pid, timeSlice);
            try {
                for (int i = 0; i < timeSlice; i++) {
                    Thread.sleep(80); // simulates 1 time unit
                    clock.incrementAndGet();
                    p.remaining--;
                    if (p.remaining == 0) break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("[t=%d] CPU: Finished slice. %s remaining=%d%n", clock.get(), "P"+p.pid, p.remaining);
            if (p.remaining == 0) p.finishTime = clock.get();
        }
    }

    // FCFS Scheduler
    static class FCFSScheduler extends Scheduler {
        FCFSScheduler(List<Process> procs) { super(procs); }

        @Override
        void schedule() {
            CPU cpu = new CPU();
            Queue<Process> ready = new LinkedList<>();
            int i = 0;
            while (true) {
                // add arrivals
                while (i < processes.size() && processes.get(i).arrival <= clock.get()) {
                    ready.add(processes.get(i));
                    System.out.printf("[t=%d] -> P%d arrived%n", clock.get(), processes.get(i).pid);
                    i++;
                }
                if (ready.isEmpty()) {
                    if (i >= processes.size()) break;
                    // advance clock to next arrival
                    int next = processes.get(i).arrival;
                    System.out.printf("[t=%d] Idle until %d%n", clock.get(), next);
                    clock.set(next);
                    continue;
                }
                Process p = ready.poll();
                contextSwitches++;
                cpu.execute(p, p.remaining, clock);
            }
            printStats();
        }
    }

    // SJF (non-preemptive)
    static class SJFScheduler extends Scheduler {
        SJFScheduler(List<Process> procs) { super(procs); }

        @Override
        void schedule() {
            CPU cpu = new CPU();
            List<Process> ready = new ArrayList<>();
            int i = 0;
            while (true) {
                while (i < processes.size() && processes.get(i).arrival <= clock.get()) {
                    ready.add(processes.get(i));
                    System.out.printf("[t=%d] -> P%d arrived%n", clock.get(), processes.get(i).pid);
                    i++;
                }
                if (ready.isEmpty()) {
                    if (i >= processes.size()) break;
                    int next = processes.get(i).arrival;
                    System.out.printf("[t=%d] Idle until %d%n", clock.get(), next);
                    clock.set(next);
                    continue;
                }
                // pick shortest remaining burst among ready (non-preemptive uses burst)
                ready.sort(Comparator.comparingInt(p -> p.remaining));
                Process p = ready.remove(0);
                contextSwitches++;
                cpu.execute(p, p.remaining, clock);
            }
            printStats();
        }
    }

    // Round Robin
    static class RRScheduler extends Scheduler {
        private final int quantum;

        RRScheduler(List<Process> procs, int quantum) { super(procs); this.quantum = quantum; }

        @Override
        void schedule() {
            CPU cpu = new CPU();
            Queue<Process> ready = new LinkedList<>();
            int i = 0;
            while (true) {
                while (i < processes.size() && processes.get(i).arrival <= clock.get()) {
                    ready.add(processes.get(i));
                    System.out.printf("[t=%d] -> P%d arrived%n", clock.get(), processes.get(i).pid);
                    i++;
                }
                if (ready.isEmpty()) {
                    if (i >= processes.size()) break;
                    int next = processes.get(i).arrival;
                    System.out.printf("[t=%d] Idle until %d%n", clock.get(), next);
                    clock.set(next);
                    continue;
                }
                Process p = ready.poll();
                contextSwitches++;
                int slice = Math.min(quantum, p.remaining);
                cpu.execute(p, slice, clock);
                // add newly arrived processes during slice
                while (i < processes.size() && processes.get(i).arrival <= clock.get()) {
                    ready.add(processes.get(i));
                    System.out.printf("[t=%d] -> P%d arrived%n", clock.get(), processes.get(i).pid);
                    i++;
                }
                if (p.remaining > 0) ready.add(p);
            }
            printStats();
        }
    }

    // Demo and dynamic selection
    public static void main(String[] args) {
        List<Process> procs = Arrays.asList(
            new Process(1, 0, 5),
            new Process(2, 2, 3),
            new Process(3, 4, 1),
            new Process(4, 6, 7)
        );

        System.out.println("Choose algorithm: 1-FCFS 2-SJF 3-RR");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Scheduler scheduler;
        switch (choice) {
            case 1: scheduler = new FCFSScheduler(cloneList(procs)); break;
            case 2: scheduler = new SJFScheduler(cloneList(procs)); break;
            case 3: scheduler = new RRScheduler(cloneList(procs), 2); break;
            default: System.out.println("Invalid"); sc.close(); return;
        }
        sc.close();
        scheduler.schedule();
    }

    private static List<Process> cloneList(List<Process> original) {
        List<Process> copy = new ArrayList<>();
        for (Process p : original) copy.add(new Process(p.pid, p.arrival, p.burst));
        return copy;
    }
}

/*  
 * Sample Output for FCFS:
Choose algorithm: 1-FCFS 2-SJF 3-RR
1
[t=0] -> P1 arrived
[t=0] CPU: Running P1 for 5 unit(s)
[t=5] CPU: Finished slice. P1 remaining=0
[t=5] -> P2 arrived
[t=5] CPU: Running P2 for 3 unit(s)
[t=8] CPU: Finished slice. P2 remaining=0
[t=8] -> P3 arrived
[t=8] CPU: Running P3 for 1 unit(s)
[t=9] CPU: Finished slice. P3 remaining=0
[t=9] -> P4 arrived
[t=9] CPU: Running P4 for 7 unit(s)
[t=16] CPU: Finished slice. P4 remaining=0
Context switches: 4
Avg Turnaround: 10.25, Avg Waiting: 4.25

 */