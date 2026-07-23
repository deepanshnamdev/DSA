/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node Predecessor =null;
    Node Successor=null;
    public void findSuccessor(Node root, int key){
        if(root==null) return ;
        while(root!=null){
            if(key>=root.data){
                root=root.right;
            }
            else{
                Successor=root;
                root=root.left;
            }
        }
    }
    public void findPredecessor(Node root,int key){
        if(root==null) return ;
        while(root!=null){
            if(root.data<key){
                Predecessor=root;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        findPredecessor(root,key);
        findSuccessor(root,key);
        ArrayList<Node>ans=new ArrayList<>();
        ans.add(Predecessor);
        ans.add(Successor);
        return ans;
    }
}