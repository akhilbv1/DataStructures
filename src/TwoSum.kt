
fun main(){
    printIntArray(twoSum(intArrayOf(2,7,11,15),9))
    printIntArray(twoSumFastest(intArrayOf(2,7,11,15),9))
}

//T:-O(n^2)
//S:-O(1)
fun twoSum(nums:IntArray,target:Int):IntArray{
    val array = IntArray(2)
    nums.forEachIndexed { indexI, i ->
        nums.forEachIndexed { indexJ, j ->
            if(i+j==target){
                if(indexI>indexJ){
                    array[0] = indexJ
                    array[1] = indexI
                }else {
                    array[0] = indexI
                    array[1] = indexJ
                }
            }
        }
    }
    return array
}

//T:-O(n)
//S:-O(n)
fun twoSumFastest(nums: IntArray,target: Int):IntArray{
    val diffHashMap = hashMapOf<Int,Int>()
    nums.forEachIndexed { index, numsElement ->
        val diff = target-numsElement
        diffHashMap[diff]?.let {
            return intArrayOf(it,index)
        }?: run {
            diffHashMap[numsElement] = index
        }
    }
    return intArrayOf()
}


