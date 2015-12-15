import java.io.*;
import java.util.*;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    
    public TreeNode()
    {
        
    }
    public TreeNode(int data)
    {
        this.data = data;
    }

}

class DriverTree{
    
    
    static TreeNode root;

    public DriverTree(){
        //root.parent = null;
        

        
    }
    

    public void makeTree(int a[])
    {
        System.out.println(Arrays.toString(a));
        
        for(int i=0;i<a.length;i++){
            insert( a[i]); //0 means root
        }
            
        //System.out.println(root.left.right.data);
        
        
        
    }
    
    public void insert(int value)
    {
        
        TreeNode x = new TreeNode(value);
        if(root==null)
        {
            root = x;
            return;
        }
        
        insertRecursive(root,   x);
    }
    
    public void insertRecursive(TreeNode latestNode, TreeNode node)
    {
        if(latestNode.data > node.data)
        {
            if(latestNode.left==null)
            {
                latestNode.left = node;
                return ;
            }
            else
            {
                insertRecursive(latestNode.left, node);
            }
        }
        else
        {
            if(latestNode.right==null)
            {
                latestNode.right = node;
                return;
            }
            else{
                insertRecursive(latestNode.right, node);
            }
        }
    }
    
    
    public void InorderTraversal(TreeNode t)
    {
        if(t==null)
        {
            return;
        }
        else
        {
            InorderTraversal(t.left);
            System.out.print(t.data+" ");
            InorderTraversal(t.right);
        }    
    }
    
    public boolean checkBalanced(TreeNode node)
    {
        if(root==null)
        {
            return true;
        }
        if(getHeight(root)==-1)
        {
            return false;
        }
        return true;
    }
    
    public int getHeight(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        if(left==-1 || right ==-1)
        {
            return -1;
        }
        System.out.println("left:"+left+" right="+right+" "+node.data);
        if(Math.abs(left-right)>1)
        {
            return -1;
        }
        
        return Math.max(left,right)+1;
    }
    TreeNode smallestBST(int a[],int low, int high)
    {
        if(high<low)
        {
            return null;
        }
        else
        {
            int mid = (low+high )/2;
            TreeNode root = new TreeNode(a[mid]);
            TreeNode left = smallestBST(a, low, mid-1);
            TreeNode right = smallestBST(a, mid+1, high);
            root.left = left;
            root.right = right;
            return root;
            
        }
    }
}

class BinarySearchTree{
    public static void main(String arhs[])throws IOException{

        DriverTree tree = new DriverTree();

        int a[] = {9,7,15,14,18,13};

        tree.makeTree(a);
            
        //System.out.println(Math.abs(-100));
        boolean  x =  tree.checkBalanced(DriverTree.root);
        
        tree.InorderTraversal(DriverTree.root);
        int b[] = {1,2,3,4,5};
        int n = b.length;
                
        TreeNode node = tree.smallestBST(b,0,n-1);
        
        DriverTree tree2 = new DriverTree();
        DriverTree.root = node;
        
        boolean y = tree2.checkBalanced(node);
        
        tree2.InorderTraversal(node);
        
        
        
    }
}