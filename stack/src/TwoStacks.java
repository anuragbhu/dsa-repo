public class TwoStacks {

    // Initialize TwoStack.
    int[] stack;
    // top
    int top1;
    int top2;
    int size;

    public TwoStacks(int s) {
        stack = new int[s];
        top1 = -1;
        top2 = s;
        size = s;
    }

    // Push in stack 1.
    public void push1(int num) {
        if(top1+1 == top2) {
            return;
        }
        top1++;
        if(top1 < size) {
            stack[top1] = num;
        }

    }

    // Push in stack 2.
    public void push2(int num) {
        if(top1 == top2-1) {
            return;
        }
        top2--;
        if(top2 >= 0) {
            stack[top2] = num;
        }

    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        if(top1 < 0 || top1 > size-1){
            return -1;
        }

        int top = stack[top1];
        top1--;
        return top;
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        if(top2 < 0 || top2 > size-1){
            return -1;
        }

        int top = stack[top2];
        top2++;
        return top;
    }
}
