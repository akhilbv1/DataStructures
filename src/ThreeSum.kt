fun main() {
    val ip = intArrayOf(34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49)
    //val ip = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    val answer = listOf(listOf(-82,-11,93),listOf(-82,13,69),listOf(-82,17,65),listOf(-82,21,61),listOf(-82,26,56),listOf(-82,33,49),listOf(-82,34,48),listOf(-82,36,46),listOf(-70,-14,84),listOf(-70,-6,76),listOf(-70,1,69),listOf(-70,13,57),listOf(-70,15,55),listOf(-70,21,49),listOf(-70,34,36),listOf(-66,-11,77),listOf(-66,-3,69),listOf(-66,1,65),listOf(-66,10,56),listOf(-66,17,49),listOf(-49,-6,55),listOf(-49,-3,52),listOf(-49,1,48),listOf(-49,2,47),listOf(-49,13,36),listOf(-49,15,34),listOf(-49,21,28),listOf(-43,-14,57),listOf(-43,-6,49),listOf(-43,-3,46),listOf(-43,10,33),listOf(-43,12,31),listOf(-43,15,28),listOf(-43,17,26),listOf(-29,-14,43),listOf(-29,1,28),listOf(-29,12,17),listOf(-14,-3,17),listOf(-14,1,13),listOf(-14,2,12),listOf(-11,-6,17),listOf(-11,1,10),listOf(-3,1,2))
    println(threeSum(ip))
    println(answer)
    print(checkIfArrayHasDuplicates(arrayListOf(arrayListOf(-70, 15, 55)), intArrayOf(-70, 15, 55)))
}

//T:nlogn+n(n+1(a))
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    nums.sort()//nlogn
    for (index in nums.indices) {//n(n+1(a))
        val isValidIndex = if (index == 0) true else nums[index] != nums[index - 1]
        if (isValidIndex) {
            val possibleList = twoSumForThreeSum(nums, index, index + 1)//n*(a(a is the number of triplets pairs))
            if (possibleList.isNotEmpty()) {
                possibleList.forEach {
                    result.add(it)
                }
            }
        }
    }
    return result
}

private fun twoSumForThreeSum(numbers: IntArray, a: Int, fromIndex: Int): ArrayList<ArrayList<Int>> {
    var b = fromIndex
    var c = numbers.lastIndex
    val result: ArrayList<ArrayList<Int>> = arrayListOf()
    val target = 0

    for (index in numbers.indices) {//n
        if (index >= fromIndex) {
            if (b >= c)
                break
            val sum = numbers[a] + numbers[b] + numbers[c]
            if (sum == target) {
                val isDuplicates = checkIfArrayHasDuplicates(result,intArrayOf(numbers[a] , numbers[b] , numbers[c]))
                if (!isDuplicates){
                    result.add(arrayListOf(numbers[a] , numbers[b] , numbers[c]))
                }
                b += 1
                c -= 1
            } else if (sum < target) {
                b += 1
            } else {
                c -= 1
            }
        }
    }

    return result
}

fun checkIfArrayHasDuplicates(result: ArrayList<ArrayList<Int>>, newArray: IntArray): Boolean {//a
    for (index in result.indices) {
     if(result[index][0]==newArray[0] && result[index][1]==newArray[1] && result[index][2]==newArray[2])
         return true
    }
    return false
}