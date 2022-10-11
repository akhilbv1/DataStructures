import java.math.BigInteger
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.roundToInt

fun main() {
    //val ip = intArrayOf(332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184)
    val ip = intArrayOf(3,7,6,11)
    //val h  = 823855818
    val h  = 8
    println(minEatingSpeed(ip,h))
    //print(ceil(7.0/3.0).toInt())
}


private fun minEatingSpeed(piles: IntArray, h: Int): Int {
    val max:Int = getMax(piles) //n
    var result = max
    var left = 1
    var right = max

    while (left < right) {
        val k = (left + right) / 2
        var hours = 0
        piles.forEach {
            hours += ceil(it.toDouble()/k.toDouble()).toInt()
        }
        if(hours <= h) {
            result = min(result, k)
            right = k - 1
        } else {
            left = k + 1
        }
    }

    return result
}

private fun getMax(piles: IntArray): Int {
    var currentMax = piles[0]
    piles.forEach {
        if(it>currentMax)
            currentMax = it
    }
    return currentMax
}