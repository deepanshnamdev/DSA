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
    int postindex;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helptobuildtree(postorder,0,inorder.length-1);
    }
    public TreeNode helptobuildtree(int[] postorder,int start,int end){

        if(start>end) return null;

        int value=postorder[postindex--];
        TreeNode root=new TreeNode(value);

        int mid=map.get(value);

        root.right=helptobuildtree(postorder,mid+1,end);
        root.left=helptobuildtree(postorder,start,mid-1);

        return root;

    } 
}