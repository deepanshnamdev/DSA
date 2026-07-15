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
    //     solve(root.left,ans);
    //     ans.add(root.val);
    //     solve(root.right,ans);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        // left  root rigth
        // List<Integer>ans=new ArrayList<>();
        // solve(root,ans);
        // return ans;

        // iterative Inorder Traversal

        // List<Integer> inorder=new ArrayList<>();
        // Stack<TreeNode> st=new Stack<>();
        // TreeNode node=root;
        // while(true){
        //     if(node!=null){
        //         st.push(node);
        //         node=node.left;
        //     }
        //     else{
        //         if(st.isEmpty()){
        //             break;
        //         }
        //     node=st.pop();
        //     inorder.add(node.val);
        //     node=node.right;
        //     }
        // }
        // return inorder;

        //Morris Traversal

        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode current= root;
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
                    current=current.left;
                }
                else{
                    pre.right=null;
                    ans.add(current.val);
                    current=current.right;
                }
            }
        }
        return ans;
    }
}