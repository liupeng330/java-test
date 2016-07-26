package pengliu.cf.test3;

import pengliu.cf.MyStack;

/**
 * Created by peng on 7/25/16.
 */
public class StackUse1
{
    private MyStack<Character> stack = new MyStack<>();

    private final static Character[] openMark = {'{', '(', '['};
    private final static Character[] closeMark = {'}', ')', ']'};

    private Integer getOpenMarkIndex(Character mark)
    {
        for(int i=0; i < openMark.length; i++)
        {
            if(openMark[i].equals(mark))
            {
                return i;
            }
        }

        return -1;
    }

    private Integer getCloseMarkIndex(Character mark)
    {
        for(int i=0; i < closeMark.length; i++)
        {
            if(closeMark[i].equals(mark))
            {
                return i;
            }
        }

        return -1;
    }

    public boolean check(String input)
    {
        char[] chars = input.toCharArray();

        for(char c: chars)
        {
            if(getOpenMarkIndex(c) != -1)
            {
                this.stack.push(c);
                continue;
            }
            if(getCloseMarkIndex(c) != -1)
            {
                if(this.stack.isEmpty())
                {
                    System.out.println("Wrong mark for char at conditoin 1: " + c);
                    return false;
                }
                else if(getOpenMarkIndex(this.stack.pop()) == getCloseMarkIndex(c))
                {
                    continue;
                }
                else
                {
                    System.out.println("Wrong mark for char at condition 2: " + c);
                    return false;
                }
            }
        }

        if(!this.stack.isEmpty())
        {
            System.out.println("Wrong mark for char at condition 3:" + this.stack.peek());
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        StackUse1 test = new StackUse1();
        System.out.println(test.check("([{234esf}])"));
        System.out.println(test.check("([{234esf]])"));
        System.out.println(test.check("([abcd])]}]"));
        System.out.println(test.check("([abcd])}]"));
        System.out.println(test.check("([{[abcd]"));
    }
}
