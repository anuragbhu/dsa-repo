import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String ans = "0";

        for(int i = 0; i < str.length(); i++) {
            int len = ans.length();
            if(str.charAt(i) == 'L') {
                for(int j = 0; j < ans.length(); j++) {
                    String temp = Integer.toString(i);
                    if(temp.charAt(0) == ans.charAt(j)) {
                        String left = ans.substring(0, j);
                        String right = ans.substring(j+1, len);
                        String  val = Integer.toString(i + 1);
                        ans = left + val + right;
                        break;
                    }
                }
            } else {
                for(int j = 0; j < ans.length(); j++) {
                    String temp = Integer.toString(i);
                    if(temp.charAt(0) == ans.charAt(j)) {
                        String left = ans.substring(0, j);
                        String right = ans.substring(j+1, len);
                        String  val = Integer.toString(i + 1);
                        ans = left + val + right;
                    }
                }
            }
        }

        for(int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }


//        System.out.println(ans);

        sc.close();
    }

}
