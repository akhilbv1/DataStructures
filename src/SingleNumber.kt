fun main() {
    val ip = intArrayOf(3,3,1,2,1,2)
    //print(singleNumber(ip))
    print(1.xor(1))
    var res:Int = 0
    ip.forEach {
        val value: Int = res.xor(it)
        println("$res.xor$it==$value")
        res = value
    }
    println("ans:-$res")
}

private fun singleNumber(nums: IntArray): Int {
    var p1 = nums[0]
    var result = nums[0]
    for ((index, i) in nums.withIndex()) {
        if(index>0) {
            if (p1.or(i) != i) {
                result = p1
                break
            }
            p1 = nums[index]
        }
    }
    return result
}