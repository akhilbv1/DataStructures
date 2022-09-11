import kotlin.math.min

fun main() {
    val target = 13
    val nums = intArrayOf(2, 3, 1, 2, 4, 3)
    println(minSubArrayLen(target, nums))
}


/*fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var p1 = 0
    var p2 = 0
    val minWindowSizeList:ArrayList<Int> = arrayListOf()
    val window:HashMap<Int,Int> = hashMapOf()
    while (p2 <= nums.lastIndex) {
        for (i in p1..p2){
            window[i] = nums[i]
        }
        if(window.values.sum() >= target) {
            minWindowSizeList.add(window.values.size)
            window.remove(p1)
            p1+=1
        } else {
            p2 += 1
        }
    }
    return minWindowSizeList.minBy { it } ?: 0
}*/
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var p1 = 0
    var p2 = 0
    var minWindowSize = 0
    var currentSum = nums[p1]
    while (p2 <= nums.lastIndex) { //n
        if (currentSum >= target) { // n - 1
            minWindowSize = if (minWindowSize == 0)
                (p2 - p1) + 1
            else
                min(minWindowSize, (p2 - p1) + 1)
            currentSum -= nums[p1]
            p1 += 1
        } else {
            p2 += 1
            if (p2 <= nums.lastIndex)
                currentSum += nums[p2]
        }
    }
    return minWindowSize
}


