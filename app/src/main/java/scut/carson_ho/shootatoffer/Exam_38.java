package scut.carson_ho.shootatoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carson_Ho on 17/11/8.
 */

public class Exam_38 {

    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 功能测试1：无重复字符 字符串
        System.out.println("功能测试1：无重复字符 字符串");
        List<char[]> ret = permutation("abc");
         // 输出字符
        for (char[] item : ret) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }

        // 功能测试2：重复字符 字符串
        System.out.println("功能测试2：重复字符 字符串");
        List<char[]> ret1 = permutation("aac");
        // 输出字符
        for (char[] item : ret1) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }

        // 特殊输入测试：输入字符为空
        System.out.println("特殊输入测试：输入字符为空");
        List<char[]> ret2 = permutation(null);

    }


    /**
     * 解题算法
     * @param strs  传入的字符串
     */
    public static List<char[]> permutation(String strs) {
        // 1. 判断数据的合法性
        if (strs == null || strs.length() == 0) {
            System.out.println("输入的头节点为空");
            return null;
        }
        char[] chars = strs.toCharArray();// 将字符串转换成数组便于处理
        // 2. 创建1链表用于存储排列
        List<char[]> ret = new LinkedList<>();
        // 3. 求出字符串的排列
        permutationCore(chars, ret, 0);
        return ret;
    }

    /**
     * 求字符串的排列
     */
    public static void permutationCore(char[] strs, List<char[]> ret, int bound) {
        // 下标 = bound的字符 = 当前字符串的第1个字符
        if (bound == strs.length)
            ret.add(Arrays.copyOf(strs, strs.length));

        // 下标 = i的字符 = 当前字符串第1个字符的后面所有字符（i的范围 = [bound,length) ）
        // 下标 = bound的字符依次与下标为i的字符交换
        // 若相同，则不交换，直到最后一个元素为止
        for (int i = bound; i < strs.length; i++) {
            if (i == bound || strs[bound] != strs[i]) {
                swap(strs, bound, i);
                permutationCore(strs, ret, bound + 1);
                swap(strs, bound, i);
            }
        }
    }

    /**
     * 交换字符位置
     */
    public static void swap(char[] strs, int x, int y) {
        char temp = strs[x];
        strs[x] = strs[y];
        strs[y] = temp;
    }

}
