package Assignment_05;
import java.util.*;

public class Q4_PagingSimulator {

    static abstract class PageReplacement {
        final int frames;
        PageReplacement(int frames) { this.frames = frames; }
        abstract int run(int[] refs); // returns page faults
    }

    static class FIFOReplacement extends PageReplacement {
        FIFOReplacement(int f) { super(f); }
        @Override
        int run(int[] refs) {
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> inFrame = new HashSet<>();
            int faults = 0;
            for (int r : refs) {
                if (!inFrame.contains(r)) {
                    faults++;
                    if (q.size() >= frames) {
                        int ev = q.poll();
                        inFrame.remove(ev);
                    }
                    q.add(r); inFrame.add(r);
                }
            }
            return faults;
        }
    }

    static class LRUReplacement extends PageReplacement {
        LRUReplacement(int f) { super(f); }
        @Override
        int run(int[] refs) {
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(frames, .75f, true);
            int faults = 0;
            for (int r : refs) {
                if (!map.containsKey(r)) {
                    faults++;
                    if (map.size() >= frames) {
                        Integer oldest = map.keySet().iterator().next();
                        map.remove(oldest);
                    }
                }
                map.put(r, 1);
            }
            return faults;
        }
    }

    static class OptimalReplacement extends PageReplacement {
        OptimalReplacement(int f) { super(f); }
        @Override
        int run(int[] refs) {
            Set<Integer> framesSet = new HashSet<>();
            int faults = 0;
            for (int i = 0; i < refs.length; i++) {
                int page = refs[i];
                if (framesSet.contains(page)) continue;
                faults++;
                if (framesSet.size() < frames) {
                    framesSet.add(page);
                } else {
                    // choose page with farthest next use (or not used again)
                    int toRemove = -1;
                    int farthest = -1;
                    for (int p : framesSet) {
                        int next = Integer.MAX_VALUE;
                        for (int k = i+1; k < refs.length; k++) {
                            if (refs[k] == p) { next = k; break; }
                        }
                        if (next > farthest) { farthest = next; toRemove = p; }
                    }
                    framesSet.remove(toRemove);
                    framesSet.add(page);
                }
            }
            return faults;
        }
    }

    public static void main(String[] args) {
        int[] refs = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3}; // example
        int frames = 3;
        PageReplacement fifo = new FIFOReplacement(frames);
        PageReplacement lru = new LRUReplacement(frames);
        PageReplacement opt = new OptimalReplacement(frames);

        System.out.println("Refs: " + Arrays.toString(refs));
        System.out.println("Frames: " + frames);
        System.out.println("FIFO faults: " + fifo.run(refs));
        System.out.println("LRU faults:  " + lru.run(refs));
        System.out.println("OPT faults:  " + opt.run(refs));
    }
}
