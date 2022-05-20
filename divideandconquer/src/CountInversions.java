public class CountInversions {

    // TC = O(N^2), SC = O(1)
    static long inversionCount1(long[] arr, long N) {
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }

    // TC = O(NlogN), SC = O(1)
    static long merge(long[] arr, int l, int m, int r) { // change
        int n1 = m - l + 1;
        int n2 = r - m;
        long[] left = new long[n1];
        long[] right = new long[n2];

        for(int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for(int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        long swaps = 0; // change

        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
                swaps += (n1 - i); // change
            }
        }

        while(i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return swaps; // change
    }

    static long mergeSort(long[] arr, int l, int r) { // change
        long count = 0; // change
        if(l < r) {
            int m = l + (r - l)/2;
            count += mergeSort(arr, l, m); // change
            count += mergeSort(arr, m+1, r); // change
            count += merge(arr, l, m, r); // change
        }
        return count; // change
    }

    static long inversionCount(long[] arr, long N) {
        int r = (int) N-1; // change IMP
        return mergeSort(arr, 0, r);
    }
}
