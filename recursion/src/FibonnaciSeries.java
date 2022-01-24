public class FibonnaciSeries {

    public static int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        int last = fib(n-1);
        int secondLast = fib(n-2);

        return last + secondLast;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}