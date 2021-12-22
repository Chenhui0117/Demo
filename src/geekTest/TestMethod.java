package geekTest;

import geekDataStructure.ArrayQueue;
import geekDataStructure.ArrayStack;
import geekDataStructure.CircularQueue;

import java.util.HashMap;

/**
 * @author Huihui
 * @date 2021/12/20 13:12
 * @Version 1.0
 * 测试调用类
 */
public class TestMethod {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(7, 2, 2);

        for (int i = 0; i < 6; i++) {
            queue.enqueue("a"+i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
