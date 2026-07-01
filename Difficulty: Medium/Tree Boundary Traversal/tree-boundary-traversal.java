/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }
    
    void addleftboundry(Node root, ArrayList<Integer> ans){
        Node current=root.left;
        while(current!=null){
            if(isLeaf(current)==false)ans.add(current.data);
            if(current.left!=null) current=current.left;
            else current=current.right;
        }
    }
    void addleaf(Node root, ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null) addleaf(root.left,ans);
        if(root.right!=null) addleaf(root.right,ans);
    }
    void addrightboundry(Node root, ArrayList<Integer> ans){
        List<Integer> list=new ArrayList<>();
        Node current = root.right;
        while(current!=null){
            if(isLeaf(current)==false) list.add(current.data);
            if(current.right!=null) current=current.right;
            else current=current.left;
        }
        Collections.reverse(list);
        ans.addAll(list);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> ans= new ArrayList<>();
       if(root==null) return ans;
       if(isLeaf(root)==false) ans.add(root.data);
       addleftboundry(root,ans);
       addleaf(root,ans);
       addrightboundry(root,ans);
       return ans;
    }
}