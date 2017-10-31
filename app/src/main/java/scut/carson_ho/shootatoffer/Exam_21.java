package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/31.
 */

public class Exam_21 {


    /**
     * 测试用例
     */
    public static void main(String[] args){
        int[] data = {1,2,3,4,5};
        reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
        }
    }

    /**
     * 解题算法
     * 解题思路：通过2指针判断 & 交换位置
     */

    /**
     * 功能判断函数
     * 将判断数字 = 奇 / 偶 的代码独立出来，实现最大解耦
     */

    public static boolean isEven(int n){
        return (n&1)==0;
    }

    public static void reorder(int[] data){

        // 1. 判断输入数据的合法性
        if(data==null||data.length<2)
            return;

        // 2. 初始化2指针
        // p1 = 初始化指向数组第1个元素，
        // p2 = 初始化指向数组第1个元素
        int left=0;
        int right=data.length-1;

        // 3. 跳出循环条件 = p2在p1的前1个位置
        while(left<right){
            // a. 将p1指针不断往后移，直到遇到的数 = 偶数
            // 直接调用功能判断函数进行判断奇、偶
            while (left<right && !isEven(data[left]) )
                left++;
            // b. 将p2指针不断往前移，直到遇到的数 = 奇数
            // 直接调用功能判断函数进行判断奇、偶
            while (left<right && isEven(data[right]))
                right--;
            if(left<right){
                // c. 当p1、p2分别指向偶数、奇数时，交换2指针指向的数字位置
                int temp=data[left];
                data[left]=data[right];
                data[right]=temp;
            }
        }
    }

}
