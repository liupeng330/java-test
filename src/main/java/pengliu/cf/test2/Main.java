package pengliu.cf.test2;

import pengliu.cf.test1.TestProtected;

/**
 * Created by peng on 7/9/16.
 */
public class Main extends TestProtected
{
    private void test()
    {
        super.MyMethod();
        System.out.println("In Main MyMthod!!");
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.MyMethod();
    }
}
