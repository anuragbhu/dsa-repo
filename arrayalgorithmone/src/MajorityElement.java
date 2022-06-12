import java.util.HashMap;

public class MajorityElement {
    // TC = O(n*n), AS = O(1)
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = n/2;

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] == nums[i])
                    count++;
            }
            if(count > majority)
                return nums[i];
        }
        return -1;
    }

    // TC = O(n), AS = O(n)
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        int majority = n/2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) > majority)
                return key;
        }
        return -1;
    }

    // TC = O(n), AS = O(1)
    // If the element is present more than N / 2 times in the array, its count will never become zero.
    // If always not exist then verify before returning.
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        for(int i = 0; i < n; i++) {
            if(count == 0)
                element = nums[i];

            if(element == nums[i])
                count++;
            else
                count--;
        }
        return element;
    }
}
