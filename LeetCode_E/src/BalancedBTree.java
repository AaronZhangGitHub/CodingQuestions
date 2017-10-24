public class BalancedBTree {
    //https://leetcode.com/problems/balanced-binary-tree/description/
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root)==-1){
            return false;
        }
        return true;
    }
    public int checkHeight(TreeNode root){
        if(root == null){return 0;}
        int leftHeight = checkHeight(root.left);
        if(leftHeight==-1){return -1;}
        int rightHeight = checkHeight(root.right);
        if(rightHeight==-1){return-1;}
        if(Math.abs(leftHeight-rightHeight)>1){return -1;}
        return 1+Math.max(leftHeight,rightHeight);
    }
}
