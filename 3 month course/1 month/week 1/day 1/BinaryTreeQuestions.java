import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;



public class BinaryTreeQuestions extends BinaryTree{
    public static void main(String[] args) {
      BinaryTreeQuestions bt=new BinaryTreeQuestions();
    //   boolean ans=BinaryTreeQuestions.findElementInBinaryTree(bt.root, 7);
    //   System.out.println(ans);
    //   path.forEach(action->System.out.println(action));
    //   BinaryTreeQuestions.printKlevelDowns(bt.root, 2);
    // BinaryTreeQuestions.printKLevelsFar(bt.root,5,1);
    // BinaryTreeQuestions.rootToLeafPathWithGivenRange(bt.root, " ", 0, 1, 10);
    // bt.levelOrderTraversal(bt.root);
    // bt.levelOrderTraversal(bt.root);
    // BinaryTreeQuestions.printLeafNode(bt.root);
    //  System.out.println( bt.TopViews(bt.root));
    // System.out.println(bt.printBoundary(bt.root));
        
        // System.out.println(bt.MinCamerasInBT(bt.root));
        // int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        // for (int x : keys)
        //     bt.createBinaryTree(bt.root, x);
        // bt.kthSmallest(bt.root,3);

        bt.createBinaryTree();
        // bt.sumNumbers(bt.root);
        bt.hasPathSum(bt.root,8);
    //     bt.levelOrderTraversal(bt.root);
    //    System.out.println( bt.solve(bt.root));
        
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
 
   static  ArrayList <Integer> printBoundary(TreeNode node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    
	    if(node==null){
	        return ans;
	    }
	    
	    printLeftTree(node,ans);
	    printLeafNode(node,ans);
	    PrintRightTree(node.right,ans);
	    return ans;
	    
	}
	
    static  void printLeafNode(TreeNode root,ArrayList<Integer> ans){
        if(root ==null){
            return;
        }
        
        printLeafNode(root.left,ans);
        
        if(root.left==null && root.right==null){
            ans.add(root.data);
        }
        
        printLeafNode(root.right,ans);
    }
    static	void printLeftTree(TreeNode root,ArrayList<Integer> ans){
	    if(root==null){
	        return;
	    }
	    if(root.left!=null){
	        ans.add(root.data);
	        printLeftTree(root.left, ans);
	    }else if(root.right!=null){ 
	        ans.add(root.data);
	      printLeftTree(root.right, ans);

	    }
	}
	
    static	void PrintRightTree(TreeNode root,ArrayList<Integer> ans){
        if (root==null) {
            return;
        }

        if (root.right!=null) {
            PrintRightTree(root.right, ans);
            ans.add(root.data);
        } else if(root.left!=null){
            PrintRightTree(root.left, ans);
            ans.add(root.data);
        }
	}

    static int cameras=0;

    static int MinCamerasInBT(TreeNode root){
        if(mincamerasInBt(root)==-1){ //handle last case;
            cameras++;
        }

        return cameras;
       
    }

    static int mincamerasInBt(TreeNode root){
        if(root==null){
            return 1;
        }

        int lchild=mincamerasInBt(root.left);
        int rchild=mincamerasInBt(root.right);

        if(lchild==-1 || rchild==-1){
            cameras++;
            return 0;
        }

        if(lchild==0 || rchild==1){
            return 1;
        }

        return -1;
    }

    static int count=0;
    public static TreeNode kthSmallest (TreeNode root, int k)
    {
        // base case
        if (root == null)
            return null;
      
        // search in left subtree
        TreeNode left = kthSmallest(root.left, k);
      
        // if k'th smallest is founkthSmallestd in left subtree, return it
        if (left != null)
            return left;
      
        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;
      
        // else search in right subtree
        return kthSmallest(root.right, k);
    }


     public ArrayList<Integer> solve(TreeNode A) {
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer>ans=new ArrayList<>();
        LinkedList<TreeNode> que=new LinkedList<>();
        
        
        
        que.addLast(A);
        System.out.println(que);
        while(que.size()!=0){
            int size=que.size();
            ArrayList<Integer> small=new ArrayList<>();
            while(size-- >0){
                        TreeNode rn=que.removeFirst();
                        small.add(rn.data);
                     
                        if(rn.left!=null){
                            que.addLast(rn.left);
                        }
                        
                        if(rn.right!=null){
                            que.addLast(rn.right);
                        }
                     }
            Collections.reverse(small);
            for(int i=0;i<small.size();i++){
                   st.push(small.get(i));
            }
        }
        

        
        while(!st.isEmpty()){
            int top=st.peek();
            ans.add(top);
            st.pop();
            
        }
        
        
        
        return ans;
    }

    // public static int sum = 0, mod = 1003; 

    // public static void pathSum(TreeNode A, int currSum){ 

    //     if(A == null){ 

    //         return; 

    //     } 

    //     currSum = (currSum*10 + A.data)%mod; 

    //     if(A.left == null && A.right == null){ 

    //         sum = (sum + currSum)%mod; 

    //         return; 

    //     } 

    //     pathSum(A.left, currSum); 

    //     pathSum(A.right, currSum); 

    // } 

    // public int sumNumbers(TreeNode A) { 

    //     sum = 0; 

    //     pathSum(A, 0); 

    //     return(sum); 

    // } 


    static int  sum=0;
    static boolean  isfound=false;
    public static int hasPathSum(TreeNode A, int B) {
        dfs(A,B,0);
        if(isfound){
            return 1;
        }else{
            return 0;
        }
    }
    
   static void dfs(TreeNode root,int B,int tempsum){
        if(root==null)return ;
       
        tempsum=tempsum+root.data;
        sum=tempsum;
        
        
        if(sum==B){
            isfound=true;
            return ;
        }
        
        dfs(root.left,B,tempsum);
        dfs(root.right,B,tempsum);
        
    }
    
      
    
}






