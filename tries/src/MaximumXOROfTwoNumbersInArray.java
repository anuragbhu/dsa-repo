public class MaximumXOROfTwoNumbersInArray {

    // TC = O(n^2) and SC = O(1)
    public int findMaximumXOR(int[] nums) {
        int max = 0; // Declare valuw based on output range min value.
        // Not like Integer.MIN_VALUE;
        int temp = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                temp = nums[i] ^ nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    // Considering 32 bits integer
    // TC= Optimal: O(nlog(MAX_ELEMENT) using Trie
    class TrieNodeBits {
        TrieNodeBits left; // 0
        TrieNodeBits right; // 1

        public TrieNodeBits() {
            left = null;
            right = null;
        }
    }

    // Inserting in the trie
    public void insert(TrieNodeBits root, int num) {
        TrieNodeBits curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i); // Gets bits from most to least significant bits.
            bit &= 1; // Check for current bit

            if(bit == 0) {
                if(curr.left == null) {
                    curr.left = new TrieNodeBits();
                }
                curr = curr.left;
            } else {
                if(curr.right == null) {
                    curr.right = new TrieNodeBits();
                }
                curr = curr.right;
            }
        }
    }

    public int getMaxXor(TrieNodeBits root, int num) {
        TrieNodeBits curr = root;
        int maxXor = 0;

        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.right != null) {
                    curr =  curr.right;
                    maxXor += (1<<i); //pow(2,i)
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                    maxXor += (1<<i);
                } else {
                    curr = curr.right;
                }
            }
        }


        return maxXor;
    }

    public int findMaximumXOR1(int[] nums) {
        TrieNodeBits root = new TrieNodeBits();
        int maxXor = 0;

        for(int num : nums) {
            insert(root, num);
        }

        for(int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(root, num));
        }

        return maxXor;
    }
}
