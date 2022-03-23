import java.util.ArrayList;

// For getting O(1) TC we are using re-hashing for load factor > 0.75.
public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 5; // By Default
        for(int  i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hc = key.hashCode(); // Hash Code ---> TC = O(l), where l is length of string. Taking string for worst-case
        // Compare length of string with 10^5 entries. Then it will be negligible.
        // Hashcode implementation is very good according to the scientists, and it gives unique distribution.

        // Negative hashcode is perfectly valid! But for this impl using positive value only.
        return (Math.abs(hc) % numBuckets); // compression
    }

    private void reHash() {
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int  i = 0; i < 2*numBuckets; i++) {
            buckets.add(null);
        }
        count = 0;
        numBuckets *= 2;

        for(int i = 0; i < temp.size(); i++) {
            MapNode<K,V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    // For maintaining O(1), load factor < 0.75 (Default value = 0.75 - The default load factor is 75% of the capacity)
    public void insert(K key, V value) { // TC = O(1)
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        // Element is already here. Just update the value. Traversing on Linked List
        while(head != null) { // TC = O(n/b), where n is number of entries, b is bucket size, n/b = load factor
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Element is not here. Insert at zeroth position of the Linked List.
        head = buckets.get(bucketIndex); // As we now at zeroth position;
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0 * count) / numBuckets;
        if(loadFactor > 0.75) {
            reHash();
        }
    }

    public int size() {
        return count;
    }

    public V getValue(K key) { // TC = O(1)
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        // Element is already here. Just update the value.
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        // Element is not here. Just return null.
        return null;
    }

    public V removeKey(K key) { // TC = O(1)
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        // Element is already here. Just update the value.
        while(head != null) {
            if(head.key.equals(key)) {
                V val = head.value;
                if(prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next); // In case of first node.
                }
                count--;
                return val;
            }
            prev = head;
            head = head.next;
        }
        // Element is not here. Just return null.
        return null;
    }

    public double loadFactor() {
        return (1.0 * count) / numBuckets;
    }
}
