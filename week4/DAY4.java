class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class DAY4{

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null ) return false;
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root, int sum, int target){
        if(root==null) return false;
        sum+=root.val;
        if(root.left==null && root.right==null && sum==target) return true;
        boolean l = dfs(root.left,sum,target);
        boolean r = dfs(root.right,sum,target);
        return l||r;
    }
int  ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs1(TreeNode root){
        if(root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans,l+r);
        return Math.max(l,r)+1;

    }
     int ans1 = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans1;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int l = Math.max(0,dfs(root.left));
        int r = Math.max(0,dfs(root.right));
        ans1 = Math.max(ans,l+r+root.val);
        return Math.max(l,r) + root.val;
    }
}
