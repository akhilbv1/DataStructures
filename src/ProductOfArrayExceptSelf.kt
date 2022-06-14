fun main() {
    val nums = intArrayOf(1,2,3,4)
    printIntArray(productExceptSelf(nums))
    printIntArray(productExceptSelfFaster(nums))

}

//T:-O(n(n-i))
fun productExceptSelf(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    nums.forEachIndexed { index, i ->//n
        var leftProduct = 1
        var rightProduct = 1
        for (leftIndex in index - 1 downTo 0) {
            leftProduct *= nums[leftIndex]
        }
        for (rightIndex in index + 1..nums.lastIndex) {
            rightProduct *= nums[rightIndex]
        }//n-i
        result.add(leftProduct * rightProduct)
    }
    return result.toIntArray()
}

fun productExceptSelfFaster(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val preFix = IntArray(nums.size)
    val postFix = IntArray(nums.size)

    nums.forEachIndexed { index, i ->
        if(index==0)
            preFix[0] = i
        else {
            preFix[index] = preFix[index-1] * i
        }
    }

    for (postFixIndex in nums.lastIndex downTo 0){
        if(postFixIndex==nums.lastIndex)
            postFix[0] = nums[nums.lastIndex]
        else {
            val accessIndex = nums.lastIndex-postFixIndex
            postFix[accessIndex] = postFix[accessIndex-1] * nums[postFixIndex]
         }
    }
    postFix.reverse()
    nums.forEachIndexed { index, i ->
        val preFixProduct = if(index==0) 1 else preFix[index-1]
        val postFixProduct = if(index==nums.lastIndex) 1 else postFix[index+1]
        result.add(preFixProduct * postFixProduct)
    }

    return result.toIntArray()
}

