package pengliu.me;

import java.util.function.Predicate;

public class lambdaTest
{
    public String name;

    public lambdaTest(String name)
    {
        this.name = name;
    }

    public <T> void Run(T input, Predicate<T> method)
    {
        if(method.test(input))
        {
            System.out.println("True" + this.name);
        }
        else
        {
            System.out.println("False" + this.name);
        }
    }

    public void Retry(Runnable method)
    {
        int retryTimes = 10;
        while(true)
        {
            try
            {
                method.run();
                return;
            }
            catch (Exception ex)
            {
                if(--retryTimes <= 0)
                {
                    throw ex;
                }
            }
        }
    }
}
