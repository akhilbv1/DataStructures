import kotlin.math.max
import kotlin.math.min

fun main() {
    // val ip = intArrayOf(7, 1, 5, 3, 6, 4)
    val ip = intArrayOf(2, 1, 4)
    println(maxProfit(ip))
    println(maxProfitFastest(ip))
}

fun maxProfitFastest(prices: IntArray): Int {
    if (prices.isEmpty() || prices.size==1) return 0
    var p1 = 0
    var p2 = 1
    var maxProfit = 0
    while (p2 <= prices.lastIndex) {
        if(prices[p1]<prices[p2]){
            val profitAtInd = prices[p2] - prices[p1]
            maxProfit = max(maxProfit, profitAtInd)
            p2+=1
        }else{
            p1=p2
            p2+=1
        }
    }
    return maxProfit
}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    prices.forEachIndexed { index, i ->
        var maxProfitAtInd = 0
        for (subIndex in index..prices.lastIndex) {
            val profitAtInd = prices[subIndex] - i
            maxProfitAtInd = max(maxProfitAtInd, profitAtInd)
        }
        maxProfit = max(maxProfit, maxProfitAtInd)
    }
    return maxProfit
}