/*
import kotlin.math.max

fun main() {
    val ip = intArrayOf(1, 5, 0, 3, 5)
    //println(minimumOperations(ip))
    println(minimumOperationsFast(ip))
}

//T:- nlogn+n^2
private fun minimumOperations(nums: IntArray): Int {
    nums.sort()//nlogn
    var x = getSmallestNonZero(nums)
    var count = 0
    while (nums.any { it > 0 }) {//n
        for (index in nums.indices) {//n
            if (nums[index] > 0) {
                val diff = nums[index] - x
                nums[index] = if (diff > 0) diff else 0
            }
        }
        x = getSmallestNonZero(nums)
        count += 1
    }
    return count
}


private fun getSmallestNonZero(nums: IntArray): Int {
    return if (nums.last() == 0) 0
    else {
        nums.firstOrNull { it > 0 } ?: 0
    }
}


private fun minimumOperationsFast(nums: IntArray): Int {
    val elementsHashMap:HashSet<Int,Int> = hashMapOf()
    nums.forEach { element:Int ->
       if(element>0){
           elementsHashMap[element]?.let {
               elementsHashMap[element]=it+1
           }?: run{
               elementsHashMap[element] = 1
           }
       }
    }
    return elementsHashMap.size
}*/
