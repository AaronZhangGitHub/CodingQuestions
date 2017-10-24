public class ValidateBST {
    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        return validBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean validBST(TreeNode root, long min, long max) {
        if(root==null){return true;}
        if(root.val<=min||root.val>=max){return false;}
        return (validBST(root.left,min,root.val) && validBST(root.right,root.val,max));
    }
}
