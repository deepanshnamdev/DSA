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
    Map<Integer,Integer> map=new HashMap<>();
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildtree(preorder,0,preorder.length-1);
    }
    public TreeNode buildtree(int[] preorder,int left,int right){
        if(left>right) return null;

        int value=preorder[preindex++];
        TreeNode root=new TreeNode(value);

        int mid=map.get(root.val);

        root.left=buildtree(preorder,left,mid-1);
        root.right=buildtree(preorder,mid+1,right);

        return root;
    }
}