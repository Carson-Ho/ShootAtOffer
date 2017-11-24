package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/24.
 */

public class Exam_58_1 {

    /**
     * 测试用例
     */
    public static void main(String[] args) throws Exception {
        // 功能测试
        String str1 = "abcdefg";
        System.out.println(leftRotate(str1,2));

        // 特殊输入测试：空指针
        System.out.println(leftRotate(null,2));
    }

    /**
     * 解题算法
     */
    private static String leftRotate(String inputString, int index){
        // 判断输入数据的合法性
        // 1. 输入空指针时，会造成程序崩溃
        // 2. 内存访问越界问题，即n < 0 ，那么指针指向的元素即不属于字符串
        if (inputString == null || inputString.length() < 2 || index < 0 ){
            return "输入数据不合法";
        }

        // 转换成字符串数组便于处理
        char[] inputChars = inputString.toCharArray();
        if (index > inputChars.length){
            index = inputChars.length;
        }
        // 1. 翻转字符串中 需转移的字符
        reverse(inputChars,0,index - 1);

        // 2. 翻转字符串中 剩余的字符
        reverse(inputChars,index,inputChars.length - 1);

        // 3. 翻转整个字符串
        reverse(inputChars,0,inputChars.length - 1);

        // 返回翻转后的字符串
        return String.valueOf(inputChars);
    }

    /**
     * 辅助算法：翻转句子
     */
    private static char[] reverse(char[] chars, int start, int end){
        if (chars == null || chars.length < 2){
            return chars;
        }
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
