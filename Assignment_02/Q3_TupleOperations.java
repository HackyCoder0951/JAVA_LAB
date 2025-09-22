// Q3: Tuple-like Operations
import java.util.*;
class Q3_TupleOperations {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date"));

        // Find repeated items
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (String item : list) {
            if (!seen.add(item)) repeated.add(item);
        }
        System.out.println("Repeated Items: " + repeated);

        // Check if an item exists
        String toCheck = "banana";
        System.out.println("Contains '" + toCheck + "': " + list.contains(toCheck));

        // Remove an item
        String toRemove = "cherry";
        list.remove(toRemove);
        System.out.println("After removing '" + toRemove + "': " + list);

        // Convert list to map (index -> value)
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
        System.out.println("Converted Map: " + map);
    }
}

/*  Input/Output Example:
    Repeated Items: [apple, banana]
    Contains 'banana': true
    After removing 'cherry': [apple, banana, apple, banana, date]
    Converted Map: {0=apple, 1=banana, 2=apple, 3=banana, 4=date}
*/