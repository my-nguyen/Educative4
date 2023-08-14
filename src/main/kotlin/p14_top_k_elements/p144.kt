package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1,2), intArrayOf(1,3)),
        arrayOf(intArrayOf(1,3), intArrayOf(3,4), intArrayOf(2,-1))
    )
    val Ks = arrayOf(1, 2)
    for (i in arrays.indices) {
        val points = mutableListOf<Point>()
        for (array in arrays[i]) {
            val point = Point(array[0], array[1])
            points.add(point)
        }
        val closest = p144(points.toTypedArray(), Ks[i])
        println("points: $points, K: ${Ks[i]}, closest: $closest")
    }
}

data class Point(val x: Int, val y: Int) {
    val distance = x*x + y*y
}

fun p144(points: Array<Point>, k: Int): List<Point> {
    val maxHeap = PriorityQueue<Point>() { a, b -> b.distance - a.distance }
    for (i in 0 until k)
        maxHeap.add(points[i])
    for (i in k..points.lastIndex) {
        if (points[i].distance < maxHeap.peek().distance) {
            maxHeap.poll()
            maxHeap.add(points[i])
        }
    }
    return maxHeap.toList()
}