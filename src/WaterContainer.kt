import kotlin.math.max
import kotlin.math.min

fun main() {
    // val containerArr = intArrayOf(6, 9, 3, 4, 5, 8)
    val containerArr = intArrayOf(1,3, 2,5,25,24,5)
    println(getMaxContainer(containerArr))
    print(getMaxContainerOp(containerArr))
}

fun getMaxContainer(height: IntArray): Int {
    if (height.size < 2) return 0
    var currentMax = 0
    height.forEachIndexed { indexi, i ->
        height.forEachIndexed { indexj, j ->
            val container = min(i, j) * (indexj - indexi)
            if (container > currentMax)
                currentMax = container
        }
    }
    return currentMax
}

fun getMaxContainerOp(height: IntArray): Int {
    if (height.size < 2) return 0
    var currentMax = 0
    var indP1 = 0
    var indP2 = height.lastIndex
    while (indP1 != indP2) {
        val p1 = height[indP1]
        val p2 = height[indP2]
        val max = min(p1, p2) * (indP2 - indP1)
        if(max>currentMax)
            currentMax = max
        if(p1<p2 || p1==p2) indP1++ else indP2--
    }
    return currentMax
}