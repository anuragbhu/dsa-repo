import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        int largestArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) { // i == height

            // Nearest Smaller Left
            int j = 0;
            for(j = i-1; j >= 0; j--) {
                if(heights[j] < heights[i]) {
                    break;
                }
            }

            // Nearest Smaller Right
            int k = 0;
            for(k = i+1; k < heights.length; k++) {
                if(heights[k] < heights[i]) {
                    break;
                }
            }

            int width = k - j - 1;
            int area = heights[i] * width;
            largestArea = Math.max(area, largestArea);
        }

        return largestArea;
    }

    public static int largestRectangleArea1(int[] heights) {

        // Nearest Smaller Element Index on the Right
        int[] rightBoundary = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        rightBoundary[heights.length - 1] = heights.length;

        for(int i = heights.length - 2; i >= 0; i--) {
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.size() == 0) {
                rightBoundary[i] = heights.length;
            } else {
                rightBoundary[i] = stack.peek();
            }
            stack.push(i);
        }


        // Nearest Smaller Element Index on the Left
        int[] leftBoundary = new int[heights.length];
        stack = new Stack<>();
        stack.push(0);
        leftBoundary[0] = -1;

        for(int i = 1; i < heights.length; i++) {
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.size() == 0) {
                leftBoundary[i] = -1;
            } else {
                leftBoundary[i] = stack.peek();
            }
            stack.push(i);
        }

        int largestArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) { // i == height

            int width = rightBoundary[i] - leftBoundary[i] - 1;
            int area = heights[i] * width;
            largestArea = Math.max(area, largestArea);
        }

        return largestArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1};
        System.out.println(largestRectangleArea1(heights));
    }
}
