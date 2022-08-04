fun main(){
    //val ip = intArrayOf(1,2,3,4,5,6)
    val ip = intArrayOf(-1,-1,-1)
    print(majorityElement(ip).toList())
    print(majorityElementLinear(ip).toList())
}


//T:-n S:-n
fun majorityElement(nums: IntArray): List<Int> {
    val majorityHashMap: HashMap<Int,Int> = hashMapOf()
    val majorityList: ArrayList<Int> = arrayListOf()
    val targetCount = nums.size/3
    nums.forEach {
        majorityHashMap[it]?.let { value:Int ->
            majorityHashMap[it] =value+1
        }?: run {
            majorityHashMap[it] = 1
        }
    }
    majorityHashMap.forEach {
        if(it.value>targetCount){
            majorityList.add(it.key)
        }
    }
    return majorityList
}

fun majorityElementLinear(nums: IntArray): List<Int>{
    if(nums.size==1) return listOf(nums[0])
    var currentCount = 0
    val majorityList: ArrayList<Int> = arrayListOf()
    val targetCount = nums.size/3
    var lastAddedNumber: Int? = null
    var p1=0
    var p2=1
    nums.sort()
    for (index in nums.indices){
        if(nums[p1]==nums[p2]){
            currentCount+=1
            if(currentCount>targetCount && lastAddedNumber!=nums[p1]){
                majorityList.add(nums[p1])
                lastAddedNumber = nums[p1]
            }
        } else {
            currentCount+=1
            if(currentCount>targetCount && lastAddedNumber!=nums[p1]){
                majorityList.add(nums[p1])
                lastAddedNumber = nums[p1]
            }
            currentCount = 0
        }
        p1+=1
        if(p2<nums.lastIndex)
            p2+=1
        if(p1>nums.lastIndex)break
    }
    return majorityList
}