fun main(){
    /*val ip = intArrayOf(2,7,11,15)
    val target = 9*/
    val ip = intArrayOf(12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,
        277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,
        457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,
        809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997)
    val target = 542
    printIntArray(twoSumNew(ip,target))
    printIntArray(twoSum(ip,target))
}


fun twoSumNew(numbers: IntArray, target: Int): IntArray {
    var p1 = 0
    var p2 = numbers.lastIndex

    for (index in numbers.indices){
        if(numbers[p1]+numbers[p2]==target){
           return intArrayOf(p1+1,p2+1)
        }else if(numbers[p2]>target || numbers[p1]+numbers[p2]>target){
            p2-=1
        } else {
            p1+=1
        }
    }

    return intArrayOf()
}