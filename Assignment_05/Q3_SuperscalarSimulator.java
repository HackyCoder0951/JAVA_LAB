package Assignment_05;
import java.util.*;
import java.util.concurrent.*;

public class Q3_SuperscalarSimulator {

    static class Instruction {
        final int id;
        final String dest; // destination register (e.g., "R1")
        final String src1, src2; // source registers
        final int latency; // execution latency in ms
        Instruction(int id, String dest, String s1, String s2, int latency) {
            this.id = id; this.dest = dest; this.src1 = s1; this.src2 = s2; this.latency = latency;
        }
        public String toString() {
            return String.format("I%d(%s=%s+%s)", id, dest, src1, src2);
        }
    }

    static class ExecutionUnit implements Callable<Integer> {
        private final Instruction instr;
        private final Map<String, Integer> regFile; // for hazards simulation
        ExecutionUnit(Instruction i, Map<String,Integer> regFile) { this.instr = i; this.regFile = regFile; }
        @Override
        public Integer call() throws Exception {
            System.out.printf("Starting %s on %s%n", instr, Thread.currentThread().getName());
            Thread.sleep(instr.latency); // simulate work
            synchronized (regFile) {
                regFile.put(instr.dest, instr.id); // mark destination as written
            }
            System.out.printf("Finished %s%n", instr);
            return instr.id;
        }
    }

    // detect RAW hazard between two instructions
    static boolean hasDependency(Instruction a, Instruction b) {
        if (a == null || b == null) return false;
        // RAW: b reads a.dest
        return (b.src1 != null && b.src1.equals(a.dest)) || (b.src2 != null && b.src2.equals(a.dest));
    }

    public static void main(String[] args) throws Exception {
        List<Instruction> program = Arrays.asList(
            new Instruction(1, "R1", "R2", "R3", 300),
            new Instruction(2, "R2", "R1", "R4", 300), // depends on I1
            new Instruction(3, "R3", "R5", "R6", 200),
            new Instruction(4, "R4", "R3", "R7", 250)  // depends on I3
        );

        Map<String,Integer> regFile = new HashMap<>();
        ExecutorService es = Executors.newFixedThreadPool(2); // two execution units
        int pc = 0;
        while (pc < program.size()) {
            Instruction i1 = program.get(pc);
            Instruction i2 = (pc+1 < program.size()) ? program.get(pc+1) : null;

            // if i2 independent from i1 -> issue both
            if (i2 != null && !hasDependency(i1, i2) && !hasDependency(i2, i1)) {
                System.out.printf("Issuing %s and %s in parallel%n", i1, i2);
                Future<Integer> f1 = es.submit(new ExecutionUnit(i1, regFile));
                Future<Integer> f2 = es.submit(new ExecutionUnit(i2, regFile));
                f1.get(); f2.get(); // wait both
                pc += 2;
            } else {
                System.out.printf("Issuing %s alone%n", i1);
                Future<Integer> f1 = es.submit(new ExecutionUnit(i1, regFile));
                f1.get();
                pc += 1;
            }
        }
        es.shutdown();
        System.out.println("Program finished.");
    }
}
