public class ArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5};
        int n = 6;
        System.out.println(isSorted(arr, n - 1));
    }

    public static boolean isSorted(int[] arr, int n) {

        if (n == 0) {
            return true;
        }

        boolean flag = isSorted(arr, n - 1);

        return (flag && (arr[n - 1] <= arr[n]));
    }
}
