public class LCABTree {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            //in left subtree
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val && root.val<q.val){
            //in right subtree
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
