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
    List<Integer> list;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        list = new ArrayList<>();
        preorder(root);
        return list.toString();
    }

    void preorder(TreeNode root){
        if(root == null){
            list.add(-2000);
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);
        String[] values = data.split(", ");
        int[] preorder = new int[values.length];
        int i = 0;
        for (String s : values) {
            preorder[i++] = Integer.parseInt(s);
        }
        return build(preorder, new int[]{0});
    }

    // [1,2,null,null,3,4,null,null,5,null,null]
    TreeNode build(int[] preorder, int idx[]){
        if(preorder[idx[0]] == -2000) {
            idx[0]++;
            return null;
        };
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left = build(preorder, idx);
        root.right = build(preorder, idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));