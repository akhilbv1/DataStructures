import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = intArrayOf(0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2)
    print(getTrappedRainWater(arr))
}


fun getTrappedRainWater(arr: IntArray): Int {
    var fill = 0
    arr.forEachIndexed { index, i ->
        //formula
        //currentWater = min(maxLeft,maxRight)-currentHeight
        val leftInd = if (index > 0) index - 1 else index
        val rightInd = if (index < arr.lastIndex) index else index
        val maxLeft = getMaxLeft(leftInd, arr)
        val maxRight = getRightWallArray(rightInd, arr)
        val currentWater = min(maxLeft, maxRight) - i
        if (currentWater > 0) fill += currentWater
    }
    return fill
}

fun getMaxLeft(index: Int, arr: IntArray): Int {
    var maxLeft = 0
    for (i in index.downTo(0)) {
        if (arr[i] > maxLeft)
            maxLeft = arr[i]
    }
    return maxLeft
}

fun getRightWallArray(index: Int, arr: IntArray): Int {
    var maxRight = 0
    for (i in index..arr.lastIndex) {
        if (arr[i] > maxRight)
            maxRight = arr[i]
    }
    return maxRight
}