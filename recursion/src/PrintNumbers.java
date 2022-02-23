public class PrintNumbers {

    public static void printInAscending(int n) {
        if(n == 0) {
            return;
        }
        printInAscending(n-1);
        System.out.println(n);
    }

    public static void printInDescending(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printInDescending(n-1);
    }

    public static void main(String[] args) {
//        printInDescending(10);
        printInAscending(10);
    }
}
