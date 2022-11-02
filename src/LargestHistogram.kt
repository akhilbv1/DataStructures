import java.util.*
import kotlin.math.max

fun main() {
    val ip = intArrayOf(2,4)
    println(largestRectangleAreaFast(ip))
}

typealias index = Int
typealias height = Int

fun largestRectangleAreaFast(heights: IntArray): Int {
    var result = 0
    val rectStack: Stack<Pair<index,height>> = Stack()

    heights.forEachIndexed { i, h ->
        var start = i
        while (rectStack.isNotEmpty() && rectStack.peek().second > h) {
            val (index, height) = rectStack.pop()
            result = max(result, height * (i-index))
            start = index
        }
        rectStack.push(Pair(start,h))
    }

    rectStack.forEach {
        result = max(result,  it.second * (heights.size - it.first))
    }
    return result
}
