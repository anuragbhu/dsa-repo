import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(V + E) Space Complexity: O(V + E) +  O(V) to store the adj list and in-degree array.
public class CourseSchedule {
    // BFS Traversal:
    // First cover courses whose in-degree is zero. This reduces the in-degree of dependent
    // courses and now cover dependent courses whose in-degree is zero. And this pattern goes on.

    // In case of cycle, nothing is pushed into the queue.
    // Ex: [[1,0],[0,1]] has in-degree of each course as 1.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Creating Adj List and making counting in-degree of each node.
        for(int[] ele : prerequisites) {
            int source = ele[0];
            int destination = ele[1];
            adj.get(source).add(destination);
            inDegree[destination]++;
        }

        Queue<Integer> pendingVertices = new LinkedList<>();
        int count = 0;

        // Adding courses whose indegree is zero.
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                pendingVertices.add(i);
                count++;
            }
        }

        // Simple BFS traversal
        while(!pendingVertices.isEmpty()) {
            int front = pendingVertices.poll();

            for(int ele : adj.get(front)) {
                inDegree[ele]--; // Since, prerequisites course is completed. Now, courses depend
                // on it in-degree becomes one less.
                if(inDegree[ele] == 0) {
                    pendingVertices.add(ele);
                    count++;
                }
            }
        }

        // Conditions will check if all courses are completed or not.
        // In case of cycle, condition becomes false.
        if(count == numCourses) return true;

        return false;
    }
}
