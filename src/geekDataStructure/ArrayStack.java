package geekDataStructure;

/**
 * @author Huihui
 * @date 2021/12/20 11:42
 * @Version 1.0
 * 基于数组实现的顺序栈
 * 动态扩容
 */
public class ArrayStack {
    private String[] arr; //数组
    private int n ; //数组初始化大小
    private int count ; //栈的元素个数


    public ArrayStack(int n) {
        this.arr = new String[n];
        this.n = n;
        this.count = 0;
    }
    //入栈
    public boolean push(String item){
        //1.栈满
        //if (count == n) return false;
        //2.支持动态扩容
        if (count == n){
            arr = dynamicCopy(arr);
            n = arr.length;
            System.out.println("扩容成功，当前数组大小为："+arr.length);
        }
        arr[count] = item;
        count++;
        return true;
    }
    //出栈
    public String pop(){
        if (count == 0) return null;
        count-- ;
        return arr[count];
    }

    private String[] dynamicCopy(String[] arr){
        //默认扩两倍
        String[] arrCopy = new String[arr.length*2];
        for(int i = 0;i<arr.length;i++){
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }
}
