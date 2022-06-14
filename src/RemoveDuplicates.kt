//leetcode:-https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

fun main() {
    //val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    //val nums = intArrayOf(1, 1, 1, 1)
    val nums = intArrayOf(1,1,1,2,2,3)
    //print(removeDuplicates(nums))
    print("${removeDuplicatesOptimized(nums)},${nums.toList()}")
}

//tc:-O(n) O(n)
fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val infoHashMap: MutableMap<Int, Int> = mutableMapOf()
    nums.forEach { num: Int ->
        infoHashMap[num]?.let {
            infoHashMap.put(num, it + 1)
        } ?: run {
            infoHashMap[num] = 1
        }
    }
    var count = 0
    infoHashMap.entries.forEach {
        count += if (it.value > 2) {
            2
        } else it.value
    }
    return count
}

fun removeDuplicatesOptimized(nums: IntArray): Int {
    var n = nums.size
    if (n < 3) return n
    var s = 2
    var f = 2
    while (f < n) {
        if(nums[f]!=nums[s-2]){
            nums[s++] = nums[f]
        }
        f+=1
    }
    return s
}


/*fun removeDuplicatesOptimized(nums: IntArray): Int {
    var p1 = 0
    val infoHashMap: MutableMap<Int, Int> = mutableMapOf()
    var arr = nums
    var restructureCount  = 0
    while (p1 <= nums.lastIndex) {
        val item = arr[p1]
        infoHashMap[item]?.let {
            val repeatedCount = it + 1
            infoHashMap[item] = repeatedCount
            if (repeatedCount > 2 ) {
                if(restructureCount==0 || p1<(arr.lastIndex-restructureCount)){
                    arr = restructureArray(arr, p1)
                    restructureCount+=1
                }
            } else {
                p1 += 1
            }
        } ?: run {
            infoHashMap[item] = 1
            p1 += 1
        }
    }
    return arr.size - restructureCount
}*/

fun restructureArray(nums: IntArray, restructureIndex: Int): IntArray {
    nums.forEachIndexed { index, i ->
        if (index >= restructureIndex && index != nums.lastIndex) {
            val temp = nums[index]
            nums[index] = nums[index + 1]
            nums[index + 1] = temp
        }
    }
    return nums
}