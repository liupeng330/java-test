package pengliu.cf.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pengliu.cf.MyStack;

/**
 * Created by peng on 7/26/16.
 */
public class StackUse2
{
    private static final String[] operand = {"*", "+", "-", "/"};
    private List<String> needToCalList;
    private MyStack<Double> nums = new MyStack<>();

    public StackUse2(String... nums)
    {
        this.needToCalList = new ArrayList<>(Arrays.asList(nums));
    }

    private boolean isOperand(String input)
    {
        return Arrays.asList(operand).contains(input);
    }

    public Double calculate()
    {
        for(String ele: needToCalList)
        {
            if(isOperand(ele))
            {
                if(this.nums.size() < 2)
                {
                    throw new RuntimeException("There is no enough nums in stack!!");
                }
                switch (ele)
                {
                    case "*":
                        this.nums.push(this.nums.pop() * this.nums.pop());
                        break;
                    case "+":
                        this.nums.push(this.nums.pop() + this.nums.pop());
                        break;
                    case "-":
                        Double temp = this.nums.pop();
                        this.nums.push(this.nums.pop() - temp);
                        break;
                    case "/":
                        Double temp2 = this.nums.pop();
                        this.nums.push(this.nums.pop() / temp2);
                        break;
                    default:
                        throw new RuntimeException("Cannot reach codes!!");
                }
            }
            else
            {
                this.nums.push(Double.parseDouble(ele));
            }
        }
        if(this.nums.size() != 1)
        {
            throw new RuntimeException("Error when calculating!!");
        }
        return this.nums.pop();
    }

    public static void main(String[] args)
    {
        StackUse2 stackUse2 = new StackUse2("4.99", "1.06", "*", "5.99", "-", "6.99", "1.06", "/", "+");
        System.out.println(stackUse2.calculate());
    }
}
