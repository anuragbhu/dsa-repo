public class HouseRobber {
    public int rob(int[] nums) {

        int n = nums.length;
        int index = 0;
        return houseRobbers(nums, 0, n);
    }

    public static int houseRobbers(int[] nums, int index, int n) {
        if(index >= n)
            return 0;

        int option1 = nums[index] + houseRobbers(nums, index + 2, n);
        int option2 = houseRobbers(nums, index + 1, n);

        return Math.max(option1, option2);
    }
}
