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
    public TreeNode markparent(TreeNode root,Map<TreeNode , TreeNode> parentmap, int start){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode startNode=null;
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.val==start){
                startNode=current;
            }
            if(current.left!=null){
                parentmap.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parentmap.put(current.right,current);
                q.offer(current.right);
            }
        }
        return startNode;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode , TreeNode> parentmap=new HashMap<>();
        TreeNode startNode= markparent(root,parentmap,start);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        q.offer(startNode);
        visited.put(startNode,true);
        int time=0;
        while(!q.isEmpty()){
            boolean spread=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                    spread=true;
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                    spread=true;
                }
                TreeNode parent=parentmap.get(current);
                if(parent!=null && visited.get(parent)==null){
                    q.offer(parent);
                    visited.put(parent,true);
                    spread=true;
                }
            }
            if(spread==true) time++;
        } 
        return time;
    }
}