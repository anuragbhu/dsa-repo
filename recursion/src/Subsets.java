import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> a = new ArrayList<>();

        int n = nums.length;
        int count = 1 << n;

        for(int i = 0; i < count; i++) {

            List<Integer> result = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    result.add(nums[j]);
            }

            a.add(result);

        }

        return a;
    }
}
