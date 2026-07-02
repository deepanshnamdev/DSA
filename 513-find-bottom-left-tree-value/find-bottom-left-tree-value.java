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
class Solution {
    public void function(TreeNode node , int level,Queue<Integer> list ){
        if(node==null)return;
        if(level==list.size()){
            list.add(node.val);
        }
        function(node.left,level+1,list);
        function(node.right,level+1,list);
    }
    public int findBottomLeftValue(TreeNode root) {
        int level=0;
        Queue<Integer> ans=new LinkedList<>();
        function(root,level,ans);
        int finalanswer=0;
        while(!ans.isEmpty()){
        finalanswer=ans.poll();
        }
        return finalanswer;
    }
}