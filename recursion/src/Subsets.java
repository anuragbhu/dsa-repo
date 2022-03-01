import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> a = new ArrayList<>();

        int n = nums.length;
        int count = 1 << n;

        for(int i = 0; i < count; i++) {
            List<Integer> result = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    result.add(nums[j]);
            }

            a.add(result);

        }

        return a;
    }


    List<List<Integer>> res = new ArrayList<>();

    // for each index we have two options, whether include or not include
    // list contains current list of possible number for a subset
    public void generate(List<Integer> list, int index, int[] nums) {

        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // index element not to include in the subset
        generate(list, index+1, nums);


        // index element to include in the subset
        list.add(nums[index]);
        generate(list, index+1, nums);

        // backtracking step
        list.remove(list.size() - 1);
    }


    public List<List<Integer>> subsets1(int[] nums) {

        generate(new ArrayList<>(), 0, nums);
        return res;
    }
}
