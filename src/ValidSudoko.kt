fun main() {
    /*val sudoko = arrayOf(
        charArrayOf(
            '5', '3', '.', '.', '7', '.', '.', '.', '.',
            '6', '.', '.', '1', '9', '5', '.', '.', '.',
            '.', '9', '8', '.', '.', '.', '.', '6', '.',
            '8', '.', '.', '.', '6', '.', '.', '.', '3',
            '4', '.', '.', '8', '.', '3', '.', '.', '1',
            '7', '.', '.', '.', '2', '.', '.', '.', '6',
            '.', '6', '.', '.', '.', '.', '2', '8', '.',
            '.', '.', '.', '4', '1', '9', '.', '.', '5',
            '.', '.', '.', '.', '8', '.', '.', '7', '9'
        )
    )*/
    /*00 10 20
    * 01 11 21
    * 02 12 22*/

    val sudoko = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '1', '.', '.', '.', '.', '6', '.'),
        charArrayOf('1', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    print(isValidSudoku(sudoko))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    //row
    val isRowVerified = checkRow(board)
    val isColumnVerified = checkColumn(board)
    val isAllSubMatricesVerified = checkAllSubMatrices(board)
    return when {
        !isRowVerified -> false
        !isColumnVerified -> false
        !isAllSubMatricesVerified -> false
        else -> return true
    }
}

private fun checkRow(board: Array<CharArray>): Boolean {
    val rowHashMap: HashMap<Char, Int> = hashMapOf()
    for (p1 in board) {
        for (p2 in p1) {
            if (p2.isDigit()) {
                rowHashMap[p2]?.let {
                    print(p2)
                    return false
                } ?: run {
                    rowHashMap[p2] = 1
                }
            }
        }
        rowHashMap.clear()
    }
    return true
}

private fun checkColumn(board: Array<CharArray>): Boolean {
    var i = 0
    var j: Int
    val rowHashMap: HashMap<Char, Int> = hashMapOf()
    for (p1 in 0..8) {
        j = 0
        for (p2 in 0..8) {
            val element = board[j][i]
            if (element.isDigit()) {
                rowHashMap[element]?.let {
                    print(element)
                    return false
                } ?: run {
                    rowHashMap[element] = 1
                }
            }
            j += 1
        }
        i += 1
        rowHashMap.clear()
    }
    return true
}

private fun checkAllSubMatrices(board: Array<CharArray>):Boolean {
    val subHashMap: HashMap<Pair<Int, Int>, HashSet<Char>> = hashMapOf()

    for ((index,chars) in board.withIndex()){
        for ((charIndex,c) in chars.withIndex()){
            if(c.isDigit()){
                val first = (index/3)
                val second = charIndex/3
                subHashMap[Pair(first,second)]?.let {
                    val isDuplicate = it.add(c)
                       if(!isDuplicate) return false
                }?:run {
                    subHashMap[Pair(first,second)] = hashSetOf(c)
                }
            }
        }
    }
    return true
}