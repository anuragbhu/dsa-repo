import java.util.*;

public class GenerateAllBinaryStringsOfNBits {

    public static void subsets(int n) {

        List<String> a = new ArrayList<>();

        int count = 1 << n;

        for(int i = 0; i < count; i++) {

            String result = "";
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    result += "1" + " ";
                } else {
                    result += "0" + " ";
                }
            }
            System.out.println(result);
            a.add(result);
        }

        Collections.sort(a);
        System.out.println(a);
    }

    static void printTheArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Function to generate all binary strings
    static void generateAllBinaryStrings(int n, int[] arr, int i)
    {
        if (i == n)
        {
            printTheArray(arr, n);
            return;
        }

        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);

        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }

    public static void main(String[] args) {
        int n = 2;
//        subsets(n);

        int[] arr = new int[n];
        generateAllBinaryStrings(n, arr, 0);
    }
}
