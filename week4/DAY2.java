import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class DAY2{
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        traverse(root , ans);
        return ans;
    }
    public void traverse(TreeNode root , List<Integer> ans) {
        if(root==null) return;
        traverse(root.left , ans);
        ans.add(root.val);
        traverse(root.right , ans);
    }

     public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new  ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int c=q.size();
            for(int i=0;i<c;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                l.add(curr.val);
            }
            ans.add(l);
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean zigzag = true;
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int c = q.size();
            for(int i=0;i<c;i++){
                TreeNode curr = q.poll();
                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);
                    if(zigzag) l.add(curr.val);
                    else l.add(0,curr.val);
                
            }
            ans.add(l);
            zigzag=!zigzag;
        }
        return ans;
    }
}