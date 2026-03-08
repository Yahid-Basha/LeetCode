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
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root != null) curr = root;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        curr = stack.pop();
        TreeNode node = curr.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */