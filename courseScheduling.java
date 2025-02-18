// Course Schedule (https://leetcode.com/problems/course-schedule/)

// Time Complexity : O(V+E) 
// Space Complexity : O(V+E) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take an integer array to store the dependency of each subject, hashmap where key is sub that is required to complete the subjects in
 * list of values. While if there is any course that is independent of any subject into queue, and while queue is not empty pop element and 
 * decrease the indegree of the children of popped element and again check indegree if there is any elements indegree is 0 then add that to queue
 * and continue till queue is empty. After queue is empty, check if every element is i indegree is 0, if not return fasle else return true.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< prerequisites.length; i++){
            indegree[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0])){

                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children!=null){
                for(Integer child:children){
                    indegree[child]--;
                    if(indegree[child]==0){
                        q.add(child);
                    }
                }

            }
        }
        for(int i =0;i<indegree.length;i++){
            if(indegree[i]!=0) return false;
        }
        return true;
    }
}
