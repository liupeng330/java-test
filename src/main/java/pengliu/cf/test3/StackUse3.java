package pengliu.cf.test3;

import pengliu.cf.MyStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peng on 16-7-27.
 */
// 将中缀式变为后缀式
public class StackUse3
{
    private String[] infix;
    private MyStack<String> stack = new MyStack<>();
    private static final String[] operand = {"*", "+", "-", "/"};

    //判断是否是操作符
    private boolean isOperand(String input)
    {
        return Arrays.asList(operand).contains(input);
    }

    //判断两个操作符，第一个操纵符优先级高于第二个，则返回true， 否则返回false
    private boolean isOperandHasHigherOrEqualPriority(String operandA, String operandB)
    {
        if(operandA.equals(operand))
        {
            return true;
        }
        //判断操作符A优先级高于B
        else if((operandA.equals("*") || operandA.equals("/")) && (operandB.equals("+") || operandB.equals("-")))
        {
            return true;
        }
        //判断操作符A优先级等于B
        else if((operandA.equals("*") && operandB.equals("/")) || (operandA.equals("/") && operandB.equals("*")))
        {
            return true;
        }
        else if((operandA.equals("+") && operandB.equals("-")) || (operandA.equals("-") && operandB.equals("+")))
        {
            return true;
        }
        return false;
    }

    public StackUse3(String... infix)
    {
        this.infix = infix;
    }

    public String[] transferToPostInfix()
    {
        List<String> result = new ArrayList<>();

        for(int i=0; i<this.infix.length; i++)
        {
            String current = this.infix[i];
            //如果是操作符
            if(isOperand(current))
            {
                if(!this.stack.isEmpty() && this.stack.peek().equals("("))
                {
                    this.stack.push(current);
                }
                else
                {
                    //如果当前操作符优先级大于栈顶, 将所有
                    while ( !this.stack.isEmpty() && isOperand(this.stack.peek()) && isOperandHasHigherOrEqualPriority(this.stack.peek(), current))
                    {
                        result.add(this.stack.pop());
                    }
                    this.stack.push(current);
                }
            }
            //为左括号，直接入栈
            else if(current.equals("("))
            {
                this.stack.push(current);
            }
            //当遇到右括号时,将栈中元素弹出并输出,直到遇到左括号才停止弹出,并且这个左括号也需要弹出,但不输出。
            else if(current.equals(")"))
            {
                while(!this.stack.peek().equals("("))
                {
                    result.add(this.stack.pop());
                }
                if(this.stack.peek().equals("("))
                {
                    this.stack.pop();
                }
            }
            // 当遇到操作数时,立即输出
            else
            {
                result.add(current);
            }
        }

        //当扫描完成时,将栈中遗留下来的所有元素输出
        while(!this.stack.isEmpty())
        {
            result.add(this.stack.pop());
        }
        return result.toArray(new String[0]);
    }


    public static void main(String[] args)
    {
        StackUse3 stackUse3 = new StackUse3("a", "+", "(", "b", "-", "c", ")", "*", "d");
        System.out.println(Arrays.asList(stackUse3.transferToPostInfix()));

        stackUse3 = new StackUse3("a", "+", "(", "b", "-", "c", ")", "*", "d", "-", "e");
        System.out.println(Arrays.asList(stackUse3.transferToPostInfix()));
    }
}
