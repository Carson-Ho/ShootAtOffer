package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/27.
 */

public class Exam_17 {

    /**
     * 执行解题算法
     */
    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }

    /**
     * 用字符串表达大数 算法实现
     *
     * @param num 输入的n位数
     */

    public static void print1ToMaxOfNDigits(int num) {

        // 1. 判断输入数据的合法性
        if (num <= 0)
            return;

        // 2. 设置1字符串用于表达数字（大小 = n位）
        StringBuilder number = new StringBuilder(num);

        // 3. 将字符串上的字符初始化为0
        for (int i = 0; i < num; i++)
            number.append('0');


        // 4. 在字符串上模拟加法，每次加1都输出结果
        System.out.println("开始执行");

        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 在字符串上模拟加法
     *
     * @param str 输入的字符串
     */
    public static boolean increment(StringBuilder str) {

//        // 最高位产生进位标志，true时表示数组中的数为最大的n位整数
//        boolean isOverFlow = false;
//
//        // 进位位
//        int carry = 0;
//
//        //没有产生进位的+1，循环只运行1次，产生一个进位，循环多运行一次
//        for (int i = str.length() - 1; i >= 0; i--) {
//
//            System.out.println(i);
//            int sum = str.charAt(i) + carry;
//
//            if (i == str.length() - 1)
//                sum++;//最低位+1
//
//
//            if (sum >= 10) {
//                // 若最高位产生进位，则代表已经增加到了数组中的数为最大的n位整数
//                if (i == 0)
//                    isOverFlow = true;
//
//                    // 若只是普通位产生进位
//                    // 将当前位数设置为0，sum设置为0
//                else {
//                    sum -= 10;
//                    carry = 1;
//                    str.setCharAt(i, '0');
//                }
//            } else {
//
//                //普通位+1的结果保存到数组中，+1后程序退出循环
//
//                str.setCharAt(i, (char) sum);
//                break;
//            }
//        }
//        System.out.println(isOverFlow);
//        return isOverFlow;


        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)<'9' && str.charAt(i)>='0'){
                str.setCharAt(i,(char)(str.charAt(i)+1));
                return true;
            }
            else if(str.charAt(i)=='9'){
                str.setCharAt(i,'0');
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * 在字符串上模拟加法
     *
     * @param number 输入的字符串
     */

    public static void printNumber(StringBuilder number) {
        System.out.println("开始输出数字");
        boolean isBeginning = true;

        for (int i = 0; i < number.length(); i++) {
            if (isBeginning && number.charAt(i) != '0')
                isBeginning = false;

            if (!isBeginning)
                System.out.print(number.charAt(i));


//        for(int i=0;i<number.length();i++){
//            if(flag)
//                System.out.print(number.charAt(i));
//            else{
//                // 只有在碰到第一个非0的字符后才开始打印，直到字符串结尾
//                if(number.charAt(i)!='0'){
//                    flag = true;
//                    System.out.print(number.charAt(i));
//                }
//            }
//        }
            System.out.println();
        }

    }
}


