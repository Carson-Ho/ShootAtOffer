package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/20.
 */

public class Exam_5 {

    /**
     * 替换空格
     * @param string = 需替换的字符串
     * @return 返回替换后的新序列
     */

    private static String answer(String string) {

        // 1. 检查输入的合法性
        if(string==null)
            return null;
        // 2. 求出当前字符串的长度 & 将输入的字符串转换成字符数组
        int originLength = string.length();
        char[] charArray = string.toCharArray();

        // 3. 通过遍历字符串，统计出字符串中的空格个数
        int numOfBlank = 0; // 记录空格数
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]==' ')
                numOfBlank++;
        }

        // 4. 计算替换后的字符串总长度，增加所需内存空间
        int newLength = originLength+numOfBlank*2; // 替换后的字符串长度
        char[] newcharArray = new char[newLength]; // 定义1个新的字符串数组用于装载替换空格后的字符串

        // 5. 从尾 -> 头 复制 字符串 & 替换空格
        // 通过2个指针辅助：从后->前移动
        int indexOfOriginal = originLength-1; // P1指向旧字符串末尾
        int indexOfNew = newLength-1; //P2指向替换后的字符串末尾

        // 6. 当2指针不相等时，移动指针进行字符串复制 & 替换
        // 相等时就跳出循环
        while(indexOfOriginal>=0 && indexOfOriginal != indexOfNew){

            // P1指向空格后：
            if(charArray[indexOfOriginal]==' '){

                // 在P2前插入“%20”，并将其向前移动3格
                newcharArray[indexOfNew--] = '0';
                newcharArray[indexOfNew--] = '2';
                newcharArray[indexOfNew--] = '%';
                indexOfOriginal--; // P1向前移动1格

            }else {
                // 向前移动指针P1，逐步将它指向的字符复制到P2指针，直到P1指向空格为止
                newcharArray[indexOfNew--] = charArray[indexOfOriginal--];
            }
        }

        // 7. 将剩余字符复制到新数组中
        for (int i = indexOfOriginal; i >= 0; i--) {
            newcharArray[i] = charArray[i];
        }

        // 8. 输出结果
        System.out.println(newcharArray);
        return String.valueOf(newcharArray);

    }

    /**
     * 执行解题算法
     */
    public static void main(String[] args) {

        // 定义待解数列
        String string ="We are happy";
        // 执行算法
        answer(string);

    }

}
