import java.io.*;
/**
 *
 * @author jay
 */
public class PalindromePermutation 

{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        //converting the input string to lower case
        //Assuming only 26 character set, and ignoring the white space
        input = input.toLowerCase();
        int count[] = new int[26];
        
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)>=97 && input.charAt(i)<=122)
            count[input.charAt(i)-'a']++;
        }
        int noOfEven = 0, noOfOdd = 0;
        for(int i=0;i<26;i++)
        {
            if(count[i]%2==0)
            {
                noOfEven++;
            }
            else
                noOfOdd++;
        }
        if(noOfOdd==1){
            System.out.println("TRUE");
        }
        
        else if(noOfOdd>1)
        {
            System.out.println("FALSE");
        }
        
    }


}
