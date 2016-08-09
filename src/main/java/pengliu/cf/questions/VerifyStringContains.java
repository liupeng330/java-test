package pengliu.cf.questions;

/**
 * Created by peng on 16-8-9.
 */
public class VerifyStringContains
{
    // verify if a contains b
    public static boolean stringContains(String a, String b)
    {
        if(a == null || b == null)
        {
            return false;
        }
        if(a.length() < b.length())
        {
            return false;
        }

        int i=0;
        int j=0;
        while(i<a.length() && j<b.length())
        {
            if (a.charAt(i) != b.charAt(j))
            {
                i++;
                j=0;
            }
            else
            {
                i++;
                j++;
            }
        }
        return j == b.length();
    }

    public static void main(String[] args)
    {
        System.out.println(String.format("Verify if string %s contains %s, result is: %s", "abcdcefghi", "cef",
                stringContains("abcdcefghi", "cef")));
        System.out.println(String.format("Verify if string %s contains %s, result is: %s", "abcdcefghi", "cefi",
                stringContains("abcdcefghi", "cefi")));
        System.out.println(String.format("Verify if string %s contains %s, result is: %s", "abcdcefghi", "abcdcefghi",
                stringContains("abcdcefghi", "abcdcefghi")));
    }
}
