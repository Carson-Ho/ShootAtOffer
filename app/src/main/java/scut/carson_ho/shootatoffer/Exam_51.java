package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/16.
 */

public class Exam_51 {

    /**
     * 测试用例
     */

    public static void main(String[] args){
        // 功能测试
        System.out.println(inversePairs(new int[]{7,5,6,4})); // 未排序数组
        System.out.println(inversePairs(new int[]{4,5,6,7})); // 递增数组
        System.out.println(inversePairs(new int[]{7,6,5,4})); // 递减数组
        System.out.println(inversePairs(new int[]{7,5,4,4})); // 重复数组

        // 边界测试
        System.out.println(inversePairs(new int[]{7})); // 只有1个数字
        System.out.println(inversePairs(new int[]{7,4})); // 有2个数字

        // 特殊输入测试
        System.out.println(inversePairs(null));
    }

    /**
     * 解题算法
     */
    public static int inversePairs(int[] data) {
        // 检查输入数据的合法性
        if (data == null || data.length < 1) {
            System.out.print("输入的数据不合法");
            return 0;
        }
        // 创建辅助数组
        int[] copy = new int[data.length];

        // 执行归并排序 + 统计逆序对
        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    /**
     * 归并排序（含逆序对统计）算法实现
     */
    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        // 1. 计算出序列中间元素下标
        int length = (end - start) / 2;
        // 2. 把数组逐步分割成 长度= 1 的子数组（通过 递归 实现）
        int left = inversePairsCore(copy, data, start, start + length); // 左1半
        int right = inversePairsCore(copy, data, start + length + 1, end); // 右1半

        // 定义2指针，分别指向2个子数组的末尾
        // a. 前半段的最后1个数字的下标
        int i = start + length;
        // b. 后半段最后一个数字的下标
        int j = end;

        // 拷贝到辅助数组的位置从末尾开始
        int indexCopy = end;

        // 逆序对的数量
        int count = 0;

        // 对逆序对的数目的统计
        while (i >= start && j >= start + length + 1) {
            // 若p1 > p2，则构成逆序对，数目 = 第2个子数组中 指针指向数字前面的数字个数、把较大数字放入到1辅助数组中、把指向较大数字的指针往前移1位
            // 若p1 ≤ p2，则不构成逆序对、把较大数字放入到1辅助数组中、把指向较大数字的指针往前移1位
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // 对应的逆序数
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        // 将剩余元素复制到辅助数组
        for (; i >= start;) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + length + 1;) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }


}
