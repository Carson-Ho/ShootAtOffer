package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/24.
 */

public class Exam_57_1 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 功能测试
        System.out.println("功能测试");
        findContinuousSequence(15);

        // 边界值输入测试：连续序列最小和 = 3
        System.out.println("边界值测试");
        findContinuousSequence(3);

    }

    /**
     * 解题算法
     */
    private static void findContinuousSequence(int sum) {

        // 判断输入数据的合法性
        if (sum < 3){
            System.out.println("输入的数据不合法");
        }
        // 1. 用2个指针分别指向当前序列的最小值 & 最大值
        // 指针1（small ）： 初始化指向1
        // 指针2（big ）： 初始化指向2
        int start = 1;
        int end = 2;
        int curSum = start + end;
        // 注：对于连续序列求和，考虑到每次操作前后的序列大部分数字相同，只是增加 / 减少1个数字
        // 故此处不采用循环求和，而是采用在前1个序列的基础上进行操作，从而减少不必要的运算，提高效率
        int mid = (sum + 1) / 2;

        // 2. 计算 指针1 ~ 指针2 之间数字的和（m）
        while (start < mid) {
            // 若m = 题目输入的s，即 指针1 ~ 指针2 之间数字 即为所求 = 1组解
            // 则：输出指针1 ~ 指针2 之间的数字序列、指针2 往后移1位、重复步骤2，继续求解
            if (curSum == sum) {
                printContinuous(start, end);
            }

            // 若m > 题目输入的s
            // 则：指针p1后移1位、重复步骤2，直到指针1（small） > （s+1）/2  为止
            while (curSum > sum && start < mid) {
                curSum -= start;
                start++;
                if (curSum == sum) {
                    printContinuous(start, end);
                }
            }
            end++;
            curSum += end;
        }
    }
    /**
     * 辅助算法：输出当前序列
     */
    private static void printContinuous(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
