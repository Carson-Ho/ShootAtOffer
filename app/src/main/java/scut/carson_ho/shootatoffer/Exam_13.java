package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/25.
 */

public class Exam_13 {

    /**
     * 执行回溯算法
     */

    public static void main(String[] args){
        // 测试1：3行4列、k = 0
        System.out.println(movingCount(0,3,4)); // 1

        // 测试2：3行4列、k = 1
        System.out.println(movingCount(1,3,4)); // 3

        // 测试3：2行20列、k = 9
        System.out.println(movingCount(9,2,20)); // 36
    }

    /**
     * 回溯算法实现
     * 实现原理 = 递归
     * @param threshold = 临界值K
     * @param rowLen = 矩阵行数
     * @param colLen = 矩阵列数
     * @return boolean = 矩阵中是否存在要寻找的字符串路径
     */

    public static int movingCount(int threshold,int rowLen,int colLen){

        // 1. 判断输入数据的合法性
        if(rowLen<=0 || colLen<=0 || threshold<0)
            return 0;
        // 2. 定义1个布尔值矩阵，用于标识路径是否已进入每个格子
        boolean[][] visitFlag = new boolean[rowLen][colLen];
        // 初始化布尔值矩阵的初始值，即都未访问过
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++)
                visitFlag[row][col] = false;
        }
        // 3. 计算到达格子次数
        return movingCountCore(threshold,rowLen,colLen,0,0,visitFlag);
    }

    /**
     * 计算到达格子次数 实现
     * 实现原理 = 递归
     */
    public static int movingCountCore(int threshold,int rowLen,int colLen,int row,int col,boolean[][] visitFlag){
        int count = 0;
        // 1. 需判断机器人是否可以进入当前坐标
        // 判断条件 = 横纵坐标数位之和是否>k，小于则可以进入，具体请看函数canGetIn（）
        if(canGetIn(threshold,rowLen,colLen,row,col,visitFlag)){
            // 若可以，则计数+1，并标记该位置已被访问
            visitFlag[row][col] = true;
            count = 1+movingCountCore(threshold,rowLen,colLen,row-1,col,visitFlag)+
                    movingCountCore(threshold,rowLen,colLen,row+1,col,visitFlag)+
                    movingCountCore(threshold,rowLen,colLen,row,col-1,visitFlag)+
                    movingCountCore(threshold,rowLen,colLen,row,col+1,visitFlag);
        }
        return count;
    }

    /**
     * 计算横、纵坐标数位之和是否>k
     */
    public static boolean canGetIn(int threshold,int rowLen,int colLen,int row,int col,boolean[][] visitFlag){
        return row>=0 && col>=0 && row<rowLen
                && col<colLen && !visitFlag[row][col]
                && getDigitSum(row)+getDigitSum(col)<=threshold;
    }

    /**
     * 用于计算横、纵坐标数位的用于相加的值
     */
    public static int getDigitSum(int number){
        int sum=0;
        while (number>0){
            sum += number%10;
            number/=10;
        }
        return sum;
    }


}
