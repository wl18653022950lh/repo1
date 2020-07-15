package myAlgorithm;


/**
 * @Author wl
 * @Date 2020/5/27 17:30
 * @Version 1.0
 */

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品重量
        int[] val= {1500,3000,2000};//物品价值
        int n = w.length;//物品个数
        int m = 4;//背包容量
        int[][] dp = new int[n+1][m+1];//dp[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] path = new int[n+1][m+1];//为了记录放入商品的情况
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(w[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    if(dp[i-1][j] < val[i-1]+dp[i-1][j-w[i-1]]){
                        dp[i][j] = dp[i-1][j-w[i-1]]+val[i-1];
                        //把当前的记录加进path
                        path[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.println(dp[i][j]+"");
            }
            System.out.println();
        }

        System.out.println("=======================================");
        int i = path.length-1;
        int j = path[0].length-1;
        while(i>0 && j>0){
            if(path[i][j] == 1){
                System.out.println("第%d个物品放进背包\n"+i);
                j=j-w[i-1];
            }
            i--;
        }
    }

}
