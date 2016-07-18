package pengliu.cf.test2;

/**
 * Created by peng on 7/9/16.
 */
public class TestJava
{
    //静态初始化器 static
    {
        //首先调用
        Instance = new StaticInit("static constructor");
    }

    //第二调用
    static StaticInit Instance = new StaticInit("static instance");

    //实例化初始化器
    {
        //第三调用
        objectInstance = new StaticInit("Object constructor");
    }

    public TestJava()
    {
        //第五调用
        objectInstance = new StaticInit("default object constructor");
    }

    //第四调用
    StaticInit objectInstance = new StaticInit("Object instance");

    public static void main(String[] args)
    {
        TestJava tj = new TestJava();

    }
}

class StaticInit
{
    public StaticInit(String arg)
    {
        System.out.println(arg);
    }
}


