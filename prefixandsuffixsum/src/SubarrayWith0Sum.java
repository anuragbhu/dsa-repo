import java.util.HashSet;

public class SubarrayWith0Sum {
    static boolean findsum(int arr[],int n)
    {
        // First element 0.
        if(arr[0] == 0) {
            return true;
        }

        for(int i = 0; i < n; i++) {
            int sum = arr[i];

            // In between 0 found.
            if(sum == 0) {
                return true;
            }
            for(int j = i+1; j < n; j++) {
                sum += arr[j];

                if(sum == 0) {
                    return true;
                }
            }
        }
        // Not found.
        return false;
    }

    static boolean findsum1(int arr[],int n)
    {
        // First element 0.
        if(arr[0] == 0) {
            return true;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum == 0) {
                return true;
            }

            boolean isExist = set.contains(sum);

            if(isExist) {
                return true;
            } else {
                set.add(sum);
            }
        }

        // Not found.
        return false;
    }
}
