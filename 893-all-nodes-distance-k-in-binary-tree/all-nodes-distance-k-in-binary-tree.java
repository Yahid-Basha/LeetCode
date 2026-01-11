/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        getDist(root, target, ans, k);
        return ans;
    }
    public int getDist(TreeNode root, TreeNode target, List<Integer> ans, int k){
        if(root == null) return -1;
        if(root == target){
            getChildrenAtK(root, ans, k);
            return 0;
        }

        int leftDist = getDist(root.left, target, ans, k);
        if(leftDist != -1){
            if(leftDist+1 == k) ans.add(root.val);
            else{
                getChildrenAtK(root.right, ans, k-leftDist-2);
            }
            return leftDist+1;
        }
        int rightDist = getDist(root.right, target, ans, k);
        if(rightDist != -1){
            if(rightDist+1 == k) ans.add(root.val);
            else{
                getChildrenAtK(root.left, ans, k-rightDist-2);
            }
            return rightDist+1;
        }
        return -1;
        
    }
    public void getChildrenAtK(TreeNode root, List<Integer> ans, int k){
        if(root == null) return;
        if(k == 0){
            ans.add(root.val);
            return;
        }
        getChildrenAtK(root.left, ans, k-1);
        getChildrenAtK(root.right, ans, k-1);
    }
}