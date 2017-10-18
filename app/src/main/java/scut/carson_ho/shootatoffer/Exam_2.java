package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/18.
 */

public class Exam_2 {

    /**
     * @param arr = 输入数组
     * @return
     */

    private static boolean answer(int[] arr){


        // 1. 判断输入数据 是否合法
        // 即，判断数组下标是否越界 & 数字 = 0~n-1范围
        if(arr == null || arr.length<=0) {
            System.out.println("输入不合法");
            return false;
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > (arr.length - 1)) {
                System.out.println("输入不合法");
                return false;
            }
        }


        // 2. 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 3. 比较 下标= i位置的值与该下标本身

            while(arr[i]!=i){
                // 若下标= i位置的值 = 下标= 前者值位置的值，即找到重复数字，输出
                if(arr[i]== arr[arr[i]]){
                    System.out.println("重复的数字是："+ arr[i]);
                    break;
                    //return true;
                }

                else {
                    // 否则，交换位置
                    // 把后者放在属于它的位置)
                    int temp = arr[i];
                    arr[i] = arr[arr[i]];
                    arr[temp] = temp;
                }
            }
        }

        System.out.println("结束");
        return true;
    }

    /**
     * 执行解题算法
     */
    public static void main(String[] args) {

        // 定义待解数列
        int[] src = new int[]{2,3,1,0,2,5,3};

        // 输出结果
        answer(src);

    }


}
