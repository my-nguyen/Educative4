package p10_two_heaps

import java.util.*

class StreamMedian {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

    fun insert(number: Int) {
        if (minHeap.isEmpty() || number > minHeap.peek())
            minHeap.add(number)
        else
            maxHeap.add(number)
        rebalance()
    }

    fun findMedian(): Double {
        if (minHeap.size == maxHeap.size)
            return (minHeap.peek() + maxHeap.peek()) / 2.0
        return minHeap.peek().toDouble()
    }

    fun remove(number: Int) {
        if (number <= maxHeap.peek())
            maxHeap.remove(number)
        else
            minHeap.remove(number)
        rebalance()
    }

    private fun rebalance() {
        if (minHeap.size > maxHeap.size + 1)
            maxHeap.add(minHeap.poll())
        else if (minHeap.size < maxHeap.size)
            minHeap.add(maxHeap.poll())
    }
}