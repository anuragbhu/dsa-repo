public class StackUse {

    public static void main(String[] args) throws StackFullException, StackEmptyException {

        StackUsingArray stackUsingArray = new StackUsingArray();
        int[] arr = {1, 2, 3, 4, 5};

        for (int j : arr) {
            stackUsingArray.push(j);
        }

        while (! stackUsingArray.isEmpty()) {
            System.out.println(stackUsingArray.pop());
        }

        stackUsingArray.push(10);
        System.out.println(stackUsingArray.pop());
//        System.out.println(stackUsingArray.pop());
        System.out.println(stackUsingArray.size());
    }
}
