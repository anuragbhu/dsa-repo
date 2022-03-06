import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapImpl {
    public static void main(String[] args) {
        // Map in Java

        // HashMap<K, V>
        // One object is used as a key (index) to another object (value).
        // If you try to insert the duplicate key, it will replace the element of the corresponding key.
        // It allows null keys, but there should be only one null key object & there can be any number of null values.
        // This class makes no guarantees as to the order of the map.
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
        Integer count1 = freq.get("word");
        if (count1 == null) {
            freq.put("word", 1);
        }
        else {
            freq.put("word", count + 1);
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
        System.out.println();
        // On Java 10+:
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        /*
        Note: From Java 8 onward, Java has started using Self Balancing BST instead of a linked list for chaining.
        The advantage of self-balancing bst is, we get the worst case (when every key maps to the same slot)
        search time is O(Log n).
         */

        int val = map.getOrDefault("Anurag", -1);
        System.out.println("getOrDefault :" + val);

        for (String key : map.keySet()) {
            System.out.println(key + "/" + map.get(key));
        }

        // Three ways: HashMap, LinkedHashMap, TreeMap

        // LinkedHashMap in Java
        // The LinkedHashMap Class is just like HashMap with an additional feature of maintaining an order of
        // elements inserted into it.

        // Initialization of a LinkedHashMap using Generics
        LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();
        hm.put(3, "Geeks");
        hm.put(2, "Geeks");
        hm.put(1, "Geeks");
        hm.put(4, "For");

        // Printing the mappings to the console
        System.out.println("Initial Map : " + hm);

        // Removing the mapping with Key 4
        hm.remove(1);

        System.out.println("Updated Map : " + hm);

        // TreeMap in Java
        // The map is sorted according to the natural ordering of its keys
        // TreeMap in Java does not allow null keys (like Map) and thus a NullPointerException is thrown.
        // However, multiple null values can be associated with different keys.
        TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();
    }
}
