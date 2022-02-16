import java.util.LinkedList;

public class LinkedListImpl {
    public static void main(String[] args) {

        // Linked List is a part of the Collection framework present in java.util package.
        // Internally, the LinkedList is implemented using the doubly linked list data structure.

        LinkedList<String> ll = new LinkedList<String>();

        // Adding elements to the linked list
        // This method is used to add an element at the end of the LinkedList.
        ll.add("A");
        ll.add("B");
        ll.add("C");

        // This method is used to add an element at a specific index in the LinkedList.
        ll.add(2, "E");

        // Print Linked List
        System.out.println(ll);

        // Change the element, it can be done using the set() method.
        ll.set(1, "For");

        // This method is used to simply remove an object from the LinkedList.
        // If there are multiple such objects, then the first occurrence of the object is removed.
        ll.remove("B");

        // Method takes an integer value which removes the element present at that specific index in the LinkedList.
        ll.remove(3);

        // This method Inserts the specified element at the beginning of this list.
        ll.addFirst("Hello");

        // This method returns the first element in this list.
        System.out.println(ll.getFirst());

        // This method returns the last element in this list.
        System.out.println(ll.getLast());

        // This method removes and returns the first element from this list.
        ll.removeFirst();

        // This method removes and returns the last element from this list.
        ll.removeLast();


        // Using the Get method and the
        // for loop
        for (int i = 0; i < ll.size(); i++) {
            // This method returns the element at the specified position in this list.
            System.out.print(ll.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : ll)
            System.out.print(str + " ");

        // This method returns true if this list contains the specified element.
        System.out.println(ll.contains("Hi"));

        // This method removes all the elements from this list.
        ll.clear();

    }
}
