import java.io.*;
/**
 *
 * @author jay
 */
public class URLify 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputString = br.readLine();
        
        int actualLength = Integer.parseInt(br.readLine());
        
        char stringToChar[] = inputString.toCharArray();
        
        int j = actualLength-1;
        for(int i=stringToChar.length-1;i>=0;i--)
        {
            if(stringToChar[j]!=' ')
            {
                stringToChar[i] = stringToChar[j];
                j--;
            }
            else
            {
                //it is a blank space
                stringToChar[i--] = '0';
                stringToChar[i--] = '2';
                stringToChar[i] = '%';
                j--;
                
            }
        }
        System.out.println(stringToChar);
        
    }


}
