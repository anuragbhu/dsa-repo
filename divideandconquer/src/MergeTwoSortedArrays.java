public class MergeTwoSortedArrays {
    // TC = O(m+n), AS = O(1)
    public static int[] merge(int[] arr, int[] brr) {
        int[] crr = new int[arr.length + brr.length];

        int i = 0, j = 0, k = 0;

        while(i < arr.length && j < brr.length) {
            if(arr[i] <= brr[j]) {
                crr[k] = arr[i];
                i++;
                k++;
            } else {
                crr[k] = brr[j];
                j++;
                k++;
            }
        }

        while(i < arr.length) {
            crr[k] = arr[i];
            i++;
            k++;
        }

        while(j < brr.length) {
            crr[k] = brr[j];
            j++;
            k++;
        }

        return crr;
    }

    public static void main(String[] args) {
        int[] arr = {-4, 10, 15, 20};
        int[] brr = {5, 6, 6, 15, 20, 24};

        int[] crr = merge(arr, brr);

        for(int ele : crr) {
            System.out.print(ele + " ");
        }
    }
}
