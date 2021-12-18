import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int n = a.size();
        int m = a.get(0).size();

        // Transpose
        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<m ; j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }

        // Reverse
        for(int i  = 0; i < a.size(); i++) {
            int start = 0, end = a.get(0).size()-1;
            while (start < end) {
                int temp = a.get(i).get(start);
                a.get(i).set(start,a.get(i).get(end)) ;
                a.get(i).set(end,temp);
                start++;
                end--;
            }
        }
}
