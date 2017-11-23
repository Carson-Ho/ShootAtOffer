package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/23.
 */

public class Exam_56 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        int[] array1 = {2, 4, 3, 6, 3, 2, 5, 5};
        findTwoOnceNumber(array1);
    }

    /**
     * 解题算法
     */
    public static void findTwoOnceNumber(int[] intArray){
        // 判断输入数据的合法性
        if (intArray == null || intArray.length < 2){
            System.out.println("数组为空或者长度不足");
            return;
        }
        // 1. 将原数组分成2个子数组
        // 1.1 从头到尾 依次异或 数组中的每个数字
        int orResult = 0;
        for (int i : intArray){
            orResult ^= i;
        }
        // 1.2 在上述结果找出第1个= 1的位置，记为 第 n 位
        int indexOf1 = findFirstBitIs1(orResult);

        // 1.3 以二进制的第n位是否为1，将原数组的数字分为2个子数组
        int number1 = 0, number2 = 0;
        for (int i : intArray){
            if (isBit1(i,indexOf1)){
                // 2. 分别从头到尾 依次异或 2个子数组中的每个数字
                number1 ^= i;
            }else {
                number2 ^= i;
            }
        }
        System.out.println("只出现一次的数字是：" + number1 + "和" + number2);
    }

    /**
     * 从右到左，寻找输入数字在二进制表示中，第一个位是1的位置
     * @param i 输入的数
     * @return 第一个位是1的位置
     */
    private static int findFirstBitIs1(int i){
        int index = 0;
        while (((i & 1) == 0) && index < 32){
            i = i >> 1;
            index++;
        }
        return index;
    }

    /**
     * 这个数的第index位是否为1
     * @param number 输入的数
     * @param index 位置
     * @return 是否为1
     */
    private static boolean isBit1(int number, int index){
        number = number >> index;
        return (number & 1) == 1;
    }
}
