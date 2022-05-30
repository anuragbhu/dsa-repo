import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    // Sort both arrays, use two pointers
    // TC = O(nlogn), AS = O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> arr = new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;

        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }

        int len = arr.size();
        int[] res = new int[len];
        int k = 0;
        for(int ele : arr) {
            res[k++] = ele;
        }
        return res;
    }

    // Use two hash sets
    // TC = O(n), AS = O(2n)
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>(); // nums1
        HashSet<Integer> intersect = new HashSet<>(); // nums2

        for (int ele : nums1) {
            set.add(ele);
        }

        for (int ele : nums2) {
            if (set.contains(ele))
                intersect.add(ele);
        }

        int len = intersect.size();
        int[] res = new int[len];
        int k = 0;
        for(int ele : intersect) {
            res[k++] = ele;
        }
        return res;
    }
}
