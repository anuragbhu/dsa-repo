public class FloodFill {
    // DFS Approach
    // Time complexity: O(m*n), space complexity: O(1). m is number of rows, n is number of columns.
    //  connected 4-directionally ---> up, down, left, right
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];

        // Important Condition because it again and again calling by different connected 4-directionally
        // cells recursively when checking for up, down, left, and right.
        if(newColor == original) return image;

        floodFill(image, sr, sc, newColor, original);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int original) {
        if((sr >= 0 && sr < image.length) && (sc >= 0 && sc < image[0].length) && (image[sr][sc] == original)) {
            image[sr][sc] = newColor;
        } else {
            return;
        }

        floodFill(image, sr-1, sc, newColor, original); // up
        floodFill(image, sr+1, sc, newColor, original); // down
        floodFill(image, sr, sc-1, newColor, original); // left
        floodFill(image, sr, sc+1, newColor, original); // right
    }
}
