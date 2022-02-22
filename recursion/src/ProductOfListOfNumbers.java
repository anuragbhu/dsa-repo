public class ProductOfListOfNumbers {

    public static int product(int[] arr, int index) {
        if(index == arr.length){
            return 1;
        }
        return arr[index] * product(arr, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        System.out.println(product(arr, 0));

    }
}
