/**
 *
 * @author jay
 */
import java.util.*;
import java.io.*;
class Queue<E>{
    Stack <E> inbox = new Stack<>();
    
    Stack <E> outbox = new Stack<>();
    
    public void enqueue(E item)
    {
        inbox.push(item);
    }
    public E dequeue()
    {
        if(outbox.isEmpty())
        {
            //Remove all elements form inbox and push in Outbox
            
            while(!inbox.isEmpty())
            {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
    
}
public class QueueUsingStacks 
{
    public static void main(String args[])throws IOException
    {
        //Driver class
    }
}
