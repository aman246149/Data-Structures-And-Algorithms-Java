import java.util.ArrayList;
import java.util.LinkedList;



public class BinaryTreeQuestions extends BinaryTree{
    public static void main(String[] args) {
      BinaryTreeQuestions bt=new BinaryTreeQuestions();
      bt.createBinaryTree();
    //   boolean ans=BinaryTreeQuestions.findElementInBinaryTree(bt.root, 7);
    //   System.out.println(ans);
    //   path.forEach(action->System.out.println(action));
    //   BinaryTreeQuestions.printKlevelDowns(bt.root, 2);
    // BinaryTreeQuestions.printKLevelsFar(bt.root,5,1);
    // BinaryTreeQuestions.rootToLeafPathWithGivenRange(bt.root, " ", 0, 1, 10);
    // bt.levelOrderTraversal(bt.root);
    bt.levelOrderTraversal(bt.root);
    // BinaryTreeQuestions.printLeafNode(bt.root);
     System.out.println( bt.TopViews(bt.root));
    }
    static ArrayList<TreeNode> path=new ArrayList<>();
   
    static boolean findElementInBinaryTree(TreeNode root,int searchkey){
        
        if (root==null) {
            return false;
        }

        if (root.data==searchkey) {
            path.add(root);
            return true;
        }

        boolean lp=findElementInBinaryTree(root.left, searchkey);
        if (lp) {
            path.add(root);
            return true;
        }

        boolean rp=findElementInBinaryTree(root.right, searchkey);
            if (rp) {
                path.add(root);
                return true;
            }
        

        return false;
    }

    static void printKlevelDowns(TreeNode root,int k,TreeNode blocker){
        if (root==null || k<0 || root==blocker) {
            return;
        }

        if (k==0) 
            System.out.println(root.data);
          
            printKlevelDowns(root.left, k-1,blocker);
            printKlevelDowns(root.right, k-1,blocker);
        
    }

    static void printKLevelsFar(TreeNode root,int search,int k){
        findElementInBinaryTree(root, search);

        for (int i = 0; i < path.size(); i++) {
            printKlevelDowns(path.get(i),k-i,i==0?null:path.get(i-1));
        }
    }

    static void rootToLeafPathWithGivenRange(TreeNode node,String path,int sum,int lo,int hi){
        if(node.left != null && node.right != null){
            rootToLeafPathWithGivenRange(node.left, path + node.data + " ", sum + node.data, lo, hi);
            rootToLeafPathWithGivenRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
          } else if(node.left != null){
            rootToLeafPathWithGivenRange(node.left, path + node.data + " ", sum + node.data, lo, hi);
          } else if(node.right != null){
            rootToLeafPathWithGivenRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
          } else {
            path += node.data;
            sum += node.data;
      
            if(sum >= lo && sum <= hi){
              System.out.println(path);
            }
          }

    }

    static void printLeafNode(TreeNode root){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            System.out.println(root.data);
            return;
        }

        printLeafNode(root.left);
        printLeafNode(root.right);
    }


    public static class verticalPair {
        TreeNode node = null;
        int hl = 0; // horizontal Level

        verticalPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    // ans = {minHl,maxHL}
    public static void width(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }

    public static ArrayList<Integer> TopViews(TreeNode root) {
        LinkedList<verticalPair> que = new LinkedList<>();

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add((int) 1e9);

        que.addLast(new verticalPair(root, Math.abs(minMax[0])));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                if (ans.get(rp.hl) == (int) 1e9)
                    ans.set(rp.hl, rp.node.data);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        return ans;
    }
 


    
}
