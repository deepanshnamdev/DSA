/* class Node {
    int data;
    Node left, right;
    public Node(int d) {
        data = d;
        left = right = null;
    }
} */

class Solution {
    class NodeValue {
        int minValue;
        int maxValue;
        int size;

        NodeValue(int minValue, int maxValue, int size) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.size = size;
        }
    }
    public NodeValue isbst(Node root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = isbst(root.left);
        NodeValue right = isbst(root.right);
        if (left.maxValue < root.data && root.data < right.minValue) {

            return new NodeValue(
                Math.min(root.data, left.minValue),
                Math.max(root.data, right.maxValue),
                left.size + right.size + 1
            );
        }
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.size, right.size)
        );
    }
    static int largestBst(Node root) {
        Solution obj = new Solution();
        return obj.isbst(root).size;
    }
}