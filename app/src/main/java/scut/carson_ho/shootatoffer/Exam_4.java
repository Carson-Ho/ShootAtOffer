package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/19.
 */

public class Exam_4 {

    /**
     * 在二维数组中查找
     * @param arr = 二维数组
     * @param target = 需查找的整数
     * @return 返回false代表该数组无该整数；返回true代表该数组有该整数
     */

    private static boolean answer(int[][] arr,int target){
        // 1. 判断输入数据 是否合法
        if(arr==null) {
            System.out.println("输入数据不合法");
            return false;
        }

        // 2. 设置查找范围初始右上角整数的二维坐标
        int row = 0;
        int col = arr[0].length-1;

        int numRow = arr.length; // 二维数组的行数

        // 3. 比较查找范围右上角整数 与 需查找的证书
        while(row<numRow && col>=0){

            if(arr[row][col]>target)
                col--;  // 去掉该列
            else if (arr[row][col]<target) {
                row++;  // 去掉该行
            }else {
                System.out.println("数组中存在整数" + target);
                // 表示二维数组存在该整数
                return true;
            }
        }
        System.out.println("数组中不存在整数" + target);
        return false;
    }

    /**
     * 执行解题算法
     */
    public static void main(String[] args) {

        // 定义待解数列
        int[][] src = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        // 执行整数
        answer(src,7);


    }

}


