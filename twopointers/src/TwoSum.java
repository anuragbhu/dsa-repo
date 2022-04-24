import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // TC = O(n^2), AS = O(1)
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];

        for(int i = 0; i <= nums.length-2; i++) {
            for(int j = i + 1; j <= nums.length-1; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }

            }
        }
        return ans;
    }
    // TC = O(n), AS = O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if(hmap.containsKey(ele)) {
                ans[0] = hmap.get(ele);
                ans[1] = i;
                return ans;
            }
            hmap.put(nums[i], i);
        }
        return ans;
    }
    // TC = O(nlogn), AS = O(n)
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        int[] original = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        boolean flag1 = false, flag2 = false;

        while(i < j) {
            if(nums[i] + nums[j] == target) {
                ele1 = nums[i];
                ele2 = nums[j];
                flag1 = true; flag2 = true;
                break;
            } else if(nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        for (int k = 0; k < original.length; k++) {
            if(ele1 == original[k] && flag1) {
                ans[0] = k;
                flag1 = false;
            } else if(ele2 == original[k] && flag2) {
                ans[1] = k;
                flag2 = false;
            }
        }
        return ans;
    }
}
