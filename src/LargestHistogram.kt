import kotlin.math.max

fun main() {
    val ip = intArrayOf(2,1,5,6,2,3)
    println(largestRectangleArea(ip))
}

fun largestRectangleArea(heights: IntArray): Int {
    var result = 0
    heights.forEachIndexed { index, i ->
        var maxArea = i  * 1
        var length = 0
        for (elementIndex in index+1..heights.lastIndex) {
            if(heights[elementIndex] > i) {
                length+=1
            } else {
                maxArea = max(maxArea,(i * (elementIndex - index)))
                result = max(result, maxArea)
                break
            }
        }
    }
    return result
}