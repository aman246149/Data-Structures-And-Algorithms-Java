import java.util.*;

public class BinaryTree {
    public TreeNode root;
    static public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        // TreeNode fifth=new TreeNode(5);
        // TreeNode sixth=new TreeNode(6);
        // TreeNode seventh=new TreeNode(7);
        // TreeNode eight=new TreeNode(8);
        // TreeNode ninth=new TreeNode(9);
        // TreeNode tenth=new TreeNode(10);
        // TreeNode eleventh=new TreeNode(11);
        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        // second.right=fifth;
        // third.left=sixth;
        // third.right=seventh;
        // fourth.left=eight;
        // fourth.right=ninth;
        // fifth.left=tenth;
        // fifth.right=eleventh;
        

    }

    void preorder(TreeNode root){
        if(root==null){
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    void postorder(TreeNode root){
        if(root==null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    int sizeOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }

       int ls= sizeOfBinaryTree(root.left);
       int rs= sizeOfBinaryTree(root.left);
       int ts=ls+rs+1;
       return ts;
    }

    int sumOfaBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int ls=sumOfaBinaryTree(root.left);
        int rs=sumOfaBinaryTree(root.right);
        int ts=ls+rs+root.data;
        return ts;
    }

    int maxInaBinaryTree(TreeNode root){
            if(root==null){
                return Integer.MIN_VALUE;
            }
            int ls=maxInaBinaryTree(root.left);
            int rs=maxInaBinaryTree(root.right);
            int max=Math.max(Math.max(ls, rs),root.data);
            return max;
    }

    int heightInaBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=heightInaBinaryTree(root.left);
        int rh=heightInaBinaryTree(root.right);
        int th=Math.max(lh, rh)+1;
        return th;
    }

    void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node=queue.remove();
                System.out.print(node.data);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
    
   static ArrayList<Integer> ans=new ArrayList<>();
    
   boolean find(TreeNode root,int search){
    if (root == null)
    return false;


if (root.data == search)
  {
      ans.add(root.data);
      return true;
  }

// then recur on left sutree /
boolean res1 = find(root.left, search);

// node found, no need to look further
if(res1) {
    ans.add(root.data);
    return true;
}

// node is not found in left,
// so recur on right subtree /
boolean res2 = find(root.right, search);

if(res2){
    ans.add(root.data);
    return true;
}



return false;
   }


   void printKlevelDown(TreeNode root,int k){
        if(root==null || k<0){
            return ;
        }

        if (k==0) {
            System.out.println("k level down"+root.data);
           
        }
        printKlevelDown(root.left, k-1);
        printKlevelDown(root.right, k-1);

   }

   void flatten(TreeNode root){
       if(root==null || root.left==null && root.right==null)return;

       if(root.left!=null){
            flatten(root.left);
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            TreeNode curr=root.right;
            while(curr.right!=null){
                curr=curr.right;
            }
            curr.right=temp;
       }
       flatten(root.right);
   }
    public static void main(String[] args) {
       BinaryTree bt=new BinaryTree();
       bt.createBinaryTree();
       System.out.println("preorder");

    //    bt.preorder(bt.root);
    //    System.out.println("inorder");
    //    bt.inorder(bt.root);
    //    System.out.println("postorder");

    //    bt.postorder(bt.root);
    // System.out.println("size of binary tree "+bt.sizeOfBinaryTree(bt.root));
    // System.out.println("sum of binary tree element "+bt.sumOfaBinaryTree(bt.root));
    // System.out.println("max element in binary tree " +bt.maxInaBinaryTree(bt.root));
    // System.out.println("height of a binary tree "+bt.heightInaBinaryTree(bt.root));
    // System.out.println("find in of a binary tree "+bt.find(bt.root,7));
    // for (Integer integer : ans) {
    //     System.out.println(integer);
    // }
    // System.out.println("Level Order Traversal ");
    // bt.levelOrderTraversal(bt.root);
    // bt.printKlevelDown(bt.root, 2);
        bt.flatten(bt.root);


    }
}

