package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/10.
 */

public class Exam_39 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 功能测试1：数组中存在有1个数字出现的次数>数组长度的1半
        int[] data = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(data));

        // 功能测试2：数组中数字出现频率最高的次还未达到数组长度的1半
        int[] data1 = {1,2,3,2,2,2,5,4,1};
        System.out.println(MoreThanHalfNum_Solution(data1));

        // 特殊输入测试：数组为空
        int[] data2 = null;
        System.out.println(MoreThanHalfNum_Solution(data2));
    }

    /**
     * 解题算法
     * 核心思想：根据数组特点，即若数组中有1个数字出现的次数>数组长度的1半，即说明它出现的次数>其他所有数字出现的次数和
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        // 1. 检查输入数组的合法性
        if(array == null || array.length == 0) {
            System.out.println("输入的数组为空");
            return 0;
        }

        // 2. 设置2个变量：value = 遍历的数组数字、count = 该数字出现的次数
        // 均初始化为0
        int val = 0;
        int count = 0;

        // 3. 遍历数组，遍历过程中根据以下规则更新2个变量
        for(int i : array) {
            System.out.println("val = " + val);
            System.out.println("count = " + count);

            // a. 若count减为0，更新value = 当前数字，并count设为1
            if(count == 0) {
                val = i;
                count = 1;
            }
            // b. 若下1个数字 = value，那么count加1；
            else if(val == i)
                ++count;
            // c. 若下1个数字 ≠ value，那么count减1；若count减为0，更新value = 当前数字，并count设为1
            else
                --count;
        }

        // 4. 最终，通过1辅助算法 判断数组中数字出现频率最高的次数是否达到数组长度的1半
        if(checkMoreThanHalf(array, val)) {
            return val;
        }
        else {
            System.out.println("数组中数字出现频率最高的次还未达到数组长度的1半");
            return 0;
        }
    }
    /**
     * 辅助算法
     * 作用：判断数组中数字出现频率最高的次数是否达到了一半
     */
    private static boolean checkMoreThanHalf(int[] array, int val) {
        int count = 0;
        for(int i : array) {
            if(i == val)
                ++count;
        }
        return count > array.length / 2;
    }
}
