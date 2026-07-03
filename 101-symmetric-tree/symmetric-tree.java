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
    public boolean function(TreeNode lf,TreeNode rf){
        if(lf==null&& rf==null) return true;
        if(lf==null||rf==null) return false;
        if(lf.val!=rf.val) return false;
        return function(lf.left,rf.right)&& function(lf.right,rf.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode lf= root.left;
        TreeNode rf= root.right;
        return function (lf,rf);
    }
}