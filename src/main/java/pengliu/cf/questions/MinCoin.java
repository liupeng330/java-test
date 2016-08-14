package pengliu.cf.questions;

/**
 * Created by peng on 8/14/16.
 */
//求最少可以用多少个硬币来凑足一定的金额
public class MinCoin
{
    //T(N) = money * v.length
    public static int minCoin(int money)
    {
        if(money <= 0) return 0;
        int[] v = {1, 3, 5};
        int[] B = new int[money + 1];

        B[0] = 0;
        for(int i=1; i<B.length; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<v.length; j++)
            {
                if((i - v[j]) >= 0)
                {
                    int temp = B[i - v[j]] + 1;
                    if(temp < min)
                    {
                        min = temp;
                    }
                }
            }
            B[i] = min;
        }

        return B[money];
    }

    public static void main(String[] args)
    {
        System.out.println(String.format("11 for min coint count is %d", minCoin(11)));
    }
}
