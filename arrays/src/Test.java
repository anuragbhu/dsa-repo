import java.io.File;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<Integer, String> hm1 = new HashMap<Integer, String>(10);
        map.put("vishal", 10); // Adding Elements
        map.put("sachin", 30); // Changing Elements
        hm1.put(10, "Geeks");
        map.remove(4); // Removing Element

        // Getting the value of 25
        System.out.println("The Value is: " + map.get(10));

        System.out.println("Size of map is:- "
                + map.size());

        System.out.println(map);

        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
        }

        // Checking for the Value 'Geeks'
        System.out.println("Is the value 'Geeks' present? " +
                hm1.containsValue("Geeks")); // Time Complexity : O(n)


        // Clearing the hash map using clear()
        hm1.clear();

        // Checking for the emptiness of Map
        System.out.println("Is the map empty? " + hm1.isEmpty());

        // Initialization of a HashMap
        // using Generics
        HashMap<Integer, String> hm2
                = new HashMap<Integer, String>(hm1);

        System.out.println("Mappings of HashMap hm1 are : "
                + hm1);

        System.out.println("Mapping of HashMap hm2 are : "
                + hm2);
    }
}