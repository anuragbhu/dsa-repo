import java.util.Arrays;
import java.util.HashSet;

public class UnionOfTwoArrays {
    // Sort both arrays, use two pointers --- Condn - Duplicates not present in the arrays
    // TC = O(nlogn), AS = O(1)
    public static int doUnion(int a[], int n, int b[], int m) {
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        int i = 0, j = 0;

        while(i < n && j < m) {
            if(a[i] < b[j]) {
                i++;
                count++;
            } else if(a[i] > b[j]) {
                j++;
                count++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        while(i < n) {
            i++;
            count++;
        }
        while(j < m) {
            j++;
            count++;
        }
        return count;
    }

    // Use hash set
    // TC = O(n), AS = O(n)
    public static int doUnion1(int a[], int n, int b[], int m) {
        HashSet<Integer> union = new HashSet<>();
        for(int i = 0; i<n; i++) union.add(a[i]);
        for(int i = 0; i<m; i++) union.add(b[i]);
        return union.size();
    }
}
