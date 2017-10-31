package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/31.
 */

public class Exam_19 {

    /**
     * 测试模式匹配算法
     */
    public static void main(String[] args){
        // 功能测试用例：模式字符串含普通字符、'.'、'*'
        System.out.println(match("aaa","a.a"));//true
        System.out.println(match("aaa","ab*ac*a"));//true
        System.out.println(match("aaa","aa.a"));//false
        System.out.println(match("aaa","ab*a"));//false

        // 异常测试用例：为空 、空格字符串
        System.out.println(match(null,null));//false
        System.out.println(match(" ", " "));//true
    }

    /**
     * 模式匹配算法
     * @param str 目标字符串
     * @param pattern 模式字符串
     */
    public static boolean match(String str,String pattern){

        // 1. 检查数据的合法性
        if(str==null || pattern==null)
            return false;
        // 2. 进行模式匹配
        // 返回true  = 匹配成功
        // 返回false = 匹配失败
        return matchCore(new StringBuilder(str),0,new StringBuilder(pattern),0);
    }

    /**
     * 详细的模式匹配
     * @param str 目标字符串
     * @param strIndex 当前匹配的目标字符串的字符
     * @param pattern 模式字符串
     * @param patternIndex 当前匹配的模式字符串的字符
     */

    public static boolean matchCore(StringBuilder str,Integer strIndex,StringBuilder pattern, Integer patternIndex){

        // 若下标 = 字符串长度，则代表匹配结束
        if(strIndex==str.length() && patternIndex==pattern.length())
            return true;
        // 若仅有其中1个匹配结束，则代表不匹配
        if(strIndex==str.length() || patternIndex==pattern.length())
            return false;
        // 若当前匹配的模式字符串的第2个字符不是* Or 只剩1个字符
        if(patternIndex==pattern.length()-1|| pattern.charAt(patternIndex+1)!='*'){
            if(pattern.charAt(patternIndex)=='.' || pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex+1);
            else
                return false;
        }
        // 否则，当前匹配的模式字符串的第2个字符不是 = "*"，则直接跳过
        else{
            if(pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex) ||matchCore(str,strIndex+1,pattern,patternIndex+2);
            else
                return matchCore(str,strIndex,pattern,patternIndex+2);
        }
    }

}




