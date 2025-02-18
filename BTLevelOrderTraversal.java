// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, while going downwards, create a list to add nodes of that level. Initially add all elements of particular level to queue, while q is not
 * empty, add node values to list and add left and right nodes to q. After traversing one level, add that linked list to result. Finally, return
 * result.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* BFS */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = q.size();
            for(int i = 0; i< count;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

/* DFS */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0,result); // initial level at 0
        return result;
    }
    private void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root == null) return;

        if(level == result.size()){
           result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}