package pengliu.cf.questions;

/**
 * Created by peng on 8/18/16.
 */
//求收集到最多苹果的路径
public class CollectApple
{
    // T(N) = O(m * n)
    public static int getMaxAppleNum(int[][] A, int m, int n)
    {
        if(A == null || m <= 0 || n <= 0)
        {
            return 0;
        }

        int[][] S = new int[m][n];
        S[0][0]  = A[0][0];

        for(int i=0; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                S[i][j] = A[i][j];
                if(i>0 && j>0)
                {
                    S[i][j] += max(S[i][j-1], S[i-1][j]);
                }
                else if(i>0)
                {
                    S[i][j] += S[i-1][j];
                }
                else
                {
                    S[i][j] += S[i][j-1];
                }
            }
        }

        return S[m-1][n-1];
    }

    private static int max(int p, int q)
    {
        return p > q ? p : q;
    }

    public static void main(String[] args)
    {
        int[][] apples = {
                {2, 3, 1, 4, 1},
                {1, 3, 5, 1, 0},
                {4, 1, 1, 1, 9}};

        System.out.println(String.format("The max number of apples that can be collected is %s", getMaxAppleNum(apples, 3, 5)));
    }
}
