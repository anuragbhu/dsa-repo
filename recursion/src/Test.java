public class Test {

    public static String[] upper(String[] arr, int index) {
        if(index == arr.length){
            return arr;
        }
        arr[index] = arr[index].toUpperCase();
        return upper(arr, index+1);
    }

    public static void main(String[] args) {
        String[] arr = {"Hi", "Hello", "Bye"};

        upper(arr, 0);

        for(String temp : arr) {
            System.out.println(temp);
        }
    }
}
