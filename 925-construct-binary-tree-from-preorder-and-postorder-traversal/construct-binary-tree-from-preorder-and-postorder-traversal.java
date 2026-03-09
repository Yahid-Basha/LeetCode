/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
    TreeNode build(int[] preorder, int[] postorder, int preStart, int preEnd, int posStart, int posEnd){
        if(preStart > preEnd || posStart > posEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int j = posStart;
        while(j < postorder.length && preStart < preorder.length-1 && preorder[preStart+1] != postorder[j]) j++;
        int k = j-posStart;
        root.left = build(preorder,postorder, preStart+1, preStart+k+1, posStart, posStart+k);
        root.right = build(preorder,postorder, preStart+k+2, preEnd, posStart+k+1, posEnd-1);
        return root;
    }
}