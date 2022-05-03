public class SelectionSort {
    int  select(int[] arr, int i)
    {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int j = i; j < arr.length; j++) {
            if(arr[j] < minValue) {
                minValue = arr[j];
                minIndex = j;
            }
        }

        return minIndex;
    }

    void selectionSort(int[] arr, int n)
    {
        for(int i = 0; i <  arr.length-1; i++) {
            int minIndex = select(arr, i);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
