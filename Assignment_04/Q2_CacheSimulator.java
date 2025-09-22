package Assignment_04;
import java.util.*;

public class Q2_CacheSimulator {

    static abstract class Cache {
        final int cacheSize; // number of lines
        Cache(int size) { this.cacheSize = size; }
        abstract boolean fetch(int address); // returns true if hit
    }

    // Direct mapping: line = address % cacheSize
    static class DirectMappedCache extends Cache {
        Integer[] lines;
        DirectMappedCache(int size) {
            super(size);
            lines = new Integer[size];
        }

        @Override
        boolean fetch(int address) {
            int line = address % cacheSize;
            Integer tag = lines[line];
            if (tag != null && tag == address) {
                System.out.printf("Address %d -> HIT (line %d)%n", address, line);
                return true;
            } else {
                lines[line] = address;
                System.out.printf("Address %d -> MISS (mapped to line %d), replaced tag=%s%n", address, line, tag);
                return false;
            }
        }
    }

    // Fully associative with LRU replacement using LinkedHashMap (access-order = true)
    static class AssociativeCache extends Cache {
        LinkedHashMap<Integer, Integer> map; // key=address, value=dummy
        AssociativeCache(int size) {
            super(size);
            map = new LinkedHashMap<>(size, 0.75f, true);
        }

        @Override
        boolean fetch(int address) {
            if (map.containsKey(address)) {
                map.get(address); // update recency
                System.out.printf("Address %d -> HIT (associative)%n", address);
                return true;
            } else {
                if (map.size() >= cacheSize) {
                    Integer oldest = map.keySet().iterator().next();
                    map.remove(oldest);
                    System.out.printf("Evicting %d%n", oldest);
                }
                map.put(address, 1);
                System.out.printf("Address %d -> MISS (stored associative)%n", address);
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[] addresses = {0, 4, 1, 0, 8, 4, 12, 1, 4, 0};
        System.out.println("=== Direct Mapped Cache (size 4) ===");
        Cache d = new DirectMappedCache(4);
        int hits=0, misses=0;
        for (int a : addresses) {
            if (d.fetch(a)) hits++; else misses++;
        }
        System.out.printf("Direct: hits=%d misses=%d%n%n", hits, misses);

        System.out.println("=== Associative Cache (size 4) ===");
        Cache assoc = new AssociativeCache(4);
        hits=0; misses=0;
        for (int a : addresses) {
            if (assoc.fetch(a)) hits++; else misses++;
        }
        System.out.printf("Associative: hits=%d misses=%d%n", hits, misses);
    }
}
