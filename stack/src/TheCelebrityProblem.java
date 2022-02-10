import java.util.Stack;

public class TheCelebrityProblem {
    //Function to find if there is a celebrity in the party or not.
    public static int celebrity(int M[][], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int person = -1;

        for(int i = 0; i < n; i++) {
            stack.push(i);
        }

        int count = 0;
        while(count < n-1) {
            int first = stack.pop();
            int second = stack.pop();

            if(M[first][second] == 1) {
                stack.push(second);
            } else {
                stack.push(first);
            }

            count++;
        }

        person = stack.peek();

        // If no such celebrity is present, return -1.
        int noOfPersonCelebrityKnows = 0;
        for(int i = 0; i < n; i++) {
            int check = stack.peek();
            if(M[check][i] == 1) {
                noOfPersonCelebrityKnows++;
            }
        }

        // If it's not real celebrity, return -1.
        int noOfPersonKnowsCelebrity = 0;
        for(int i = 0; i < n; i++) {
            int check = stack.peek();
            if(M[i][check] == 1) {
                noOfPersonKnowsCelebrity++;
            }
        }


        if((noOfPersonCelebrityKnows == 0) && (noOfPersonKnowsCelebrity == n-1)) {
            return person;
        } else {
            return -1;
        }
    }

    public static int celebrity1(int M[][], int n)
    {
        for(int i = 0; i < n ; i++) {
            int noOfPersonCelebrityKnows = 0;
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1)
                    noOfPersonCelebrityKnows++;
            }

            int noOfPersonKnowsCelebrity = 0;
            if(noOfPersonCelebrityKnows == 0) {
                for(int k = 0; k < n; k++) {
                    if(M[k][i] == 1)
                        noOfPersonKnowsCelebrity++;
                }
            }

            if(noOfPersonKnowsCelebrity == n-1)
                return i;
        }

        return -1;

    }

    public static void main(String[] args) {
        int[][] M = {{0,1,0},{0,0,0}, {0,1,0}};
        System.out.println(celebrity1(M, 3));
    }
}
