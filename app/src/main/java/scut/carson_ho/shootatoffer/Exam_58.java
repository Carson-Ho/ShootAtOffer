package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/24.
 */

public class Exam_58 {

    /**
     * 测试用例
     */
    public static void main(String[] args)  {

        // 功能测试：句子中多个单词
        String str1 = "I am a student.";
        System.out.println(reverseSentence(str1));

        // 特殊输入测试：字符串指针为空
        System.out.println(reverseSentence(null));
    }

    /**
     * 解题算法
     */
    public static String reverseSentence(String inputString){

        // 判断输入数据的合法性
        if (inputString == null || inputString.length() < 2){
            System.out.println("输入的数据不合法");
            return inputString;
        }

        // 转换成字符串数组便于处理
        char[] inputChars = inputString.toCharArray();

        // 1. 翻转句子中所有字符顺序
        reverse(inputChars,0,inputChars.length - 1);

        // 2. 翻转每个单词中的字符顺序
        // 通过扫描空格来确定每个单词的起始 & 终止位置
        int start = 0;
        int end = 0;

        while (start < inputChars.length) {
            if (inputChars[start] == ' ') {
                start++;
                end++;
            } else if (end == inputChars.length || inputChars[end] == ' ') {
                reverse(inputChars, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }

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
