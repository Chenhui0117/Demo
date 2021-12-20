package geekAlgorithm;

/**
 * @author Huihui
 * @date 2021/12/15 15:54
 * @Version 1.0
 * 排序算法
 */
public class Geek_sort {


    // 冒泡排序，每次两俩比较，得到相邻之间数据关系，并得到一个极值，n次之后完成排序
    // O(n^2) 不需要额外的空间，最多是交换数据temp变量，不会破坏原本有序结构
    public static int[] bubbleSort(int[] a, int n) {
        if (n <= 1) return a;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) return a;  // 没有数据交换，提前退出
        }
        return null;
    }


    // 插入排序，无序区数据放入有序区，从后往前依次比较，符合条件交换位置
    // O(n^2)  不需要额外的空间，不会破坏原本有序结构,比较次数较少
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    //选择排序,一堆无序数组中找到最小的值，交换位置，放到有序区，直至完成排序
    // O(n^2)  不需要额外空间，但会破坏原本的有序结构，比较次数较多
    public static int[] chooseSort(int[] a, int n) {
        int min = 0;
        int index = 0;
        for (int j = 0; j < n; ++j) {
            min = a[j];
            index = j;
            for (int i = j; i < n - 1; ++i) {
                if (min > a[i + 1]) {
                    min = a[i + 1];
                    index = i + 1;
                }
            }
            a[index] = a[j];
            a[j] = min;
        }
        return a;
    }

    //归并排序

    /**
     * {1 6 5 2 4 3}  大数组  n=6,(0,5)
     * 拆分数组--先拆 后并
     * {1 6 5 }左数组n=3,(0,2)   { 2 4 3}右数组n=3,(3,5)
     * 继续拆分
     * {1 6} 和 {5}   {2 4} 和 {3}
     * 继续拆分
     * {1} 和 {6}  {5}   {2} 和 {4} {3}
     * 不可再分后两两向上合成、合并数组，并保证有序
     * {1,6} -> {1,5,6}
     * {2,4} -> {2,3,4}
     * {1 2 3 4 5 6}
     */
    public static int[] merge_sort(int[] a, int n) {
        return merge_sort_c(a, 0, n - 1);
    }

    public static int[] merge_sort_c(int[] a, int start, int end) {

        if (start < end) {// 递归终止条件
            int mid = (start + end) / 2;
            int[] b = merge_sort_c(a, start, mid);
            int[] c = merge_sort_c(a, mid + 1, end);
            merge(a, start, end, mid);//合并数组
        }
        return a;
    }

    /**
     * 合并指定下标范围的两个数组
     *
     * @param arr   原数组
     * @param left  左下标
     * @param right 右下标
     * @param mid   中间下标
     *              [start,mid]    [mid+1,end]
     *              [start,end]
     * @return
     */
    public static void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];// 申请一个临时数组,大小为左右数组之和
        int i = left, j = mid + 1, k = 0;// 初始化变量i, j, k

        //左右数组比较 依次放入临时数组中 但会剩余部分数组内容
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
            k++;
        }

        //对剩余部分数组进行整体接入临时数组中
        int m = i, n = mid;//默认左数组剩余
        if (j <= right) {
            //右数组剩余
            m = j;
            n = right;
        }
        while (m <= n) {
            temp[k++] = arr[m++];//每次组装完成后的新数组
        }
        //按照下标大小把组装好的数据替换给原始数组arr
        for (int p = left; p <= right; p++) {
            arr[p] = temp[p - left];
        }

    }

    /**
     * 把左右两个数组 按照一定排序规则 合并成为一个大数组
     *
     * @param big   大数组 [start,end]
     * @param left  左数组 [0,mid]
     * @param right 右数组 [mid+1,end]
     */
    public static int[] merge2(int[] big, int[] left, int[] right) {
        System.out.println("merge method!");
        int start = 0, end = big.length - 1, mid = (start + end) / 2;
        int i = 0, j = 0, k = 0;// 初始化变量i, j, k
        int[] temp = new int[big.length];// 申请一个和big一样大的临时数组

        while (i <= mid && j <= end - mid - 1) { //两数组依次比较，索引每次加一，数据填充到临时数组中
            if (left[i] <= right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }
        //两个数组会有一方比较完成，另一方有部分剩余
        //默认为左数组留下部分数据,若右数组结余则为右数组留下部分数据
        int m = i, n = mid;
        if (j < right.length) {
            m = j + mid + 1;
            n = end;
        }
        while (m <= n) {
            temp[k++] = big[m++];
        }
        return temp;
    }

    /**
     * 快速排序:分治、分区
     * 先分区再排序
     * 非原地排序：可能会影响已存在的有序结构（同等值得索引可能会发生变化）
     * 稳定的：不会占用额外的内存空间
     * @param arr 数组
     * @param n   数组的大小
     */
    public static int[] quick_sort(int[] arr, int n) {
       return quick_sort_c(arr, 0, n-1);
    }

    public static int[] quick_sort_c(int[] arr, int start, int end) {
        int pivot = 0;
        if (start < end) {
            pivot = partition(arr, start, end); // 获取分区点
            quick_sort_c(arr, start, pivot - 1);
            quick_sort_c(arr, pivot + 1, end);

        }
        return arr;
    }

    //分区，返回一个支点
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; //默认选择数组最右边的数为支点
        int i = start, j = start, temp = 0;//i 定pivot的位置  j用来交换数据
       while(start < end) {
            if (arr[start] > pivot) {
            } else {
                temp = arr[j];
                arr[j]= arr[i];
                arr[i] = temp;
                i++;//
            }
           j++;
            start++;
        }

        arr[end] = arr[i];//i和pivot互换数据
        arr[i] = pivot;
        /*for (int v :
                arr) {
            System.out.print(v + "-");

        }*/
        return i;
    }


}
