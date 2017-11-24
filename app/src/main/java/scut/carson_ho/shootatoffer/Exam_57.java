package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/24.
 */

public class Exam_57 {

    /**
     * 测试用例
     */
    public static void main(String[] args) throws Exception {
        // 功能测试1：存在和为s的2个数
        int[] array1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findTwoNumberWithSum(array1,15));

        // 功能测试2：不存在和为s的2个数
        int[] array2 = {1, 2, 3, 7, 11, 15};
        System.out.println(findTwoNumberWithSum(array2,15));

        // 特殊输入测试：数组为空
        System.out.println(findTwoNumberWithSum(null,15));

    }

    /**
     * 解题算法
     */
    private static boolean findTwoNumberWithSum(int[] intArray, int sum){
        // 判断输入数据的合法性
        if (intArray == null || intArray.length < 2){
            System.out.println("输入的数据不合法");
            return false;
        }
        // 1. 定义2个指针
        // p1 = 指向数组的头数据元素
        // p2 = 指向数组的尾数据元素
        int start = 0;
        int end = intArray.length - 1;

        // 2. 计算2个指针指向元素的和（m）
        // 循环条件
        while (start < end){
            int curSum = intArray[start] + intArray[end];
            // 若m = 题目输入的s ，即2个指针指向的数据元素即为所求
            if (curSum == sum){
                System.out.println("和为" + sum + "的两个数字是" + intArray[start] + "和" + intArray[end]);
                return true;
                // 若m > 题目输入的s，指针p2前移1位
            } else if (curSum < sum) {
                start++;
                // 若m < 题目输入的s，指针p1后移1位
            }else {
                end--;
            }
        }
        return false;
    }

}
