import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxOccuringWord {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        // It will add "" in array if str = "";
        String[] arr = str.split("\\s+");

        int noOfOccur = 0;
        String occur = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        // Approach 2
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])) {
                int value = hashMap.get(arr[i]);
                value++;
                hashMap.put(arr[i], value);
            } else {
                hashMap.put(arr[i], 1);
            }
        }

        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int value = entry.getValue();
            if(value > noOfOccur) {
                noOfOccur = value;
                occur = entry.getKey();
            }
        }

        // Approach 1
//        for(int i = 0; i < arr.length; i++) {
//
//            int count = 1;
//            for(int j = i+1; j < arr.length; j++) {
//                if(arr[i].equals(arr[j])) {
//                    count++;
//                }
//            }
//            if(count > noOfOccur) {
//                noOfOccur = count;
//                occur = arr[i];
//            }
//        }

        System.out.println("Most occuring string is " + occur + " with occurence as " + noOfOccur);
    }
}
