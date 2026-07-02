/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    class Pair{
        Node node;
        int hd;
        Pair(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair current= q.poll();
            Node node=current.node;
            int hd=current.hd;
            map.put(hd,node.data);
            if(node.left!=null){
                q.add(new Pair(node.left,hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,hd+1));
            }
        }
        for(int value:map.values()){
            ans.add(value);
        }
        return ans;
    }
}