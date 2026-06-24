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

class DAY3 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        if (root.val < val)
            return searchBST(root.right, val);
        return null;
    }

    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return isValid(root,min,max);
    }
    public boolean isValid(TreeNode root , long min, long max){
        if(root==null) return true;
        if(!(root.val>min && root.val<max)) return false;
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int large = Math.max(p.val,q.val);
        int min = Math.min(p.val,q.val);
        while(root!=null){
            if(root.val>large) root=root.left;
            else if(root.val<min) root=root.right;
            else return root;
        }
        return null;
    }
}