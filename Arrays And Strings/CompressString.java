import java.io.*;
/**
 *
 * @author jay
 */
public class CompressString 

{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        char inputCharArray[] = input.toCharArray();
        
        StringBuffer compressedString = new StringBuffer(""+inputCharArray[0]);
        //System.out.println(compressedString);
        
        char currChar = inputCharArray[0];
        int countOfChar = 1;
        for(int i=1;i<inputCharArray.length;i++)
        {
            if(inputCharArray[i]==currChar)
            {
                countOfChar++;
            }
            else
            {
                
                compressedString.append(new StringBuffer(""+countOfChar));
                
                countOfChar = 1;
                
                currChar = inputCharArray[i];
                
                compressedString.append(""+currChar);
                
            }
        }
        compressedString.append(new StringBuffer(""+countOfChar));
        
        System.out.println(compressedString);
        
        
    }


}
