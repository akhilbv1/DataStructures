fun main() {
    val nums = intArrayOf(1, 2, 0)
    sortColorsOp(nums)
    print(nums.toList())
}

fun sortColors(nums: IntArray) {
    var redCount = 0
    var blueCount = 0
    var whiteCount = 0
    val arr = nums
    arr.forEach {
        when (it) {
            0 -> redCount += 1
            1 -> whiteCount += 1
            2 -> blueCount += 1
        }
    }
    for (i in 0..arr.lastIndex) {
        if (redCount > 0) {
            arr[i] = 0
            redCount -= 1
        } else if (whiteCount > 0) {
            arr[i] = 1
            whiteCount -= 1
        } else if (blueCount > 0) {
            arr[i] = 2
            blueCount -= 1
        }
    }
}

fun sortColorsOp(nums: IntArray) {
    var startInd = 0
    var endInd = nums.lastIndex
    var index = 0
    val arr = nums
    while (index <= endInd) {
        val item  = arr[index]
        if (item == 0) {
            arr[index] = arr[startInd]
            arr[startInd] = 0
            startInd += 1
        }
        if (item == 2) {
            arr[index] = arr[endInd]
            arr[endInd] = 2
            endInd -= 1
            index -= 1
        }
        index += 1
    }
}