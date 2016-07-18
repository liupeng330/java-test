package pengliu.me;

import mytest.me.Shout;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by peng on 10/11/15.
 */
public class test
{
    private String myName;

    public test(String myName)
    {
        this.myName = myName;
    }

    public void testForLambda()
    {
        lambdaTest lambdaTest = new lambdaTest("my name");
        lambdaTest.Run(
                "haha",
                i -> i.startsWith(this.myName));
    }

    public void testForRetry()
    {
        lambdaTest lambdaTest = new lambdaTest("test");
        lambdaTest.Retry(()->this.myName.startsWith("haha"));
    }

    public static void main(String[] args)
    {
//        Object[] elements = new Object[1000];
//        for(int i=0; i<elements.length; i++)
//        {
//            Integer value = i+1;
//            InvocationHandler handler = new TranceHandler(value);
//            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
//            elements[i] = proxy;
//        }
//
//        Integer key = new Random().nextInt(elements.length) + 1;
//        int result = Arrays.binarySearch(elements, key);
//
//        if(result >= 0 )
//            System.out.println(elements[result]);

        InvocationHandler handler = new TranceHandler();
        Shout proxy = (Shout)Proxy.newProxyInstance(
                Shout.class.getClassLoader(),
                new Class[]{Shout.class},
                handler);
        Object ret = proxy.say("hahah");
    }
}

class Employee
{
}

class Manager extends Employee
{
}


class TranceHandler implements InvocationHandler
{
//    private Object target;
//
//    public TranceHandler(Object target)
//    {
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
//        System.out.println(target);
        System.out.println(method.getName());
        for(Object arg: args)
        {
            System.out.println(arg);
        }

        return args[0].toString().length();
    }
}
