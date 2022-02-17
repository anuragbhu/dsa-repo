import java.util.HashMap;

public class LRUCache {

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int k, int v) {
            key = k;
            val = v;
            next = null;
            prev = null;
        }
    }

    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void update(Node node) {
        // Remove from the current location
        Node prev = node.prev;
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = prev;

        // Place at the head
        node.next = head.next;
        // if(head.next != null)
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void delete() {
        Node toRemove = tail.prev;
        tail.prev = toRemove.prev;
        toRemove.prev.next = tail;
        map.remove(toRemove.key);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            update(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {


        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.val = value;
            update(existing);
            return;
        }

        Node entry = new Node(key, value);
        if (map.size() == cap) {
            delete();
        }
        update(entry);
        map.put(key, entry);
    }
}
