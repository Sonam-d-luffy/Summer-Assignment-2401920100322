  class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class DAY1{
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        if(p.val !=q.val) return false;
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}