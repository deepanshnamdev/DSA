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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildtree(preorder,Integer.MAX_VALUE);
    }
    public TreeNode buildtree(int[] preorder,int starting_value){
        if(index==preorder.length || preorder[index]>starting_value) return null;
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=buildtree(preorder,root.val);
        root.right=buildtree(preorder,starting_value);
        return root;
    }
}