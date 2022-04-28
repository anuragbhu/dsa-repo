public class FindSmallestLetterGreaterThanTarget {
    // algorithm with O(log n) runtime complexity.
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;
        char res = letters[0];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(letters[mid] == target) {
                low = mid + 1;
            } else if(letters[mid] < target) {
                low = mid + 1;
            } else {
                res = letters[mid];
                high = mid - 1;
            }
        }
        return res;
    }
}
