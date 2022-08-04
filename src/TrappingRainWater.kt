import kotlin.math.log
import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(trap(arr))
    println(trapFaster(arr))
    print(trapConstantMemory(arr))
}

fun trapConstantMemory(height: IntArray): Int {
    var trappedWater = 0
    var p1 = 0
    var p2 = height.lastIndex
    var leftMaxNew = height[p1]
    var rightMaxNew = height[p2]

    while (p1 < p2) {
        if (leftMaxNew < rightMaxNew || leftMaxNew == rightMaxNew) {
            val waterTrappedAtCurrentIndex = leftMaxNew - height[p1]
            if(waterTrappedAtCurrentIndex>0) trappedWater += leftMaxNew - height[p1]
            p1 += 1
            leftMaxNew = max(leftMaxNew, height[p1])
        } else {
            val waterTrappedAtCurrentIndex = rightMaxNew - height[p2]
            if(waterTrappedAtCurrentIndex>0) trappedWater += rightMaxNew - height[p2]
            p2 -= 1
            rightMaxNew = max(rightMaxNew, height[p2])
        }
    }
    return trappedWater
}


//T:n S:n
fun trapFaster(height: IntArray): Int {
    var trappedWater = 0
    var leftMaxNew = height[0]
    var rightMaxNew = 0
    val maxRightHashmap: HashMap<Int, Int> = hashMapOf()

    for (index in height.lastIndex downTo 0) {//n
        if (height[index] > rightMaxNew) {
            rightMaxNew = height[index]
        }
        maxRightHashmap[index] = rightMaxNew
    }

    height.forEachIndexed { index, i ->//n
        val waterTrappedAtIndex = min(leftMaxNew, maxRightHashmap[index]!!) - i
        if (waterTrappedAtIndex > 0) trappedWater += waterTrappedAtIndex
        if (i > leftMaxNew) {
            leftMaxNew = height[index]
        }
    }

    return trappedWater
}

//T:- n(index-n) S:1
private fun trap(height: IntArray): Int {
    var trappedWater = 0
    var leftMaxNew = height[0]
    height.forEachIndexed { index, i ->
        val rightMax = getRightMax(height, index)//index-n
        if (height[index] > leftMaxNew)
            leftMaxNew = height[index]

        val waterTrappedAtIndex = min(leftMaxNew, rightMax) - i
        trappedWater += waterTrappedAtIndex
    }
    return trappedWater
}

private fun getRightMax(height: IntArray, currentIndex: Int): Int {
    var rightMax = height[currentIndex]
    for (index in currentIndex + 1..height.lastIndex) {
        if (height[index] > rightMax)
            rightMax = height[index]
    }
    return rightMax
}
