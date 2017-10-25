package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/25.
 */

public class Exam_12 {

    /**
     * 执行回溯算法
     */
    public static void main(String[] args){
        // 定义矩阵 = 二维数组
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};

        // 测试输出结果
        System.out.println(hasPath(data,"bfce")); //true
        System.out.println(hasPath(data,"abfb")); //false,访问过的位置不能再访问
    }

    /**
     * 回溯算法实现
     * 实现原理 = 递归
     * @param data = 矩阵
     * @param str = 需寻找的字符串路径
     * @return boolean = 矩阵中是否存在要寻找的字符串路径
     */
    public static boolean hasPath(char[][] data,String str){
        // 1. 判断数据的合法性
        if(data==null || data.length==0 || str==null || str.length()==0)
            return false;

        int rowLen = data.length; // 矩阵行数
        int colLen = data[0].length;// 矩阵列数

        // 2. 定义1个布尔值矩阵，用于标识路径是否已进入每个格子
        boolean[][] visitFlag = new boolean[rowLen][colLen];
        // 初始化布尔值矩阵的初始值，即都未访问过
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                visitFlag[row][col] = false;
            }
        }

        // 3. 通过循环寻找矩阵中的值 与 字符串路径中相等的值
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                if(hasPathCore(data,row,col,visitFlag,str,0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 判断 矩阵中是否存在于需寻找的字符串路径
     * 实现原理 = 递归
     * @param data = 矩阵
     * param rowIndex = 当前行数
     * param colIndexIndex = 当前列数
     * param visitFlag = 路径标识符
     * param str = 需寻找的字符串路径
     * param strIndex = 字符串路径下标
     * @return boolean = 矩阵中是否存在要寻找的字符串路径
     */
    public static boolean hasPathCore(char[][] data,int rowIndex,int colIndex,
                                      boolean[][] visitFlag,String str,int strIndex){
        // 结束条件
        if(strIndex>=str.length()) return true;

        if(rowIndex<0 || colIndex<0 || rowIndex>=data.length || colIndex>=data[0].length)
            return false;

        // 递归
        // 若该矩阵值未被访问，且匹配字符串，就：
        // a. 标记当前位置为已访问
        // b. 分上下左右四个方向位置通过递归继续寻找字符串路径中下1个值
        if(!visitFlag[rowIndex][colIndex]&&data[rowIndex][colIndex]==str.charAt(strIndex)){

            // a. 标记当前位置为已访问
            visitFlag[rowIndex][colIndex] = true;

            // b. 分上下左右四个方向位置通过递归继续寻找字符串路径中下1个值
            boolean result =
                    hasPathCore(data,rowIndex+1,colIndex,visitFlag,str,strIndex+1) ||
                            hasPathCore(data,rowIndex-1,colIndex,visitFlag,str,strIndex+1) ||
                            hasPathCore(data,rowIndex,colIndex+1,visitFlag,str,strIndex+1) ||
                            hasPathCore(data,rowIndex,colIndex-1,visitFlag,str,strIndex+1);
            // 若4个相邻格子匹配到字符串路径的下1个值，则视为当前递归的路线求解成功
            // 无需修改标记
            if(result)
                return true;

            else{
                // 否则，即若4个相邻格子都无法匹配 到字符串路径的下1个值 成功
                // 视当前递归的路线求解失败，需把这条线路上的标记清除掉
                // 使得其他起点的路径依旧可访问本路径上的节点，方便重新定位
                visitFlag[rowIndex][colIndex] = false;
                return false;
            }
        }
        else
            return false;
    }

}
