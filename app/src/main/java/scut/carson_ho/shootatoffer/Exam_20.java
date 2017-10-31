package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/31.
 */

public class Exam_20 {

    /**
     * 测试用例
     */

    public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }

    /**
     * 判断字符串是否表示数字
     * 解题思想：表示数字的字符串模式 = A[.[B]][e|EC] 、 .B[e|EC];
     * @param str 目标字符串
     */
    public static boolean isNumeric(String str){
        // 1. 判断输入数据的合法性
        if(str==null||str.length()==0)
            return false;
        int index;

        // 2. 若第1位 ≠ 小数点.，则代表模式 = A[.[B]][e|EC]
        if(str.charAt(0)!='.'){
            // 扫描表示数 整数的 A部分
            index = scanInteger(str,0);

            // 异常情况
            if(index == -1)
                return false;
            if(index==str.length())
                return true;

            // 3. 若遇到小数点.，则扫描表示数值小数的 B部分
            if(str.charAt(index)=='.'){
                // 异常情况：小数点后可没有数字，如233. = 233.0
                if(index==str.length()-1)
                    return true;
                // 扫描表示数值小数的 B部分
                index = scanUnsignedInteger(str,index+1);
                if(index==str.length())
                    return true;
            }
            // 若遇到e、E，扫描表示数值指数的 C部分
            if(str.charAt(index)=='e'||str.charAt(index)=='E'){
                // 扫描表示数 整数的 A部分
                index = scanInteger(str,index+1);
                if(index==str.length())
                    return true;
                else
                    return false;
            }
            return false;
        }


        // 否则，代表第1位 = "."，即代表模式 = .B[e|EC]
        else{
            index = scanUnsignedInteger(str,1);
            if(index==-1)
                return false;
            if(index==str.length())
                return true;
            if(str.charAt(index)=='e'||str.charAt(index)=='E'){
                index = scanInteger(str,index+1);
                if(index==str.length())
                    return true;
            }
            return false;

        }

    }
    /**
     * 扫描可能有符号整数，即以+、-开头的0~9的数位
     * 作用：用于匹配A整数部分、C指数部分
     * @param str 目标字符串
     * @param index 当前下标
     */
    public static int scanInteger(String str,Integer index){
        if(index >= str.length())
            return -1;
        if(str.charAt(index)=='+'||str.charAt(index)=='-')
            return scanUnsignedInteger(str,index+1);
        else
            return scanUnsignedInteger(str,index);
    }

    /**
     * 扫描无符号整数，即不以+、-开头的0~9的数位
     * 作用：用于匹配B小数部分
     * @param str 目标字符串
     * @param index 当前下标
     */
    public static int scanUnsignedInteger(String str,Integer index){
        int origin = index;
        while(str.charAt(index)>='0'&&str.charAt(index)<='9'){
            index++;
            if(index==str.length())
                return index;
        }
        if(origin==index)
            index = -1;
        return index;
    }
}
