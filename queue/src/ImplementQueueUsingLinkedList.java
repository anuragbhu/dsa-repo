/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

public class ImplementQueueUsingLinkedList {
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        QueueNode temp = new QueueNode(a);
        if(rear == null && front == null) {
            front = rear =  temp;
            return;
        }
        rear.next = temp;
        rear = rear.next;

    }

    //Function to pop front element from the queue.
    int pop()
    {
        if(front == null) {
            return -1;
        }
        int elem = front.data;
        if(front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return elem;
    }
}
