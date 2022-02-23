public class FibonnaciSeries {

    private static int[] arr = new int[1000000]; // 1 extra to handle case, n = 0
    int mod = (int) 1e9+7;

    public static int fib(int n) {
        if(n == 0 || n == 1)
            return n;

        int last, secondLast;
        if(arr[n-1] != 0) {
            last = arr[n-1];
            secondLast = arr[n-2];
        } else {
            last = fib(n-1);
            secondLast = fib(n-2);
        }

        return last + secondLast;
    }

    public static void main(String[] args) {
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fib(6));
    }
}