public class PrefixSumOfMatrix {

    public static void prefixSumOfMatrix(int[][] arr) {
        int[][] brr = new int[arr.length][arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            if(i > 0) {
                brr[i][0] = brr[i-1][0] + arr[i][0];
            } else {
                brr[i][0] = arr[i][0];
            }

            for(int j = 1; j < arr[0].length; j++) {
                if(i > 0) {
                    brr[i][j] = brr[i-1][j] + brr[i][j-1] - brr[i-1][j-1] + arr[i][j];
                } else {
                    brr[i][j] = brr[i][j-1] + arr[i][j];
                }
            }
        }

        for(int i = 0; i < brr.length; i++) {
            for (int j = 0; j < brr[0].length; j++) {
                System.out.print(brr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30}, {5, 10, 20}, {2, 4, 6}};
        prefixSumOfMatrix(arr);
    }
}
