import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] mapping = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = {789,456,123};
        System.out.println(sortJumbled(mapping, nums));
        for(int ans : nums) {
            System.out.println(ans);
        }
        sc.close();
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int original = nums[i];
            int val = 0;
            int tens = 1;
            while(nums[i] > 0) {
                int rem = nums[i] % 10;
                val = (mapping[rem] * tens);
                tens *= 10;
                nums[i] /= 10;

            }
            hmap.put(original, val);
        }

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hmap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int j = 0;

        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            nums[j] = entry.getKey();
            j++;
        }

        return nums;

    }

}
