package p10_two_heaps

interface Command {
    fun run(value: Int?): Double?
}

lateinit var stream: StreamMedian

fun buildMap(): Map<String, Command> {
    val map = mutableMapOf<String, Command>()
    map["MedianOfAStream"] = object : Command {
        override fun run(value: Int?): Double? {
            stream = StreamMedian()
            return null
        }
    }
    map["insert"] = object : Command {
        override fun run(value: Int?): Double? {
            stream.insert(value!!)
            return null
        }
    }
    map["findMedian"] = object : Command {
        override fun run(value: Int?): Double {
            return stream.findMedian()
        }
    }
    return map
}

fun main() {
    val map = buildMap()
    val methods = listOf("MedianOfAStream", "insert", "insert", "findMedian", "insert", "findMedian", "insert", "findMedian")
    val arguments = listOf(null, 3, 1, null, 5, null, 4, null)
    for (i in methods.indices) {
        val median = map[methods[i]]!!.run(arguments[i])
        if (median != null)
            println(median)
    }
}
