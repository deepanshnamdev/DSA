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
    // public void solve(TreeNode root,List<Integer>ans){
    //     if(root==null) return;
    //     ans.add(root.val);
    //     solve(root.left,ans);
    //     solve(root.right,ans);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        // // root left rigth
        // List<Integer>ans=new ArrayList<>();
        // solve(root,ans);
        // return ans;
        // List<Integer> preorder = new ArrayList<>();
        // if(root==null) return preorder;
        // Stack<TreeNode> st=new Stack<>();
        // st.push(root);
        // while(!st.isEmpty()){
        //     TreeNode node=st.pop();
        //     preorder.add(node.val);
        //     if(node.right!=null) st.push(node.right);
        //     if(node.left!=null) st.push(node.left);
        // }
        // return preorder;

        //Morris Traversal

        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode current=root;
        while(current!=null){
            if(current.left==null){
                ans.add(current.val);
                current=current.right;
            }
            else{
                TreeNode pre=current.left;
                while(pre.right!=null && pre.right!=current){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=current;
                    ans.add(current.val);
                    current=current.left;
                }
                else{
                    pre.right=null;
                    current=current.right;
                }
            }
        }
        return ans;
    }
}