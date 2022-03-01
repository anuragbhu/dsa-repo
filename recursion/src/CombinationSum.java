import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // For storing result
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Sorting the array
        Arrays.sort(candidates);

        // Now, eleminate the repeating elements in the array
        // But, no need as it contains distinct elements.
        // Otherwise, use set to add eleminate and then create new array of unique elements.

        // Now declaring list for storing one by one combination
        List<Integer> list = new ArrayList<>();

        combination(candidates, target, list, 0); // Initial index zero

        return res;

    }

    public void combination(int[] candidates, int target, List<Integer> list, int index) {

        if(target == 0) {
            res.add(new ArrayList<>(list));
        }

        if(index == candidates.length)
            return;

        while(index < candidates.length && target-candidates[index] >= 0) {
            list.add(candidates[index]);
            combination(candidates, target-candidates[index], list, index);
            index++;
            list.remove(list.size() - 1);
        }
    }
}
