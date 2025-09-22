// Q3: Tuple-like Operations
import java.util.*;
class Q3_TupleOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter items separated by spaces: ");
        String input = sc.nextLine();
        List<String> list = new ArrayList<>(Arrays.asList(input.split("\\s+")));

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
        sc.close();
    }
}
/*  Input/Output Example:
    Enter items separated by spaces: apple banana cherry apple date banana
    Repeated Items: [banana, apple]
    Contains 'banana': true
    After removing 'cherry': [apple, banana, apple, date, banana]
    Converted Map: {0=apple, 1=banana, 2=apple, 3=date, 4=banana}
*/