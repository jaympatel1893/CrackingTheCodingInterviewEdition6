import java.io.*;
/**
 *
 * @author jay
 */

class Node
{
    int data; //Have dafult values as 0 since it is class variable
    Node next;
    
    public Node()
    {
        
        data = 0;
        next = null;
    }
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

}

class List
{
    static Node head;
    
    static int count ;
    
    boolean isEmpty()
    {
        if(head==null)
        {
            return true;      
        }
        else
        {
            return false;
        }
    }
    public void add_Begin(int data)
    {
        if(isEmpty())
        {
            Node new_node = new Node(data);
            
            head = new_node;
            
            count++;
        }
        else
        {
            Node first = new Node(data);
        
            first.next = head;

            head = first;
            
            count++;
        }
        
    }
    public void add_At_Index(int data, int index)
    {

        
        if(index==1)
        {
            add_Begin(data);
        }
        else
        {
            Node temp = head;
            int temp_count = 1;
            while(temp_count!=(index-1))
            {
                temp = temp.next;
                temp_count++;
            }

            Node new_node = new Node(data);

            new_node.next = temp.next;
            temp.next = new_node;

            count++;

        }            

        
    }
    
    public void kthToLast(int k)
    {
        Node p1 = head;
        Node p2 = head;
        
        int count = 0;
        while(p1!=null)
        {
            p1 = p1.next;
            count++;
            if(count==k)
            {
                break;
            }
        }
        while(p1!=null)
        {
            //System.out.println(p2.data);
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(k +" the last is:" +p2.data);
    }
    
    public int recursiveKthToLast(int k, Node head)
    {
        if(head==null)
        {
            return 0;
        }
        else
        {
            int index = recursiveKthToLast(k, head.next) +1;
            if(index==k)
            {
                System.out.println("K the to last element is:"+head.data);
            }
            return index;
        }
        
    }
    
    public void remove(int index)
    {
        if(isEmpty())
        {
            System.out.println("List Empty, cannot remove");
        }
        else
        {   
            if(index!=count)
            {
                int temp_count = 1;
                Node temp = head;
                Node temp2 = head.next;
                while(temp_count!=(index-2))
                {
                    temp = temp.next;

                    temp2 = temp2.next;

                    temp_count++;
                }

                temp.next = temp2.next;
                temp2.next = null; //destroy Node :P



                count--;
            }
            else
            {
                //remove last node;
                int temp_count = 1;
                Node temp = head;

                while(temp_count!=(index-1))
                {
                    temp = temp.next;


                    temp_count++;
                }
                temp.next = null;
                count--;

            }
                        

                
            
        }
    }
    public static void reversePrint (Node l)
    {
        if (l == null)
            return;
        else {
            reversePrint(l.next);
            System.out.println(l.data);
        }
    }
    public void print()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data+"-->");
            temp = temp.next;
        }
    }
}

public class LinkList 

{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List list = new List();
        
        list.add_At_Index(5, 1);
        
        list.add_At_Index(12, 2);
        
        
        list.add_At_Index(2, 3);
        list.add_At_Index(3, 4);
        list.add_At_Index(4, 5);
        list.add_At_Index(100, 6);
        
        
        
        List.reversePrint(List.head);
        
        list.kthToLast(6);
        list.recursiveKthToLast(6, List.head);
        
        
        
    }


}
