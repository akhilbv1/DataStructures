//leetcode:-https://leetcode.com/problems/contains-duplicate/

fun main() {
    val nums = intArrayOf(1,2,3)
    print(containsDuplicate(nums))
}

//time:-O(n)
fun containsDuplicate(nums: IntArray): Boolean {
    val prevHashmap:HashMap<Int,Int> = hashMapOf()
    nums.forEach {
        prevHashmap[it]?.let {
            return true
        }?: run {
            prevHashmap[it] = it
        }
    }
    return false
}

/*fun containsDuplicate(ip: IntArray): Boolean {
    if (ip.isEmpty() || ip.size == 1) return false
    var runningIndex = 1
    val sortedArray = ip.sorted()
    sortedArray.forEach {
        if (it == sortedArray[runningIndex]) {
            return true
        } else {
            runningIndex += 1
            if (runningIndex > ip.lastIndex)
                return false
        }
    }
    return false
}*/
