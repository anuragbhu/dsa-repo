public class InsertionSort
{
    private static void insert(int[] arr, int i)
    {
        for(int j = i; j > 0; j--) {
            if(arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            } else {
                break;
            }
        }
    }
    //Function to sort the array using insertion sort algorithm.
    public void insertionSort(int[] arr, int n)
    {
        for(int i = 1; i < n; i++) {
            if(arr[i-1] > arr[i]) {
                insert(arr, i);
            }
        }
    }
}
