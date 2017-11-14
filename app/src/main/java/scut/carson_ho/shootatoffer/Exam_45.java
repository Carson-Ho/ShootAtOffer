package scut.carson_ho.shootatoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Carson_Ho on 17/11/14.
 */

public class Exam_45 {


    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int[] data = {3,32,321};

        // 功能测试
        System.out.println(PrintMinNumber(data));


        // 特殊输入测试
        System.out.println(PrintMinNumber(null));
    }

    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null|| numbers.length < 0){
            return "输入的数据不合法";
        }

        int n = numbers.length;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();

        // 将数组都添加到链表里
        for(int i=0;i<n;i++){
          list.add(numbers[i]);
        }

        // 1. 将数组中的证书转换成字符串
        // sort(List，Comparator)的作用：根据指定的 Comparator（可自定义，此处为自定义）产生的顺序对 List 集合元素进行排序
        // Comparator = 比较器 = 1个接口，通过实现这个接口重写compare（），可使用compareTo（）比较两个对象的大小
        // 返回正值 = 大于 、返回0 = 等于、返回负值 = 小于。这样就可以自定义排序方法
        // 系统函数默认 = 递增排序
        // 注：
        // a. 因为String类内部实现了该方法，故可直接用compareTo进行比较
        // b. jdk8的List本身也支持比较器排序。jdk7中集合可使用Collections的sort方法，实现自定义比较器排序，数组可以通过Arrays.sort()方法实现自定义比较器排序。
        Collections.sort(list, new Comparator<Integer>(){

        public  int compare(Integer str1,Integer str2){

            String s1=str1+""+str2;
            String s2=str2+""+str1;
            // 注：不能String s1=str1 + str2 + ""，因为str1和str2是Integer，会先相加后再与空字符串拼接

            // 2. 根据新定义的规则，比较2个数字的大小
            return s1.compareTo(s2);


           }
            });

            // 3. 将排序后的数字拼接起来
            for(int j:list){
             s+=j;
             }

          return s;
         }
}
