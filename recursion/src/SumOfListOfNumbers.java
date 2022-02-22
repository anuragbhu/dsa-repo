public class SumOfListOfNumbers {
    public static int sum(int[] arr, int index) {
        if(index == arr.length){
            return 0;
        }
        return arr[index] + sum(arr, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        System.out.println(sum(arr, 0));

    }
}
