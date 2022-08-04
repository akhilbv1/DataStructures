import kotlin.math.max
import kotlin.math.min

fun main() {
    // val containerArr = intArrayOf(6, 9, 3, 4, 5, 8)
    //val containerArr = intArrayOf(1,3, 2,5,25,24,5)
     val containerArr = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    //val containerArr = intArrayOf(1, 1)
    println(maxArea(containerArr))
    println(maxAreaFast(containerArr))
}

private fun maxAreaFast(height: IntArray): Int {
    var maxContainerArea = 0
    var p1 = 0
    var p2 = height.lastIndex
    while (p1 < p2) {
        val area = min(height[p1], height[p2]) * (p2 - p1)
        if(area>maxContainerArea)
            maxContainerArea = area
        if(height[p1]<height[p2])
            p1++
        else p2--
    }
    return maxContainerArea
}


private fun maxArea(height: IntArray): Int {
    var maxContainerArea = 0
    height.forEachIndexed { index, i ->
        if (index != height.lastIndex) {
            var maxArea = 0
            for (p2 in index + 1..height.lastIndex) {
                val area = min(height[index], height[p2]) * (p2 - index)
                if (area > maxArea)
                    maxArea = area
            }
            if (maxArea > maxContainerArea)
                maxContainerArea = maxArea

        }
    }
    return maxContainerArea
}
