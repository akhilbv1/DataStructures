fun main() {
    val ip: Array<IntArray> = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
    val target = 13
    print(searchMatrix(ip, target))
}

//T:Log m * log n
//S:O(1)
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val ROWS = matrix.size
    val COlS = matrix[0].size
    var top = 0
    var bottom = ROWS - 1
    while ( top <= bottom) {
        val row = (top+bottom) / 2
        if (target > matrix[row][matrix[row].lastIndex])
            top = row + 1
        else if(target < matrix[row][0])
            bottom = row - 1
        else break
    }
    if(!(top <= bottom))
        return false
    val row = (top + bottom) / 2
    var left = 0
    var right = COlS - 1
    while (left <= right)
    {
        val mid = (left + right) / 2
        if(target > matrix[row][mid])
            left = mid + 1
        else if(target < matrix[row][mid])
            right = mid - 1
        else return true
    }
    return false
}
