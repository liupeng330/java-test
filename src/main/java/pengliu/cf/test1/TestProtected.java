package pengliu.cf.test1;

public class TestProtected
{
    protected void MyMethod()
    {
        System.out.println("calling in mymethod!!");
    }

    public static void main(String[] args)
    {
        TestProtected testProtected = new TestProtected();
        testProtected.MyMethod();
    }
}
