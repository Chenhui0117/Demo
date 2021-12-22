package geekDataStructure;

/**
 * @author Huihui
 * @date 2021/12/21 9:27
 * @Version 1.0
 * 基于数组实现的顺序队列
 * 先进先出
 * 数据搬移
 */
public class ArrayQueue {

    private String[] arr; //数组
    private int n ; //数组初始化大小
    private int head ; //头部指针
    private int tail ; //尾部指针

    public ArrayQueue(int n, int head, int tail) {
        this.arr = new String[n];
        this.n = n;
        this.head = head;
        this.tail = tail;
    }
    //入队
    public boolean enqueue(String item){
        //if (tail == n) return false;
        if (tail == n){ //队满场景
            if (head == 0){ //从头开始
                System.out.println("队满！！！");
                return false;
            }else{
                //头部队列有空余，进行数据搬迁操作
                System.out.println("数据进行搬迁,head="+head+";tail="+tail);
                arr =  move(arr);
            }
        }
        arr[tail] = item;
        tail++;
        return true;
    }
    //出队
    public String dequeue(){
        if (head == n ){
           // System.out.println("队空！！！");
            return null;
        }
        //arr[head] = null;
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
