package p14_top_k_elements

import java.util.PriorityQueue

interface Command {
    fun run(array: IntArray?, value: Int?): Int?
}

lateinit var stream: KStream

fun buildMap(): Map<String, Command> {
    val map = mutableMapOf<String, Command>()
    map["KStream"] = object : Command {
        override fun run(array: IntArray?, value: Int?): Int? {
            stream = KStream(array!!, value!!)
            return null
        }
    }
    map["add"] = object : Command {
        override fun run(array: IntArray?, value: Int?) = stream.add(value!!)
    }
    return map
}

fun main() {
    val map = buildMap()
    val methods = listOf("KStream", "add", "add", "add")
    val args1 = listOf(intArrayOf(3,1,5,12,2,11), null, null, null)
    val args2 = listOf(4, 6, 13, 4)
    for (i in methods.indices) {
        println(map[methods[i]]!!.run(args1[i], args2[i]))
    }
}

class KStream(val array: IntArray, val k: Int) {
    val minHeap = PriorityQueue<Int>()

    init {
        for (i in 0 until k)
            minHeap.add(array[i])
        for (i in k..array.lastIndex)
            util(array[i])
    }

    fun add(number: Int): Int {
        util(number)
        return minHeap.peek()
    }

    private fun util(number: Int) {
        if (number > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(number)
        }
    }
}