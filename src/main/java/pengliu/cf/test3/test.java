package pengliu.cf.test3;

/**
 * Created by peng on 7/21/16.
 */
public class test
{
    public static void main(String[] args)
    {
        String s0= "kvill";
        String s1=new String("kvill");
        String s2=new String("kvill");
        System.out.println( s0==s1 );
        System.out.println( "**********" );
        s2=s2.intern();
        //把常量池中"kvill"的引用赋给 s2
        System.out.println( s0==s1.intern() );
        System.out.println( s0==s2 );
    }
}
