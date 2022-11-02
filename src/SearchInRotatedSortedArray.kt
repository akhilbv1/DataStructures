import java.util.Arrays.binarySearch

fun main() {

}

fun searchB(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    val rotateIndex = binarySearchRotateIndex(nums)
    val rotateItem = nums[rotateIndex]

    val firstItem = nums.first()
    val lastItem = nums.last()

    return when {
        target == rotateItem -> rotateIndex
        target >= rotateItem && target <= lastItem -> {
            binarySearch(nums, target, rotateIndex, nums.lastIndex)
        }
        else -> binarySearch(nums, target, 0, rotateIndex - 1)
    }
}

private fun binarySearchRotateIndex(array: IntArray): Int {
    val target = array.last()

    var left = 0
    var right = array.lastIndex

    while (left <= right) {
        val midIndex = (right + left) / 2
        val midItem = array[midIndex]

        when {
            target == midItem -> right = midIndex - 1
            target > midItem -> right = midIndex - 1
            target < midItem -> left = midIndex + 1
        }
    }

    return left
}

private fun binarySearch(array: IntArray, target: Int, start: Int, end: Int): Int {
    var left = start
    var right = end

    while (left <= right) {
        val midIndex = (right + left) / 2
        val midItem = array[midIndex]

        when {
            target == midItem -> return midIndex
            target > midItem -> left = midIndex + 1
            target < midItem -> right = midIndex - 1
        }
    }

    return -1
}