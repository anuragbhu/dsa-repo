import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrintArrayInReverse {
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) throws IOException {
        // try {
        //   FileOutputStream output = new FileOutputStream("temp.out");
        //   PrintStream out = new PrintStream(output);
        //   //Diverting the output stream into file "temp.out".Comment the below line to use console
        //   System.setOut(out);

        //   InputStream input = new FileInputStream("temp.in");
        //   //Diverting the input stream into file "temp.in".Comment the below line to use console
        //   System.setIn(input);

        // } catch (FileNotFoundException e) {
        //   e.printStackTrace();
        // }

        FastReader sc = new FastReader();
        PrintWriter wr = new PrintWriter(System.out);

        int t = 1;
        // t = sc.nextInt();    //Comment this line if there is single test case

        while((t--) != 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int start = 0, end = n-1;

            while(start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }

            for(int i = 0; i < n; i++) {
                wr.println(arr[i]);
            }


        }
        wr.flush();
        wr.close();
    }

}
