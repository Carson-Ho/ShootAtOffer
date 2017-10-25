package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/25.
 */

public class Exam_10 {

    public static void main(String[] args) {

        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci2(5));
    }


    /**
     * 递归实现
     */
    public static long Fibonacci(int n){
        if(n<=1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     * 循环实现
     */
    public static long Fibonacci2(int n){
        if(n<=1)
            return n;
        long fibOne = 1;
        long fibTwo = 0;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = fibOne+fibTwo;
            fibTwo = fibOne;
            fibOne = (int) sum;
        }
        return sum;
    }


}
