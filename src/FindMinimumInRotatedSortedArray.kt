import kotlin.math.min

fun main() {
    val ip = intArrayOf(4,5,6,7,0,1,2)
    println(findMin(ip))
}

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex
    var result = nums[left]
    while ( left<=right ) {
        if(nums[left] < nums[right]) {
            result = min(result, nums[left])
            break
        }
        val midIndex = (left + right) / 2
        val midItem = nums[midIndex]
        result = min(midItem,result)
        if(midItem >= nums[left]) {
            left = midIndex + 1
        } else {
            right = midIndex - 1
        }
    }
    return result
}