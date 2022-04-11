public class FindTownJudge {
    // Time Complexity: O(E^2) Space Complexity: O(N) to store the frequency array.
    public int findJudge(int n, int[][] trust) {

        boolean[] frequency = new boolean[n+1];

        int count = 0, judge = 0;
        for(int[] ele : trust) {
            frequency[ele[0]] = true;
        }

        // 1. The town judge trusts nobody.
        for(int i = 1; i < frequency.length; i++) {
            if(!frequency[i]) {
                judge = i;
            }
        }

        for(int[] ele : trust) {
            if(ele[1] == judge)
                count++;
        }

        // 2. Everybody (except for the town judge) trusts the town judge.
        if(count == n-1)
            return judge;

        return -1;
    }

    // Can be solved using Graph by calculating: In-degree as (n-1) and Out-Degree as 0.
    // Time Complexity: O(E^2) Space Complexity: O(V) + O(V) to store the indegree and outdegree array.
    // TC as in worst case there is 2 edges b/w every pair.
    public int findJudge1(int n, int[][] trust) {

        if(n == 1 && trust.length == 0) return n;

        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for(int[] ele : trust) {
            inDegree[ele[1]]++;
            outDegree[ele[0]]++;
        }

        for(int i = 1; i < outDegree.length; i++) {
            if(inDegree[i] == n-1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
