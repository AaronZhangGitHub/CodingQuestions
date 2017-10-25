public class LevelOrderTraversal {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null){return retList;}
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            int qSize = q.size();
            for(int i = 0;i<qSize;i++){
                TreeNode currentNode = q.poll();
                l.add(currentNode.val);
                if(!(currentNode.left==null)){q.add(currentNode.left);}
                if(!(currentNode.right==null)){q.add(currentNode.right);}
            }
            retList.add(l);
        }
        return retList;
    }
}
