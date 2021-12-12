public class BubbleSort {
    //Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[], int n)
    {
        boolean swapHappens = false;
        for(int i = 0; i < n - 1; i++) {
            swapHappens = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapHappens = true;
                }
            }

            if(!swapHappens)
                break;
        }
    }
}
