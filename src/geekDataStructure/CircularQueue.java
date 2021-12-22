package geekDataStructure;

/**
 * @author Huihui
 * @date 2021/12/21 16:50
 * @Version 1.0
 * 基于数组实现的循环队列
 */
public class CircularQueue {

    private String[] arr; //数组
    private int n ; //数组初始化大小
    private int head ; //头部指针
    private int tail ; //尾部指针
    private int count;//计数器

    public CircularQueue(int n, int head, int tail) {
        this.arr = new String[n];
        this.n = n;
        this.head = head;
        this.tail = tail;
    }
    //入队
    public boolean enqueue(String item){
        if (tail > n){
            tail = 0;
        }
        if ((tail+1)%n ==head ) return false;

        arr[tail] = item;
        tail++;
        if (tail > n){
            tail = 0;
        }
        count--;
        return true;
    }
    //出队
    public String dequeue(){
        if (head > n){
            head = 0;
        }
        if (count == n){
            return null;
        }
        count++;
        return arr[head++];
    }

    public String[] move(String[] a){
        String[] newArr = new String[n];//和原数组一样大小
        for (int i=head;i<tail;i++){
            newArr[i-head] = a[i];
        }
        //头指针与尾指针从新计算
        tail = tail - head;
        head = 0;
        return newArr;
    }
}
