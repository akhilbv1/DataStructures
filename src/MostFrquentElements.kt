fun main() {
    val nums = intArrayOf(1)
    val k = 1
    printIntArray(mostFreqElements(nums, k))
}


fun mostFreqElements(nums: IntArray, k: Int): IntArray {
    val mostFreqHashMap: HashMap<Int, Int> = hashMapOf()
    val mostFreqElements = MutableList<MutableList<Int>?>(nums.size+1) { null }
    val res = mutableListOf<Int>()

    nums.forEachIndexed { index, i ->
        mostFreqHashMap[i]?.let {
            mostFreqHashMap[i] = it + 1
        } ?: run {
            mostFreqHashMap[i] = 1
        }
    }//n

    mostFreqElements.forEachIndexed { index, _ ->
        mostFreqHashMap.forEach { entry: Map.Entry<Int, Int> ->
            if (entry.value == index) {
                mostFreqElements[index]?.let {
                    it.add(entry.key)
                } ?: run {
                    mostFreqElements[index] = mutableListOf(entry.key)
                }
            }
        }
    }

    for (i in mostFreqElements.lastIndex downTo 0) {
        mostFreqElements[i]?.let {
            res.addAll(it)
        }
    }//n

    return res.toIntArray()
}