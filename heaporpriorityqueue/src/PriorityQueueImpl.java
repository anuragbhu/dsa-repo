public class PriorityQueueImpl {
    public static void main(String[] args) throws PriorityQueueException {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.insert("abc", 15);
        priorityQueue.insert("def", 13);
        priorityQueue.insert("ghi", 90);
        priorityQueue.insert("jkl", 150);
        priorityQueue.insert("mno", 120);

        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.removeMin());
        }
    }
}
