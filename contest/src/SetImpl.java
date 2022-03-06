import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImpl {

    public static void main(String[] args) {

        // Set in Java
        // The set interface is present in java.util package and
        // extends the Collection interface is an unordered collection of objects in which
        // duplicate values cannot be stored
        // same as mathematical set.
        // Set is an interface, objects cannot be created
        // We always need a class that extends this list in order to create an object.
        // Three ways: HashSet, LinkedHashSet, TreeSet

        // HashSet class which is implemented in the collection framework, is an
        // inherent implementation of the hash table data structure (do not guarantee to be inserted in the same order.)
        // This class also allows the insertion of NULL elements.

        // LinkedHashSet class which is implemented in the collection's framework,
        // is an ordered version (the order in which they were inserted),
        // of HashSet that maintains a doubly-linked List across all elements.
        Set<String> lh = new LinkedHashSet<>();

        // TreeSet which is an implementation of a self-balancing tree.
        // Objects are stored in sorted, ascending order.
        // The insertion of null values into a TreeSet throws NullPointerException
        Set<String> ts = new TreeSet<>();

        Set<String> hash_Set = new HashSet<>();
        Set<String> hs = new HashSet<>();

        // Adding elements to the Set : return boolean value
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hs.add("A");
        hs.add("B");
        hs.add("C");

        // Printing elements of HashSet object i.e. [Geeks, For]
        System.out.println(hash_Set);

        // Declaring a string
        String check = "A";

        // Check if the above string exists in
        // the SortedSet or not
        // using contains() method
        System.out.println("Contains " + check + " "
                + hs.contains(check));

        // Removing custom element
        // using remove() method : return boolean value
        // false
        System.out.println(hs.remove("Z"));


        // Iterating through the Set
        // via for-each loop
        for (String value : hs)
            // Printing all the values inside the object
            System.out.println(value + ", ");

    }
}
