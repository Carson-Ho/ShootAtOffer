package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/30.
 */

public class Exam_67 {


    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 功能测试
        System.out.println(stringToInt("+345")); // 正数
        System.out.println("");
        System.out.println(stringToInt("-345")); // 负数
        System.out.println("");
        System.out.println(stringToInt("0")); // 0
        System.out.println("");

        // 异常输入测试：空指针、空字符串、、其余位 含 ‘0’~‘9’以外的字符、字符串 仅有"+" 或 "-"号
        System.out.println(stringToInt(null)); // 空指针
        System.out.println(flag);
        System.out.println("");

        System.out.println(stringToInt("")); // 空字符串
        System.out.println(flag);
        System.out.println("");

        System.out.println(stringToInt("a345")); // 第1位含 ‘0’~‘9’、‘+’、‘ - ’ 以外的字符
        System.out.println(flag);
        System.out.println("");

        System.out.println(stringToInt("345a")); // 其余位 含 ‘0’~‘9’以外的字符
        System.out.println(flag);
        System.out.println("");

        System.out.println(stringToInt("+")); // 字符串 仅有"+" 或 "-"号
        System.out.println(flag);
        System.out.println("");
    }


    // 设置一个全局变量，用于判断：当输出为0时，是字符串输入异常还是输入字符串为'0'
    // true = 输入异常、false = 输入字符串为'0'
    public static boolean flag;

    /**
     * 解题算法
     */

    public static int stringToInt(String num) {

        flag = false;

        // 非法输入1：空指针 & 空字符串 “ ”
        if (num == null || num.length() < 1 || num.trim().equals("")) {
            flag = true;
            System.out.println("非法输入1：空指针 & 空字符串 “ ”");
            return 0 ;
        }
        // 字符串开头 = “+”号  / “-”号的处理
        char first = num.charAt(0);
        if (first == '-') {
            // 将该开头-符号传入到转换字符串中
            return parseString(num, 1, false);

        } else if (first == '+') {
            // 将该开头+符号传入到转换字符串中
            return parseString(num, 1, true);

        } else if (first <= '9' && first >= '0') {
            // 或开头没有+、-符号，那数字必须是 ‘0’~‘9’
            return parseString(num, 0, true);

        } else {
            // 非法输入2：第1位含 ‘0’~‘9’、‘+’、‘ - ’ 以外的字符
            flag = true;
            System.out.println("非法输入2：第1位含 ‘0’~‘9’、‘+’、‘ - ’ 以外的字符");
            return 0 ;
        }
    }

    /**
     * 对字符串进行解析
     *
     * @param num      数字串
     * @param index    开始解析的索引
     * @param positive 是正数还是负数
     * @return 返回结果
     */
    private static int parseString(String num, int index, boolean positive) {
        // 非法输入3：当字符串仅有 "+" 或 "-"号时，也算非法输入
        if (index >= num.length()) {
            flag = true;
            System.out.println("非法输入3：字符串仅有 \"+\" 或 \"-\"号");
            return 0 ;
        }

        int result;
        long tmp = 0;

        // 非法输入4：其余位含 ‘0’~‘9’以外的字符
        while (index < num.length() && isDigit(num.charAt(index))) {
            // 若字符串中除第1位外，其余位 属于 ‘0’~‘9’，则转换字符串为整数
            // 转换原理：每扫描字符串中的1个字符，将之前得到的结果 乘以10 再加上 当前扫描字符表示的数字
            tmp = tmp * 10 + num.charAt(index) - '0';

            // 非法输入4：溢出
            // 保证求得的值不溢出
            // 即，不超出整数的最大绝对值
            // 根据字符串的第1位正 / 负，判断求得的值是否溢出
            // 溢出，即为 > 最大正整数
            if (positive && tmp > 0x8000_0000L ) {
                flag = true;
                System.out.println("溢出了");
                return 0 ;
            }

            index++;
        }

        // 其余位不含 ‘0’~‘9’以外的字符时，输出转换后的证书
        if (index == num.length() ){
            if (positive) {
                result = (int) tmp;
                return result;
            }
            else{
                result = (int) -tmp;
                return result;
            }
        }

        else{
            flag = true;
            System.out.println("其余位含 ‘0’~‘9’以外的字符");
            return 0 ;
        }


    }

    /**
     * 判断字符是否是数字
     *
     * @param c 字符
     * @return true是，false否
     */
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
