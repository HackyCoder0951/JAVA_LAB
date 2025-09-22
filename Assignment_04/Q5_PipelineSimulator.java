package Assignment_04;

import java.util.*;

public class Q5_PipelineSimulator {

    static class Instr {
        final int id;
        final String dst, s1, s2;

        Instr(int id, String dst, String s1, String s2) {
            this.id = id;
            this.dst = dst;
            this.s1 = s1;
            this.s2 = s2;
        }

        public String toString() {
            return "I" + id + "(" + dst + ":" + s1 + "," + s2 + ")";
        }
    }

    interface HazardHandler {
        // returns number of stall cycles required (0 if forwarding resolves)
        int handle(Instr prev, Instr curr);
    }

    // simple handler: forwarding available -> 0, else full stall of 1 cycle
    static class ForwardingHandler implements HazardHandler {
        @Override
        public int handle(Instr prev, Instr curr) {
            if (prev == null)
                return 0;
            // if curr reads prev.dst, assume forwarding resolves -> 0 stalls
            if ((curr.s1 != null && curr.s1.equals(prev.dst)) || (curr.s2 != null && curr.s2.equals(prev.dst))) {
                System.out.printf("Forwarding used between %s -> %s%n", prev, curr);
                return 0;
            }
            return 0;
        }
    }

    // no forwarding -> 1 stall if dependency
    static class StallHandler implements HazardHandler {
        @Override
        public int handle(Instr prev, Instr curr) {
            if (prev == null)
                return 0;
            if ((curr.s1 != null && curr.s1.equals(prev.dst)) || (curr.s2 != null && curr.s2.equals(prev.dst))) {
                System.out.printf("Stall introduced between %s -> %s%n", prev, curr);
                return 1;
            }
            return 0;
        }
    }

    // pipeline simulation
    static void runPipeline(List<Instr> program, HazardHandler handler) throws InterruptedException {
        final int stages = 5;
        // String[] pipeline = new String[stages]; // hold instruction tags or null
        Instr[] stageInstr = new Instr[stages];
        int cycle = 0;
        int pc = 0;
        Instr lastWB = null;

        while (pc < program.size() || Arrays.stream(stageInstr).anyMatch(Objects::nonNull)) {
            cycle++;
            System.out.println("Cycle " + cycle);

            // check hazard between EX stage (stage 2) writing and ID stage (stage 1)
            // reading
            Instr exInstr = stageInstr[2]; // instruction in EX stage
            Instr idInstr = stageInstr[1]; // instruction in ID stage
            int stalls = handler.handle(exInstr, idInstr);

            if (stalls > 0) {
                // introduce stall: bubble in EX (shift stages except IF)
                System.out.println("Inserting bubble (stall) this cycle");
                // move WB done
                lastWB = stageInstr[4];
                for (int s = stages - 1; s >= 1; s--) {
                    if (s == 2) {
                        stageInstr[s] = null;
                    } // bubble in EX
                    else
                        stageInstr[s] = stageInstr[s - 1];
                }
                // IF does not fetch new instruction this cycle (stall)
                stageInstr[0] = stageInstr[0]; // remain same
            } else {
                // normal advance: shift pipeline right (WB stage completes)
                lastWB = stageInstr[4];
                for (int s = stages - 1; s >= 1; s--)
                    stageInstr[s] = stageInstr[s - 1];
                // fetch next instruction into IF stage
                if (pc < program.size()) {
                    stageInstr[0] = program.get(pc++);
                } else {
                    stageInstr[0] = null;
                }
            }

            // print pipeline snapshot
            for (int s = 0; s < stages; s++) {
                System.out.printf(" S%d: %s |", s + 1, stageInstr[s] == null ? "----" : stageInstr[s]);
            }
            System.out.println("\n");
            Thread.sleep(200); // slow down to observe cycles
        }
        System.out.println("Pipeline complete.");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Instr> program = Arrays.asList(
                new Instr(1, "R1", "R2", "R3"),
                new Instr(2, "R2", "R1", "R4"), // depends on I1
                new Instr(3, "R3", "R5", "R6"),
                new Instr(4, "R4", "R3", "R7") // depends on I3
        );

        System.out.println("Run with forwarding (should avoid stalls):");
        runPipeline(program, new ForwardingHandler());

        System.out.println("\nRun without forwarding (introduce stalls):");
        runPipeline(program, new StallHandler());
    }
}

/*
    
 */