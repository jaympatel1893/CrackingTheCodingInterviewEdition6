import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author jay
 */

class TreeNode{
    int data;
    TreeNode left, right;
    
    public TreeNode()
    {
        
    }
}
public class ListOfDepths 
{
    
    static ArrayList <LinkedList<TreeNode>> createArrayListOfLinkedList(TreeNode root)
    {
        ArrayList <LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        
        if(root!=null)
        {
            list.add(root);
        }
        while(list.size()>0)
        {
            result.add(list);
            
            LinkedList <TreeNode> newList = list;
            
            list = new LinkedList<>();
            //for every left and right child of every node in newList add into list
            for(int i=0;i<newList.size();i++)
            {
                if(newList.get(i).left!=null)
                {
                    list.add(newList.get(i).left);
                }
                if(newList.get(i).right!=null)
                {
                    list.add(newList.get(i).right);
                }
            }
        }
        return result;
    }
    public static void main(String args[])throws IOException
    {
        //Initilise root and make tree
        //createArrayListOfLinkedList(root)
    }


}
