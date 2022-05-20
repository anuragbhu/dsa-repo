public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int count = 0;

        for(int i = low+1; i <= high; i++) {
            if(arr[i] <= pivot) {
                count++;
            }
        }

        int pivotIndex = low + count;
        arr[low] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        int i = low, j = high;

        while(i < pivotIndex && j > pivotIndex) {
            if(arr[i] <= pivot) {
                i++;
            } else if(arr[j] > pivot) {
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }
}
