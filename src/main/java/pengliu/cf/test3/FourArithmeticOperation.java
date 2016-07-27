package pengliu.cf.test3;

import java.util.Arrays;

/**
 * Created by peng on 16-7-27.
 */
//实现四则运算法
public class FourArithmeticOperation
{
    public static void main(String[] args)
    {
        String[] input = {"5", "+", "(", "10", "-", "8", ")", "*", "23", "-", "12"};
        System.out.println("中缀式为：" + Arrays.asList(input));

        StackUse3 transferInFixToPostFix = new StackUse3(input);
        String[] postFix = transferInFixToPostFix.transferToPostInfix();
        System.out.println("转换为后缀式：" + Arrays.asList(postFix));

        StackUse2 calculatPostFix = new StackUse2(postFix);
        System.out.println("计算后缀式，结果为：" + calculatPostFix.calculate());
    }
}
