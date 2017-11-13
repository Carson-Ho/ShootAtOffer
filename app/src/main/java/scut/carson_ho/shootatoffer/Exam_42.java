package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/13.
 */

public class Exam_42 {

    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试：数组中无相同数字
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSumArrays(data));

        // 特殊输入测试：数组为空
        int[] data2 = null;
        System.out.println(findGreatestSumOfSumArrays(data2));


    }

    /**
     * 解题算法：动态规划
     */
    public static int findGreatestSumOfSumArrays(int[] data){
        // 1. 判断输入数据的合法性
        if(data==null || data.length==0){
            System.out.println("输入的数组为空");
            return 0;
        }

        // 2. 定义所需变量
        //dp[i]：以data[i]为结尾元素的连续数组的最大和
        //maxdp：当前最大dp值
        int dp = data[0];
        int maxdp = dp;

        // 3. 通过遍历数组进行动态规划
        for(int i=1;i<data.length;i++){

            // 当以 第（ i - 1） 个数字结尾的子数组中所有数字的和 > 0时，最大值 = 等于 二者的和
            if(dp>0)
                dp += data[i];
            else
                // 当以 第（ i - 1） 个数字结尾的子数组中所有数字的和 < 0时，最大值 = 其本身
                dp = data[i];
            if(dp > maxdp)
                maxdp = dp;
        }
        return maxdp;
    }

}
