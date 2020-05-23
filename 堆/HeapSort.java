package cn.datacast.堆;

import javax.crypto.spec.PSource;

public class HeapSort <T extends Comparable<T>>{

    /*
    *   对sourse数组中的数据进行从小到大的排序
    * */
    public static void sort(Comparable[] Source){
        // 构建堆
        Comparable[] heap = new Comparable[Source.length + 1];
        creatHeap(Source, heap);  // heap中存储的就是初始化的堆，是一个无序的堆
        // 定义一个变量，记录未排序元素中最大的索引
        int N = heap.length - 1;
        // 通过循环，交换1索引处的元素和排序的元素中最大索引处的元素
        while (N != 1){
            // 交换元素
            exch(heap, 1, N);
            // 排序交换后，最大元素所在的索引，让它不要参与堆的下沉
            N--;
            // 需要对索引1处的元素进行堆的下沉
            sink(heap, 1, N);
        }
        // 将heap中的数据复制到源数组
        System.arraycopy(heap, 1, Source, 0, Source.length);
    }

    /*
     *  根据原数组source，构造出来heap
     * */
    private static void creatHeap(Comparable[] source, Comparable[] heap){
        // 将source中的元素拷贝到堆中，heap中的元素就形成一个堆，堆是一个无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);
        // 对对中的元素做下沉调整(从长度的一半处进行调整，向索引1处扫描)
        for (int i = (heap.length) / 2; i > 0; i--){
            sink(heap, i, heap.length - 1);
        }
    }

    /*
     *  判断heap堆中索引i处的元素是否小于索引j处的元素
     * */
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    /*
     *  交换heap堆中i索引和j索引处的值
     * */
    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /*
    *   在heap堆中，对target处的元素做下沉，范围是0-range,range为堆中元素下沉的范围
    * */
    private static void sink(Comparable[] heap, int target, int range){
        while (2 * target <= range){
            // 找出当前节点较大的子节点
            int max;
            if(2 * target + 1 <= range){
                if(less(heap, 2 * target, 2 * target + 1)){  // 存在右子节点
                    max = 2 * target + 1;  // 右子节点为最大子节点
                }else {  // 左子节点为最大子节点
                    max = 2 * target;
                }
            }else {
                max = 2 * target;
            }
            // 比较当前节点的值和较大子节点的值
            if(!less(heap, target, max)){
                break;
            }
            exch(heap, target, max);
            target = max;
        }
    }
}
