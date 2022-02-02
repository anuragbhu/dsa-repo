public class StackUse {

    public static void main(String[] args) throws StackFullException, StackEmptyException {

//        StackUsingArray stack = new StackUsingArray();
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        int[] arr = {1, 2, 3, 4, 5};

        for (int j : arr) {
            stack.push(j);
        }

        while (! stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        stack.push(10);
        System.out.println(stack.pop());
//        System.out.println(stackUsingArray.pop());
        System.out.println(stack.size());
    }
}
