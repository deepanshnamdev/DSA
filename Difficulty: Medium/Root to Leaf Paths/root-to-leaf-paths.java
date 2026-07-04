/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void function(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list){
        if(root==null) return ;
        list.add(root.data);
        if(root.left==null && root.right==null) ans.add(new ArrayList<>(list));
        else{
            function(root.left,ans,list);
            function(root.right,ans,list);
        }
        list.remove(list.size()-1);
        
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        function(root,ans,list);
        return ans;
    }
}