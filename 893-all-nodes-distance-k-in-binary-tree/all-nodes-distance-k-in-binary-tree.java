/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markparent(TreeNode root, Map<TreeNode ,TreeNode> mark_parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                mark_parent.put(current.left,current);
                q.offer(current.left);
            }
             if(current.right!=null){
                mark_parent.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode ,TreeNode> mark_parent= new HashMap<>();
        markparent(root,mark_parent);
        Map<TreeNode ,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int count=0;
        while(!q.isEmpty()){
            if(count==k) break;
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                TreeNode parent=mark_parent.get(current);
                if(parent!=null && visited.get(parent)==null){
                    q.offer(parent);
                    visited.put(parent,true);
                }
           }
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            list.add(current.val);
        }
        return list;
    }
}