public class QueueUse {

    public static void main(String[] args) {
        QueueUsingArray queueUsingArray = new QueueUsingArray(3);
        int[] arr = {10, 20, 30, 40, 50};
        for(int elem : arr) {
//            try {
                queueUsingArray.enqueue(elem);
//            } catch (QueueFullException e) {
//                e.printStackTrace();
//            }
        }

        while(!queueUsingArray.isEmpty()) {
            try {
                System.out.println(queueUsingArray.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}