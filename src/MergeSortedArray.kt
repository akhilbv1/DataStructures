//leetcode link:-https://leetcode.com/problems/merge-sorted-array/

fun main() {
//nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    val num1 = intArrayOf(1,2,3,0,0,0)
    val num2 = intArrayOf(2,5,6)
    val m = 3
    val n = 3
    mergeSortedArrays(num1,m,num2,n)
    print(num1.toList())
}

fun mergeSortedArrays(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var nInd = m
    for (i in 0 until n) {
        nums1[nInd] = nums2[i]
        nInd += 1
    }
    nums1.sort()
}