package pengliu.cf.test2;

class Meal
{
    Meal()
    {
        //第一,构造 Meal
        System.out.println("Meal()");
    }
}

class Bread
{
    Bread()
    {
        System.out.println("Break()");
    }
}

class Lettuce
{
    Lettuce()
    {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal
{
    Lunch()
    {
        //第二,构造 Lunch
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch
{
    PortableLunch()
    {
        //第三,构造 ProtableLunch
        System.out.println("PortableLunch()");
    }
}

public class ConstructorTest extends PortableLunch
{
    //第四,按定义字段的顺序,先构造 b private Bread b = new Bread(); //第五,按定义字段的顺序,再构造 l private Lettuce l = new Lettuce();
    public ConstructorTest()
    {
        //最后,再调用当前类的构造函数
        System.out.println("ConstructorTest()");
    }

    public static void main(String[] args)
    {
        new ConstructorTest();
    }
}
