import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {

        // DRY RUN: A : [ 34, 35, 27, 42, 5, 28, 39, 20, 28 ]
        // The expected return value:
        // -1 34 -1 27 -1 5 28 5 20
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<Integer>();

        for(int i=0;i<arr.size();++i){
            while(!st.isEmpty() && arr.get(i)<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }
            else{
                res.add(st.peek());
            }
            st.add(arr.get(i));
        }

        return res;
    }
}
