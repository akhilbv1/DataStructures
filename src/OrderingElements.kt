fun main() {
    val ip = intArrayOf(1, 0, 0, -1, -1, 0, 1)
    val order = intArrayOf(0,1, -1)
    val answer = threeSort(ip, order)
    answer.forEachIndexed { index, i ->
        if (index == answer.lastIndex) {
            print("$i")
        } else {
            print("$i,")
        }
    }
}


fun threeSortSlow(ip: IntArray, order: IntArray): IntArray {
    val answerArray = arrayListOf<Int>()
    order.forEach {
        ip.forEachIndexed { index, i ->
            if (it == i) {
                answerArray.add(i)
            }
        }
    }
    return answerArray.toIntArray()
}

fun threeSort(ip: IntArray, order: IntArray): IntArray {
    val first = order[0]
    val middle = if(order.lastIndex>0)order[1]else null
    var lastPlacedPosition = -1
    //for first item
    ip.forEachIndexed { index, it ->
        if (it == first) {
            when {
                lastPlacedPosition != -1 -> {
                    if (lastPlacedPosition + 1 < ip.lastIndex && lastPlacedPosition + 2 < ip.lastIndex) {
                        val temp = ip[lastPlacedPosition + 1]
                        ip[lastPlacedPosition + 1] = it
                        ip[index] = temp
                        lastPlacedPosition += 1
                    }

                }
                else -> {
                    val temp = ip[0]
                    ip[0] = it
                    lastPlacedPosition = 0
                    ip[lastPlacedPosition + 1] = temp
                }
            }
        }
    }
    middle?.let {
        ip.forEachIndexed { index, it ->
            if (index > lastPlacedPosition) {
                if (it == middle) {
                    when {
                        lastPlacedPosition != -1 -> {
                            if (lastPlacedPosition + 1 < ip.lastIndex && lastPlacedPosition + 2 < ip.lastIndex) {
                                val temp = ip[lastPlacedPosition + 1]
                                ip[lastPlacedPosition + 1] = it
                                ip[index] = temp
                                lastPlacedPosition += 1
                            }

                        }
                        else -> {
                            val temp = ip[0]
                            ip[0] = it
                            lastPlacedPosition = 0
                            ip[lastPlacedPosition + 1] = temp
                        }
                    }
                }
            }
        }
    }
    return ip
}
