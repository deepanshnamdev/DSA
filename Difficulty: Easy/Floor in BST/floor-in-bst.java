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
    public int findMaxFork(Node root, int k) {
        int value=-1;
        while(root!=null){
            if(k==root.data){
                value=root.data;
                return value;
            }
            if(k>root.data){
                value=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        } 
        return value;
    }
}