import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // TC = O(n), SC = O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            hset.add(nums[i]);
        }
        return hset.size() != nums.length;
    }

    // TC = O(n), SC = O(n)
    public boolean containsDuplicate1(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int count = hmap.containsKey(nums[i]) ? hmap.get(nums[i]) : 0;
            hmap.put(nums[i], count + 1);
        }

        for(int key : hmap.keySet()) {
            if(hmap.get(key) > 1)
                return true;
        }
        return false;
    }

    // TC = O(nlogn), SC = O(1)
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i])
                return true;
        }
        return false;
    }

    // TC = O(n^2), SC = O(1)
    public boolean containsDuplicate3(int[] nums) {
        for(int i = 0; i <= nums.length-2; i++) {
            for(int j = i + 1; j <= nums.length-1; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // TC = O(n), SC = O(n)
    public boolean containsDuplicate4(int[] nums) {
        Set<Integer> distinct = new HashSet<Integer>();
        for(int ele : nums) {
            if(distinct.contains(ele)) {
                return true;
            }
            distinct.add(ele);
        }
        return false;
    }
}
