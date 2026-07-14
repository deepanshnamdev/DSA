/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode present=q.poll();
            if(present==null){
                res.append("null ");
                continue;
            }
            res.append(present.val+" ");
            q.add(present.left);
            q.add(present.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null|| data.length()==0)return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] value=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(value[0]));
        q.add(root);
        for(int i=1;i<value.length;i++){
            TreeNode present=q.poll();
            if(!value[i].equals("null")){
                TreeNode left=new TreeNode(Integer.parseInt(value[i]));
                present.left=left;
                q.add(left);
            }
            if(!value[++i].equals("null")){
                TreeNode right=new TreeNode(Integer.parseInt(value[i]));
                present.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));