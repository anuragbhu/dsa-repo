import java.util.*;
import java.lang.*;
import java.math.*;

public class Test {

    public static void main(String[] args) {
        int aa = Math.abs(-2);
        int bb = (int) Math.floor(-2.56);
        HashMap<String, Integer> map = new HashMap<>();

        // HashMap(int initialCapacity) Constructor
        // Initial Capacity
        // Load Factor
        HashMap<Integer, String> hm1 = new HashMap<>(10);
        map.put("vishal", 10); // Adding Elements
        hm1.put(10, "Geeks");

        // remove element with a key
        map.remove("Hello"); // Removing Element

        // Getting the value of 25
        System.out.println("The Value is: " + map.get("Hello"));

        System.out.println("Size of map is:- "
                + map.size());

        System.out.println(map);

        // Change Value using put method
        map.put("vishal", 100);

        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
            System.out.println("value for key"
                    + " \"vishal\" is:- " + a);
        }

        // Checking for the Value 'Geeks'
        System.out.println("Is the value 'Geeks' present? " +
                hm1.containsValue("Geeks")); // Time Complexity : O(n)


        // Clearing the hash map using clear()
        hm1.clear();

        // Checking for the emptiness of Map
        System.out.println("Is the map empty? " + hm1.isEmpty());

        // HashMap(Map map) Constructor
        HashMap<Integer, String> hm2
                = new HashMap<>(hm1);

        System.out.println("Mappings of HashMap hm1 are : "
                + hm1);

        System.out.println("Mapping of HashMap hm2 are : "
                + hm2);

        // Most efficient way to increment a Map value in Java
        // ContainsKey
        Map<String, Integer> freq = new HashMap<>();
        freq.put("test", 1);
        int count = freq.containsKey("word") ? freq.get("word") : 0;
        freq.put("word", count + 1);

        // TestForNull
        Integer count1 = freq.get("wordq");
        if (count1 == null) {
            freq.put("wordq", 1);
        }
        else {
            freq.put("wordq", count1 + 1);
            System.out.println(freq.get("wordq") + "Test");
        }

        // Key existence check in HashMap
        Integer value = freq.get("word");
        if (value != null) {

        } else {
            // Key might be present...
            if (freq.containsKey("word")) {
                // Okay, there's a key but the value is null
            } else {
                // Definitely no such key
            }
        }

        // How do I efficiently iterate over each entry in a Java Map?
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        // On Java 10+:
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        /*
        Note: From Java 8 onward, Java has started using Self Balancing BST instead of a linked list for chaining.
        The advantage of self-balancing bst is, we get the worst case (when every key maps to the same slot)
        search time is O(Log n).
         */
    }
}