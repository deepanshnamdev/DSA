/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        int value=-1;
        while(root!=null){
            if(root.data==x){
                value=root.data;
                return value;
            }
            if(x>root.data){
                root=root.right;
            }
            else{
                value=root.data;
                root=root.left;
            }
        }
        return value;
    }
}