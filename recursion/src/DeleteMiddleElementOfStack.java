import java.util.Stack;

public class DeleteMiddleElementOfStack {

    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){

        int mid = (int) Math.ceil(sizeOfStack/2.0);
        deleteMidElement(s, sizeOfStack, mid);

    }

    public void deleteMidElement(Stack<Integer> s, int sizeOfStack, int mid){

        if(sizeOfStack == mid) {
            s.pop();
            return;
        }

        int ele = s.pop();
        deleteMidElement(s, sizeOfStack-1, mid);
        s.push(ele);
    }
}
