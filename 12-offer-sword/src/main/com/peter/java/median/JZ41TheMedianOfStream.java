package main.com.peter.java.median;

import java.util.PriorityQueue;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ41TheMedianOfStream
 * Author:   Peter
 * Date:     26/04/2022 14:55
 * Description: https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=265&tqId=39243&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ41TheMedianOfStream {
    // Use PriorityQueue to implement a heap, PriorityQueue is a min Heap
    // if the number is ood, then first part will store n/2 + 1, and second part stores n/2, middle number is
    // the peek of min heap
    // if the number is even, then minHeap and maxHeap would store n/2

    /**
     * The first half. We need to add negative value of the corresponding thing.
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();

    /**
     * The second half. minHeap is the default value for PriorityQueue.
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public void Insert(Integer num) {
        // insert into maxHeap and modify the data structure of two heaps
        maxHeap.add(-num);
        int size = minHeap.size() + maxHeap.size();
        int maxHeapSize;
        if (size % 2 == 0) {
            maxHeapSize = size / 2;
        } else {
            maxHeapSize = size / 2 + 1;
        }

        // check element number
        while (maxHeap.size() > maxHeapSize) {
            minHeap.add(-maxHeap.remove());
        }
        // check the peak
        while (!maxHeap.isEmpty() && !minHeap.isEmpty() && -maxHeap.peek() > minHeap.peek()) {
            int minHeapPeek = minHeap.remove();
            int maxHeapPeek = maxHeap.remove();
            minHeap.add(-maxHeapPeek);
            maxHeap.add(-minHeapPeek);
        }

    }

    public Double GetMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            double median = (double) (-maxHeap.peek() + minHeap.peek()) / 2;
            return median;
        } else {
            return new Double(-maxHeap.peek());
        }
    }
}
