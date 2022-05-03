import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    // TC = O(nlogn), SC = O(1)
    public int[][] merge(int[][] intervals) {

        // declaring an array list to store the pairs
        ArrayList<int[]> list=new ArrayList<>();

        // sorting the given interval array based on starting point
        // As it is not given that intervals are sorted
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);

        // defining start and end point
        int start = intervals[0][0];
        int end = intervals[0][1];

        int i = 1;
        while(i < intervals.length){
            int s = intervals[i][0];
            int e = intervals[i][1];
            // next interval start is smaller than prev end and array is sorted
            // so these two internal can merge
            if(s <= end) {
                // so merge both intervals
                // start of first interval will never change while merging
                end = Math.max(end,e); // [[1,4],[2,3]]
            } else { // if merge not possible, then insert prev interval into list
                list.add(new int[]{start,end});
                start = s;
                end =  e;
            }
            i++;
        }
        // as last pair is not added
        list.add(new int[]{start, end});
        int[][] arr =  new int[list.size()][2];  // list to int[][]
        for(int j = 0; j < list.size(); j++){
            arr[j][0] = list.get(j)[0];
            arr[j][1] = list.get(j)[1];
        }
        return arr;
    }
}
