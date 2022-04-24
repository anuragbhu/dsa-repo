import java.util.*;

public class ThreeSumZero {
    // TC = O(n^3), SC = O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++) {
            for(int j = i + 1; j <= nums.length-2; j++) {
                for(int k = j + 1; k <= nums.length-1; k++) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    if(sum == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        set.add(triplet);
                    }
                }
            }
        }

        for(ArrayList<Integer> ele : set) {
            ans.add(ele);
        }
        return ans;
    }

    // TC = O(n^2), SC = O(1)
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i+1, k = nums.length-1; // j = low, k = high
                while(j < k) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    if(sum == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        ans.add(triplet);

                        while(j < k && nums[j] == nums[j+1]) j++;
                        while(j < k && nums[k] == nums[k-1]) k--;

                        j++; k--;
                    } else if(sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
