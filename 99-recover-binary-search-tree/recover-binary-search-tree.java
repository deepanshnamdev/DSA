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
    TreeNode first=null;
    TreeNode last=null;
    TreeNode middle=null;
    TreeNode pre=null;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(pre!=null && (pre.val>root.val)){
            if(first==null){
                first=pre;
                middle=root;
            }
            else{
                last=root;
            }
        }
        pre=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        pre= new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if(first!=null && middle!=null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }
}