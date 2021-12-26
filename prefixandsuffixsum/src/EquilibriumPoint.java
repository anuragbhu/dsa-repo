public class EquilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {

        int leftSum = 0, rightSum = 0;

        for(int i = 0; i <n; i++) {

            for(int j = i+1; j < n; j++) {
                rightSum += arr[j];
            }

            if(leftSum == rightSum) {
                return (i+1); // 1 based indexing.
            }

            leftSum += arr[i];
            rightSum = 0;
        }

        return -1;
    }

    public static int equilibriumPoint1(long arr[], int n) {

        int leftSum = 0, rightSum = 0;

        for(int i = 0; i < n; i++) {

            rightSum += arr[i];
        }

        for(int i = 0; i < n; i++) {

            rightSum -= arr[i];

            if(leftSum == rightSum) {
                return (i+1);
            }

            leftSum += arr[i];
        }

        return -1;
    }
}
