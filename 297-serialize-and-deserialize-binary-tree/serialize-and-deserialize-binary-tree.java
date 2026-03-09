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
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list.toString();
    }

    void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            list.add(Integer.MIN_VALUE);
            return;
        };
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);
        String[] values = data.split(", ");
        return build(values);
    }
    TreeNode build(String[] values){
        if(Integer.parseInt(values[idx]) == Integer.MIN_VALUE) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[idx]));
        idx++;
        root.left = build(values);
        root.right = build(values);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));