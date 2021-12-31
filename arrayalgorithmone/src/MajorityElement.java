import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int len = nums.length/2;

        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j])
                    count++;
            }

            if(count > len)
                return nums[i];
        }
        return -1;

    }

    public int majorityElement1(int[] nums) {

        int len = nums.length/2;

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {

            int value = hmap.containsKey(nums[i]) ? hmap.get(nums[i]) : 0;
            if (value > 0) {
                hmap.put(nums[i], value + 1);
                if((value+1) > len)
                    return nums[i];
            } else {
                hmap.put(nums[i], 1);
                if(1 > len)
                    return nums[i]; // For single element only.
            }
        }

        // for (Integer value : hmap.keySet())
        // {
        //     int count = hmap.get(value);
        //     if(count > len)
        //         return value;
        // }

        return -1;
    }

    public int majorityElement2(int[] nums) {

        int element = 0, count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0)
                element = nums[i];

            if(element == nums[i])
                count++;
            else
                count--;
        }
        return element; // Iterate to count the frequency of this element whether majority exist ir not.
    }
}
