package exp3;

import java.util.Scanner;
public class matrix {
        static int n;
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int[][] zz = new int[100][100];
            int[] ans = new int[3];
            n=scan.nextInt();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    zz[i][j]=scan.nextInt();
                }
            }
            ans = findLargestBlock(zz);
            System.out.print("最大矩阵位置：("+ans[1]+","+ans[2]+")  ");
            System.out.println("矩阵长度："+ans[0]);
        }
        public static int[] findLargestBlock(int[][] m)
        {
            int maxn=1,x=0,y=0;
            for(int i=1;i<n;i++)
            {
                for(int j=1;j<n;j++)
                {
                    if(m[i][j]==1)
                    {
                        int mmin = Math.min(m[i - 1][j], m[i][j - 1]);
                        mmin = Math.min(m[i - 1][j - 1], mmin);//求出上 ，左，上左最小值
                        m[i][j] = mmin + 1;
                        if(maxn < m[i][j])
                        {
                            maxn = m[i][j];
                            x=i;y=j;//记录方阵右下位置
                        }
                    }
                }
            }
            int[] ans = {maxn,x-maxn+1,y-maxn+1};//结果放在数组中
            return ans;
        }
    }



