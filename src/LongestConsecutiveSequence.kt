import kotlin.math.max

fun main(){
    //val nums = intArrayOf(100,4,200,1,3,2)
    //val nums = intArrayOf(1,4,7,9)
    val nums = intArrayOf(0,3,7,2,5,8,4,6,0,1)
    print(longestConsecutive(nums))
}

//T:-n S:-n
fun longestConsecutive(nums: IntArray): Int {
    var longestSeq = 0
    val set: MutableSet<Int> = nums.toMutableSet()
    nums.forEach {
        set.add(it)
    }
    nums.forEach {
       if(set.contains(it)){
          var length = 0
           while (set.contains(it+length)){
              length+=1
           }
           longestSeq = max(longestSeq,length)
       }
    }
    return longestSeq
}