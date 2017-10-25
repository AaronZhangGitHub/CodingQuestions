public class LCABTree {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p||root==q) return root;
        TreeNode llca = lowestCommonAncestor(root.left,p,q);
        TreeNode rlca = lowestCommonAncestor(root.right,p,q);
        if(llca!=null && rlca!=null) return root;
        return (llca==null)?rlca:llca;
    }
}
