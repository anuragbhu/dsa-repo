import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    // TC = O((nums1.length + nums2.length)log(nums1.length + nums2.length)), AS = O(nums1.length + nums2.length)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];

        int j = 0;
        for(int i = 0; i < nums1.length; i++) {
            arr[j] = nums1[i];
            j++;
        }

        for(int i = 0; i < nums2.length; i++) {
            arr[j] = nums2[i];
            j++;
        }

        Arrays.sort(arr);

        int len = len1 + len2;
        double ans = 0d;

        if(len % 2 == 0) {
            len /= 2;
            int temp1 = arr[len];
            len--;
            int temp2 = arr[len];

            ans = ((double) (temp1 + temp2)) / 2;
        } else {
            len /= 2;
            ans = arr[len];
        }


        return ans;

    }

    // TC = O(nums1.length + nums2.length), AS = O(nums1.length + nums2.length)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] crr = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        while(i < len1 && j < len2) {
            if(nums1[i] <= nums2[j]) {
                crr[k] = nums1[i];
                i++;
                k++;
            } else {
                crr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < nums1.length) {
            crr[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length) {
            crr[k] = nums2[j];
            j++;
            k++;
        }

        int len = len1 + len2;
        double ans = 0d;

        if(len % 2 == 0) {
            len /= 2;
            int temp1 = crr[len];
            len--;
            int temp2 = crr[len];

            ans = ((double) (temp1 + temp2)) / 2;
        } else {
            len /= 2;
            ans = crr[len];
        }


        return ans;

    }
}
