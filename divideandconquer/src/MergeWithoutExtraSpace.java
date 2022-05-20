import java.util.Arrays;

public class MergeWithoutExtraSpace {

    // TC = O((arr1.length + arr2.length)log(arr1.length + arr2.length)), AS = O(arr1.length + arr2.length)
    public static void merge1(long[] arr1, long[] arr2, int n, int m) {
        long[] crr = new long[arr1.length + arr2.length];

        for(int x = 0; x < arr1.length; x++) {
            crr[x] = arr1[x];
        }

        for(int x = 0; x < arr2.length; x++) {
            crr[arr1.length+x] = arr2[x];
        }

        Arrays.sort(crr);

        for(int x = 0; x < arr1.length; x++) {
            arr1[x] = crr[x];
        }

        for(int x = 0; x < arr2.length; x++) {
            arr2[x] = crr[arr1.length + x];
        }
    }

    // TC = O(arr1.length + arr2.length), AS = O(arr1.length + arr2.length)
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        long[] crr = new long[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                crr[k] = arr1[i];
                i++;
                k++;
            } else {
                crr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < arr1.length) {
            crr[k] = arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length) {
            crr[k] = arr2[j];
            j++;
            k++;
        }

        for(int x = 0; x < arr1.length; x++) {
            arr1[x] = crr[x];
        }

        for(int x = 0; x < arr2.length; x++) {
            arr2[x] = crr[arr1.length + x];
        }
    }
}
