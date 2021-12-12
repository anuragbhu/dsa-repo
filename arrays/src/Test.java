import java.io.File;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        int i = 1, n = 5;
        while(i <= n) {
            System.out.println("Hello");
            i++;

            System.out.println(Integer.MIN_VALUE);

            Set<List<Integer>> ls = new HashSet<>();

            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(-1);
            arr.add(0);
            arr.add(1);
            arr.add(2);
            arr.add(-1);
            arr.add(4);
            threeSum(arr);

            /*
            1 -1 0
            0 -1 1
             */
        }
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();

        Collections.sort(A);

//        for(int i = 0; i < A.size(); i++) {
//           System.out.println( A.get(i));
//        }

        for(int i = 0; i < A.size()-2; i++) {
            for(int j = i+1; j < A.size()-1; j++) {
                for(int k=j+1; k < A.size(); k++) {
                    if(A.get(i) + A.get(j) + A.get(k) == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A.get(i));
                        list.add(A.get(j));
                        list.add(A.get(k));
                        set.add(list);
                    }
                }
            }
        }

        for(ArrayList<Integer> s : set) {
            arr.add(s);
            System.out.println(s);
        }


        return arr;

    }
}