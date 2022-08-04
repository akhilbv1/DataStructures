fun main() {
    val ip = intArrayOf(-1,0,3,5,9,12)
    //val ip = intArrayOf(5)
     var target = 2
    //var target = 5
    println(search(ip, target))
}

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) {
        return -1
    }
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val mid = ((start + end) / 2)
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] > target) {
            end = mid - 1
        } else if (nums[mid] < target) {
            start = mid + 1
        }
    }
    return -1
}