import kotlin.math.abs

fun main() {
    val ip = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    print(findDuplicates(ip))
}


fun findDuplicates(nums: IntArray): List<Int> {
    val duplicateList = ArrayList<Int>(nums.size)
    nums.forEach {
        val currentAbsoluteValue = abs(it)
        val currentValueByIndex = nums[currentAbsoluteValue - 1]
        if(currentValueByIndex<0){
            duplicateList.add(currentAbsoluteValue)
        }else {
            nums[currentAbsoluteValue-1] = -currentValueByIndex
        }
    }
    return duplicateList
}