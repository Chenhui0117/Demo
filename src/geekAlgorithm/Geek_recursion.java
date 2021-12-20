package geekAlgorithm;

import java.util.HashMap;

/**
 * @author Huihui
 * @date 2021/12/16 9:33
 * @Version 1.0
 * 递归算法:递归有利有弊，利是递归代码的表达力很强，写起来非常简洁；
 * 而弊就是空间复杂度高、有堆栈溢出的风险、存在重复计算、过多的函数调用会耗时较多等问题。
 */
public class Geek_recursion {
    private HashMap<Integer, Integer> hasSolvedList = new HashMap<>();

    public static void main(String[] args) {
       int result =  fh(5);
        System.out.println(result);
    }


    public static int f1(int n) {
        if (n == 1) return 1;
        return f1(n-1) + 1;
    }


    public static int f2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f2(n-1) + f2(n-2);
    }

    //调用形式 f(n,1) 尾递归是指出现在递归函数尾部直接返回递归函数结果的递归，补充一下下面例子的尾递归写法
    public static int f3(int n, int depth) {
        if (n == 1) return depth;
        return f3(n-1, depth+1);
    }

    public static void function(){


    }

        // 全局变量，表示递归的深度。
        int depth = 0;

        int f(int n) {
            ++depth;
            if (depth > 1000) return -1 ;//内存溢出

            if (n == 1) return 1;
            return f(n-1) + 1;
        }


    public int fa(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // hasSolvedList可以理解成一个Map，key是n，value是f(n)
        if (hasSolvedList.containsKey(n)) {//重复计算、用map保存
            return hasSolvedList.get(n);
        }

        int ret = fa(n-1) + fa(n-2);
        hasSolvedList.put(n, ret);
        return ret;
    }


    int fw(int n) {
        int ret = 1;
        for (int i = 2; i <= n; ++i) {
            ret = ret + 1;
        }
        return ret;
    }


    public static int fh(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }


}
