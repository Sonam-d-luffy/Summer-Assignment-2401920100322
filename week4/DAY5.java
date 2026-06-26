
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
 
class Solution {
    int idx=0;
    HashMap<Integer,Integer> m = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1);
    }
    public TreeNode build(int[] preorder , int st , int end){
        if(st>end) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        int i = m.get(root.val);
        root.left=build(preorder,st,i-1);
        root.right=build(preorder,i+1,end);
        return root;
    }
}
public class DAY5{
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left , root.right);
    }
    public boolean mirror(TreeNode l , TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r ==null) return false;
        return l.val==r.val && mirror(l.left,r.right) && mirror(l.right,r.left);
    }

}
 class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
       StringBuilder s= new StringBuilder("");
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        int size = q.size();
            TreeNode curr = q.poll();
            if(curr==null){
                s.append("null,");
                continue;
            }
            s.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
       }
       return s.toString();
    }
    

    // Decodes your encoded data to tree.
     TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<s.length){
            TreeNode curr= q.poll();
            if(!s[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            if(i<s.length && !s[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
